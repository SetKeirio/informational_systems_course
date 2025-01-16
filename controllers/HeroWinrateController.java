package informational_systems.course.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import informational_systems.course.items.HeroPredictionRequest;
import informational_systems.course.items.HeroWinRate;
import informational_systems.course.items.HeroWinRateResponse;
import informational_systems.course.services.HeroWinRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

@RestController
@RequestMapping("/herowinrates")
public class HeroWinrateController {

    @Autowired
    private Environment env;

    @Autowired
    private HeroWinRateService heroWinrateService;

    // Получить все винрейты героев по позициям
    @GetMapping
    public List<HeroWinRateResponse> getAllHeroWinrates() {
        return heroWinrateService.getAllHeroWinRatesDTO();
    }

    // Получить винрейт героя по ID
    @GetMapping("/{heroId}/{position}")
    public HeroWinRate getHeroWinrateById(@PathVariable Integer heroId, @PathVariable int position) {
        return heroWinrateService.getHeroWinRateById(heroId);
    }

    @GetMapping("/position/{positionId}")
    public List<HeroWinRate> getHeroesByPosition(@PathVariable int positionId) {
        return heroWinrateService.getHeroesByPositionSortedByWinRate(positionId);
    }

    @GetMapping("/reset")
    public void reserHeroWinrate() {
        String csvTable = env.getProperty("csv.all-winrates");
        try {
            heroWinrateService.parseCsvAndSaveData(csvTable);
        }
        catch (Exception e){e.printStackTrace();};
        return;
    }

    @GetMapping("/winrates/{patch}")
    public void winratesHeroWinrate(@PathVariable String patch) {
        // Формируем путь к CSV файлу в зависимости от патча
        String csvTable = env.getProperty("csv.character-winrates") + patch + ".csv"; // Путь с учетом патча
        try {
            heroWinrateService.parseCsvAndSaveHeroWinRates(csvTable, patch); // Передаем путь и патч
        } catch (Exception e) {
            e.printStackTrace(); // Логирование ошибки
        }
        return;
    }

    @PostMapping("/predict")
    public ResponseEntity<String> predict(@RequestBody HeroPredictionRequest predictionRequest) {
        try {
            // Формируем команду для Python скрипта с параметрами
            StringBuilder command = new StringBuilder("python C:\\Users\\Enzolio\\Downloads\\py\\encode.py --predict 1");

            // Добавляем параметры для Radiant
            for (int i = 0; i < predictionRequest.getRadiantHeroes().size(); i++) {
                command.append(" --radiantHero").append(i + 1).append(" ").append(predictionRequest.getRadiantHeroes().get(i));
                command.append(" --radiantPosition").append(i + 1).append(" ").append(predictionRequest.getRadiantPositions().get(i));
            }

            // Добавляем параметры для Dire
            for (int i = 0; i < predictionRequest.getDireHeroes().size(); i++) {
                command.append(" --direHero").append(i + 1).append(" ").append(predictionRequest.getDireHeroes().get(i));
                command.append(" --direPosition").append(i + 1).append(" ").append(predictionRequest.getDirePositions().get(i));
            }

            // Запуск Python скрипта
            Process process = Runtime.getRuntime().exec(command.toString());
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line;

            // Чтение вывода Python скрипта
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            // Ожидание завершения процесса
            process.waitFor();

            // Возвращаем результат
            return ResponseEntity.ok(output.toString());

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error during prediction", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/position/{team}")
    public ResponseEntity<String> position(@RequestBody HeroPredictionRequest predictionRequest, @PathVariable int team) {
        try {
            // Формируем команду для Python скрипта с параметрами
            StringBuilder command;
            if ((team != 1) && (team != 2)){
                throw new RuntimeException();
            }
            if (team == 1) {
                command = new StringBuilder("python C:\\Users\\Enzolio\\Downloads\\py\\encode.py --position 1 --radiant 1");
            }
            else {
                command = new StringBuilder("python C:\\Users\\Enzolio\\Downloads\\py\\encode.py --position 1 --radiant 0");
            }
            // Добавляем параметры для Radiant
            for (int i = 0; i < predictionRequest.getRadiantHeroes().size(); i++) {
                command.append(" --radiantHero").append(i + 1).append(" ").append(predictionRequest.getRadiantHeroes().get(i));
                command.append(" --radiantPosition").append(i + 1).append(" ").append(predictionRequest.getRadiantPositions().get(i));
            }

            // Добавляем параметры для Dire
            for (int i = 0; i < predictionRequest.getDireHeroes().size(); i++) {
                command.append(" --direHero").append(i + 1).append(" ").append(predictionRequest.getDireHeroes().get(i));
                command.append(" --direPosition").append(i + 1).append(" ").append(predictionRequest.getDirePositions().get(i));
            }

            // Запуск Python скрипта
            Process process = Runtime.getRuntime().exec(command.toString());
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line;

            // Чтение вывода Python скрипта
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            // Ожидание завершения процесса
            process.waitFor();
            String result = output.toString().trim();
            result = result.replaceAll("'", "\""); // Замена одинарных кавычек на двойные (если необходимо)

            // Парсинг строки в JSON (с помощью ObjectMapper)
            ObjectMapper objectMapper = new ObjectMapper();
            List<List<Object>> responseList = objectMapper.readValue(result, List.class);

            // Возвращаем результат как JSON
            return ResponseEntity.ok(objectMapper.writeValueAsString(responseList));

            // Возвращаем результат*/
            //return ResponseEntity.ok(output.toString());

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error during position", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/character")
    public ResponseEntity<String> character(@RequestBody HeroPredictionRequest predictionRequest) {
        try {
            // Формируем команду для Python скрипта с параметрами
            StringBuilder command = new StringBuilder("python C:\\Users\\Enzolio\\Downloads\\py\\encode.py --character 1 --radiant 1 --role 1");

            // Добавляем параметры для Radiant
            for (int i = 0; i < predictionRequest.getRadiantHeroes().size(); i++) {
                command.append(" --radiantHero").append(i + 1).append(" ").append(predictionRequest.getRadiantHeroes().get(i));
                command.append(" --radiantPosition").append(i + 1).append(" ").append(predictionRequest.getRadiantPositions().get(i));
            }

            // Добавляем параметры для Dire
            for (int i = 0; i < predictionRequest.getDireHeroes().size(); i++) {
                command.append(" --direHero").append(i + 1).append(" ").append(predictionRequest.getDireHeroes().get(i));
                command.append(" --direPosition").append(i + 1).append(" ").append(predictionRequest.getDirePositions().get(i));
            }

            // Запуск Python скрипта
            Process process = Runtime.getRuntime().exec(command.toString());
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line;

            // Чтение вывода Python скрипта
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            // Ожидание завершения процесса
            process.waitFor();

            // Возвращаем результат
            return ResponseEntity.ok(output.toString());

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error during position", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}

