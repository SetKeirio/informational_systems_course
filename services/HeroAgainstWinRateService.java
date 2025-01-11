package informational_systems.course.services;

import informational_systems.course.items.HeroAgainstWinRate;
import informational_systems.course.repository.HeroAgainstWinRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroAgainstWinRateService {

    @Autowired
    private HeroAgainstWinRateRepository heroAgainstWinrateRepository;

    // Получить все сочетания героев с винрейтом
    public List<HeroAgainstWinRate> getAllHeroWithWinrates() {
        return heroAgainstWinrateRepository.findAll();
    }

    // Получить сочетание героев с винрейтом по ID
    public HeroAgainstWinRate getHeroWithWinrateById(Integer hero1Id, Integer hero2Id, int position1, int position2) {
        return heroAgainstWinrateRepository.findById(hero1Id).orElse(null);
    }

    // Создать новое сочетание героев с винрейтом
    public HeroAgainstWinRate createHeroWithWinrate(HeroAgainstWinRate heroWithWinrate) {
        return heroAgainstWinrateRepository.save(heroWithWinrate);
    }

    // Обновить сочетание героев с винрейтом
    public HeroAgainstWinRate updateHeroWithWinrate(Integer hero1Id, Integer hero2Id, int position1, int position2, HeroAgainstWinRate heroWithWinrateDetails) {
        HeroAgainstWinRate heroWithWinrate = heroAgainstWinrateRepository.findById(hero1Id).orElse(null);
        if (heroWithWinrate != null) {
            heroWithWinrate.setWinrate(heroWithWinrateDetails.getWinrate());
            heroWithWinrate.setMatches(heroWithWinrateDetails.getMatches());
            return heroAgainstWinrateRepository.save(heroWithWinrate);
        }
        return null;
    }

    // Удалить сочетание героев с винрейтом
    public void deleteHeroWithWinrate(Integer hero1Id, Integer hero2Id, int position1, int position2) {
        heroAgainstWinrateRepository.deleteById(hero1Id);
    }

    public void updateHeroWithWinrate(){
        heroAgainstWinrateRepository.updateHeroWithWinrate();
    }
}
