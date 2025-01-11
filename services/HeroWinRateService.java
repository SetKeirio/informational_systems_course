package informational_systems.course.services;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import informational_systems.course.items.Hero;
import informational_systems.course.items.HeroAgainstWinRate;
import informational_systems.course.items.HeroWinRate;
import informational_systems.course.items.HeroWithWinRate;
import informational_systems.course.repository.HeroAgainstWinRateRepository;
import informational_systems.course.repository.HeroRepository;
import informational_systems.course.repository.HeroWinRateRepository;
import informational_systems.course.repository.HeroWithWinRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HeroWinRateService {

    @Autowired
    private HeroWinRateRepository heroWinRateRepository;

    @Autowired
    private HeroWithWinRateRepository heroWithWinrateRepository;

    @Autowired
    private HeroAgainstWinRateRepository heroAgainstWinrateRepository;

    @Autowired
    private HeroRepository heroRepository;

    // Получить все винрейты героев
    public List<HeroWinRate> getAllHeroWinRates() {
        return heroWinRateRepository.findAll();
    }

    // Получить винрейт героя по ID
    public HeroWinRate getHeroWinRateById(Integer heroId) {
        return heroWinRateRepository.findById(heroId).orElse(null);
    }

    // Создать новый винрейт героя
    public HeroWinRate createHeroWinRate(HeroWinRate heroWinRate) {
        return heroWinRateRepository.save(heroWinRate);
    }

    // Обновить винрейт героя
    public HeroWinRate updateHeroWinRate(Integer heroId, HeroWinRate heroWinRateDetails) {
        HeroWinRate heroWinRate = heroWinRateRepository.findById(heroId).orElse(null);
        if (heroWinRate != null) {
            heroWinRate.setWinrate(heroWinRateDetails.getWinrate());
            heroWinRate.setMatches(heroWinRateDetails.getMatches());
            return heroWinRateRepository.save(heroWinRate);
        }
        return null;
    }

    public List<HeroWinRate> getHeroesByPositionSortedByWinRate(int positionId) {
        List<HeroWinRate> winRates = heroWinRateRepository.findByPosition(positionId);

        // Проходим по каждому элементу и заменяем heroId на имя героя
        for (HeroWinRate winRate : winRates) {
            Hero hero = heroRepository.findById((winRate.getHero().getId()).intValue()).orElse(null);
            if (hero != null) {
                winRate.setHero(hero);  // Устанавливаем имя героя
            }
        }

        // Сортируем по винрейту по убыванию
        return winRates.stream()
                .sorted((wr1, wr2) -> Double.compare(wr2.getWinrate(), wr1.getWinrate()))  // Сортировка по убыванию винрейта
                .collect(Collectors.toList());
    }

    public void parseCsvAndSaveData(String csvFilePath) throws IOException, CsvException {
        csvFilePath = "C:\\Users\\Enzolio\\Downloads\\py\\csv\\winrates_and_huge_eggs_with_pancakes.csv";
        CSVReader csvReader = new CSVReader(new FileReader(csvFilePath));
        List<String[]> allData = csvReader.readAll();
        allData.remove(0);

        int[] withIndices = {
                2, 3, 4, 5,   // MidWithOffLane, MidWithSemiSupport, MidWithFullSupport, MidWithCarry
                6, 7, 8, 9,   // OffLaneWithMid, OffLaneWithSemiSupport, OffLaneWithFullSupport, OffLaneWithCarry
                10, 11, 12, 13, // SemiSupportWithMid, SemiSupportWithOffLane, SemiSupportWithFullSupport, SemiSupportWithCarry
                14, 15, 16, 17, // FullSupportWithMid, FullSupportWithOffLane, FullSupportWithSemiSupport, FullSupportWithCarry
                18, 19, 20, 21, // CarryWithMid, CarryWithOffLane, CarryWithSemiSupport, CarryWithFullSupport
        };

        // Индексы колонок для "Against" комбинаций
        int[] againstIndices = {
                22, 23, 24, 25, // MidAgainstMid, MidAgainstOffLane, MidAgainstSemiSupport, MidAgainstFullSupport
                26, 27, 28, 29, // OffLaneAgainstMid, OffLaneAgainstOffLane, OffLaneAgainstSemiSupport, OffLaneAgainstFullSupport
                30, 31, 32, 33, // SemiSupportAgainstMid, SemiSupportAgainstOffLane, SemiSupportAgainstSemiSupport, SemiSupportAgainstFullSupport
                34, 35, 36, 37, // FullSupportAgainstMid, FullSupportAgainstOffLane, FullSupportAgainstSemiSupport, FullSupportAgainstFullSupport
                38, 39, 40, 41, 42, 43, 44, 45, 46  // CarryAgainstMid, CarryAgainstOffLane, CarryAgainstSemiSupport, CarryAgainstFullSupport
        };

        for (String[] row : allData) {
            String hero1Name = row[0];
            String hero2Name = row[1];

            // Загрузка героев из базы данных по их именам
            Hero hero1 = heroRepository.findByName(hero1Name).orElse(null);
            Hero hero2 = heroRepository.findByName(hero2Name).orElse(null);

            if (hero1 == null || hero2 == null){
                continue;
            }

            for (int i = 0; i < withIndices.length; i++) {
                int role1, role2;
                role1 = 0;
                role2 = 0;
                if (i <= 3){
                    role1 = 2;
                }
                else if (i <= 7){
                    role1 = 3;
                }
                else if (i <= 11){
                    role1 = 4;
                }
                else if (i <= 15){
                    role1 = 5;
                }
                else{
                    role1 = 1;
                }
                if (i == 0 || i == 9 || i == 13 || i == 17){
                    role2 = 3;
                }
                else if (i == 1 || i == 5 || i == 14 || i == 18){
                    role2 = 4;
                }
                else if (i == 4 || i == 8 || i == 12 || i == 16) {
                    role2 = 2;
                }
                else if (i == 3 || i == 7 || i == 11 || i == 15){
                    role2 = 1;
                }
                else {
                    role2 = 5;
                }
                saveHeroWithWinrate(hero1, hero2, role1, role2, Float.parseFloat(row[withIndices[i]]), 100,
                        Integer.valueOf((int) (100 * Float.parseFloat(row[withIndices[i]]))),
                        Integer.valueOf((int) (100 * (1 - Float.parseFloat(row[withIndices[i]])))));
            }

            for (int i = 0; i < againstIndices.length; i++) {
                int role1, role2;
                role1 = 0;
                role2 = 0;
                if (i <= 4){
                    role1 = 2;
                }
                else if (i <= 9){
                    role1 = 3;
                }
                else if (i <= 14){
                    role1 = 4;
                }
                else if (i <= 19){
                    role1 = 5;
                }
                else{
                    role1 = 1;
                }
                if (i == 1 || i == 6 || i == 11 || i == 16 || i == 21){
                    role2 = 3;
                }
                else if (i == 2 || i == 7 || i == 12 || i == 17 || i == 22){
                    role2 = 4;
                }
                else if (i == 0 || i == 5 || i == 10 || i == 15 || i == 20) {
                    role2 = 2;
                }
                else if (i == 4 || i == 9 || i == 14 || i == 19 || i == 24){
                    role2 = 1;
                }
                else {
                    role2 = 5;
                }
                saveHeroAgainstWinrate(hero1, hero2, role1, role2, Float.parseFloat(row[againstIndices[i]]), 100,
                        Integer.valueOf((int) (100 * Float.parseFloat(row[againstIndices[i]]))),
                        Integer.valueOf((int) (100 * (1 - Float.parseFloat(row[againstIndices[i]])))));
            }
        }

        csvReader.close();
    }

    private void saveHeroWithWinrate(Hero hero1, Hero hero2, int position1, int position2, float winrate, int matches, int wins, int loses) {
        HeroWithWinRate heroWithWinrate = new HeroWithWinRate();
        heroWithWinrate.setHero1(hero1);
        heroWithWinrate.setHero2(hero2);
        heroWithWinrate.setPosition1(position1);
        heroWithWinrate.setPosition2(position2);
        heroWithWinrate.setWinrate(winrate);
        heroWithWinrate.setMatches(matches);
        heroWithWinrate.setWins(wins);
        heroWithWinrate.setLoses(loses);

        heroWithWinrateRepository.save(heroWithWinrate);
    }

    private void saveHeroAgainstWinrate(Hero hero1, Hero hero2, int position1, int position2, float winrate, int matches, int wins, int loses) {
        HeroAgainstWinRate heroAgainstWinrate = new HeroAgainstWinRate();
        heroAgainstWinrate.setHero1(hero1);
        heroAgainstWinrate.setHero2(hero2);
        heroAgainstWinrate.setPosition1(position1);
        heroAgainstWinrate.setPosition2(position2);
        heroAgainstWinrate.setWinrate(winrate);
        heroAgainstWinrate.setMatches(matches);
        heroAgainstWinrate.setWins(wins);
        heroAgainstWinrate.setLoses(loses);

        heroAgainstWinrateRepository.save(heroAgainstWinrate);
    }

    // Удалить винрейт героя
    public void deleteHeroWinRate(Integer heroId) {
        heroWinRateRepository.deleteById(heroId);
    }

    public void parseCsvAndSaveHeroWinRates(String csvFilePath) throws IOException, CsvException {
        csvFilePath = "C:\\Users\\Enzolio\\Downloads\\py\\csv\\character_winrate_and_huge_eggs_with_pancakes.csv";
        CSVReader csvReader = new CSVReader(new FileReader(csvFilePath));
        List<String[]> allData = csvReader.readAll();
        allData.remove(0); // Удаляем заголовок

        // Маппинг позиций
        // 1 - Carry, 2 - Mid, 3 - OffLane, 4 - SemiSupport, 5 - FullSupport
        for (String[] row : allData) {
            String heroName = row[0];  // Имя героя
            Hero hero = heroRepository.findByName(heroName).orElse(null);

            if (hero == null) {
                continue; // Пропускаем, если героя нет в базе
            }

            // Парсим винрейты для каждой позиции
            saveHeroWinRateForPosition(hero, 1, Float.parseFloat(row[2]), "7.37e");  // Carry
            saveHeroWinRateForPosition(hero, 2, Float.parseFloat(row[3]), "7.37e");  // Mid
            saveHeroWinRateForPosition(hero, 3, Float.parseFloat(row[4]), "7.37e");  // OffLane
            saveHeroWinRateForPosition(hero, 4, Float.parseFloat(row[5]), "7.37e");  // SemiSupport
            saveHeroWinRateForPosition(hero, 5, Float.parseFloat(row[6]), "7.37e");  // FullSupport
        }

        csvReader.close();
    }

    // Метод для сохранения винрейта героя для конкретной позиции
    private void saveHeroWinRateForPosition(Hero hero, int position, float winrate, String patch) {
        winrate = winrate / 100;
        int matches = 100;  // Всегда 100 матчей
        int wins = (int) (winrate * 100);  // Количество побед
        int loses = 100 - wins;  // Количество поражений

        HeroWinRate heroWinRate = new HeroWinRate();
        heroWinRate.setHero(hero);
        heroWinRate.setPosition(position);
        heroWinRate.setWinrate((float) winrate);  // Преобразуем в диапазон от 0 до 1
        heroWinRate.setMatches(matches);
        heroWinRate.setWins(wins);
        heroWinRate.setLoses(loses);
        heroWinRate.setPatch(patch);

        heroWinRateRepository.save(heroWinRate);
    }
}
