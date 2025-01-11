package informational_systems.course.services;

import informational_systems.course.items.HeroWithWinRate;
import informational_systems.course.repository.HeroWithWinRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroWithWinRateService {

    @Autowired
    private HeroWithWinRateRepository heroWithWinrateRepository;

    // Получить все сочетания героев с винрейтом
    public List<HeroWithWinRate> getAllHeroWithWinrates() {
        return heroWithWinrateRepository.findAll();
    }

    // Получить сочетание героев с винрейтом по ID
    public HeroWithWinRate getHeroWithWinrateById(Integer hero1Id, Integer hero2Id, int position1, int position2) {
        return heroWithWinrateRepository.findById(hero1Id).orElse(null);
    }

    // Создать новое сочетание героев с винрейтом
    public HeroWithWinRate createHeroWithWinrate(HeroWithWinRate heroWithWinrate) {
        return heroWithWinrateRepository.save(heroWithWinrate);
    }

    // Обновить сочетание героев с винрейтом
    public HeroWithWinRate updateHeroWithWinrate(Integer hero1Id, Integer hero2Id, int position1, int position2, HeroWithWinRate heroWithWinrateDetails) {
        HeroWithWinRate heroWithWinrate = heroWithWinrateRepository.findById(hero1Id).orElse(null);
        if (heroWithWinrate != null) {
            heroWithWinrate.setWinrate(heroWithWinrateDetails.getWinrate());
            heroWithWinrate.setMatches(heroWithWinrateDetails.getMatches());
            return heroWithWinrateRepository.save(heroWithWinrate);
        }
        return null;
    }

    // Удалить сочетание героев с винрейтом
    public void deleteHeroWithWinrate(Integer hero1Id, Integer hero2Id, int position1, int position2) {
        heroWithWinrateRepository.deleteById(hero1Id);
    }

    public void updateHeroWithWinrate(){
        heroWithWinrateRepository.updateHeroWithWinrate();
    }
}