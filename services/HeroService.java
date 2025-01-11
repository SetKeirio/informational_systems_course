package informational_systems.course.services;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import informational_systems.course.items.Hero;
import informational_systems.course.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Service
public class HeroService {

    @Autowired
    private HeroRepository heroRepository;

    // Получить все героев
    public List<Hero> getAllHeroes() {
        return heroRepository.findAll();
    }

    // Получить героя по ID
    public Hero getHeroById(Integer id) {
        return heroRepository.findById(id).orElse(null);
    }

    // Создать нового героя
    public Hero createHero(Hero hero) {
        return heroRepository.save(hero);
    }

    // Обновить героя
    public Hero updateHero(Integer id, Hero heroDetails) {
        Hero hero = heroRepository.findById(id).orElse(null);
        if (hero != null) {
            hero.setName(heroDetails.getName());
            hero.setStrength(heroDetails.getStrength());
            hero.setAgility(heroDetails.getAgility());
            hero.setIntelligence(heroDetails.getIntelligence());
            hero.setSkill1(heroDetails.getSkill1());
            hero.setSkill2(heroDetails.getSkill2());
            hero.setSkill3(heroDetails.getSkill3());
            hero.setSkill4(heroDetails.getSkill4());
            return heroRepository.save(hero);
        }
        return null;
    }

    // Удалить героя
    public void deleteHero(Integer id) {
        heroRepository.deleteById(id);
    }
}
