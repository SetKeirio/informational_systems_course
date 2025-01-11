package informational_systems.course.controllers;

import informational_systems.course.items.HeroAgainstWinRate;
import informational_systems.course.services.HeroAgainstWinRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/heroagainstwinrates")
public class HeroAgainstWinRateController {

    @Autowired
    private HeroAgainstWinRateService heroAgainstWinRateService;

    // Получить все данные о винрейте противостоящих героев
    @GetMapping
    public List<HeroAgainstWinRate> getAllHeroAgainstWinRates() {
        return heroAgainstWinRateService.getAllHeroWithWinrates();
    }

    // Получить данные о винрейте противостоящих героев по ID
    @GetMapping("/{hero1Id}/{hero2Id}/{position1}/{position2}")
    public HeroAgainstWinRate getHeroAgainstWinRateById(@PathVariable Integer hero1Id,
                                                        @PathVariable Integer hero2Id,
                                                        @PathVariable int position1,
                                                        @PathVariable int position2) {
        return heroAgainstWinRateService.getHeroWithWinrateById(hero1Id, hero2Id, position1, position2);
    }

    @GetMapping("/update")
    public void updateHeroAgainstWinrate(){
        heroAgainstWinRateService.updateHeroWithWinrate();
        return;
    }
}
