package informational_systems.course.services;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import informational_systems.course.items.HeroItemUsage;
import informational_systems.course.repository.HeroItemUsageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Service
public class HeroItemUsageService {

    @Autowired
    private HeroItemUsageRepository heroItemUsageRepository;

    // Метод для парсинга CSV и сохранения данных в таблицу hero_item_usage
    public void parseCsvAndSaveHeroItemUsage(String csvFilePath) throws IOException, CsvException {
        csvFilePath = "C:\\Users\\Enzolio\\Downloads\\py\\csv\\itemstats_and_huge_eggs_with_pancakes.csv";
        CSVReader csvReader = new CSVReader(new FileReader(csvFilePath));
        List<String[]> allData = csvReader.readAll();
        allData.remove(0); // Удаляем заголовок

        // Читаем строки и сохраняем данные в таблицу hero_item_usage
        for (String[] row : allData) {
            HeroItemUsage heroItemUsage = new HeroItemUsage();
            heroItemUsage.setHeroName(row[0]);
            heroItemUsage.setItemName(row[1]);
            int position = 0;
            if (row[2].equals("Carry")){
                position = 1;
            }
            else if (row[2].equals("Mid")){
                position = 2;
            }
            else if (row[2].equals("Off Lane")){
                position = 3;
            }
            else if (row[2].equals("Semi Support")){
                position = 4;
            }
            else if (row[2].equals("Full Support")){
                position = 5;
            }
            heroItemUsage.setPosition(position);
            heroItemUsage.setPickRate(Double.parseDouble(row[3]));
            heroItemUsage.setTiming(row[4]);
            heroItemUsage.setCount(Integer.parseInt(row[5]));

            heroItemUsageRepository.save(heroItemUsage);
        }

        csvReader.close();
    }

    public List<HeroItemUsage> getHeroItemUsageByHeroAndPosition(String heroName, int position) {
        return heroItemUsageRepository.findByHeroNameAndPosition(heroName, position);
    }
}
