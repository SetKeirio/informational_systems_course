package informational_systems.course.controllers;

import informational_systems.course.items.HeroWithWinRate;
import informational_systems.course.services.HeroWithWinRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/herowithwinrates")
public class HeroWithWinRateController {

    @Autowired
    private HeroWithWinRateService heroWithWinrateService;

    // Получить все сочетания героев с винрейтом
    @GetMapping
    public List<HeroWithWinRate> getAllHeroWithWinrates() {
        return heroWithWinrateService.getAllHeroWithWinrates();
    }

    // Получить сочетание героев с винрейтом по ID
    @GetMapping("/{hero1Id}/{hero2Id}/{position1}/{position2}")
    public HeroWithWinRate getHeroWithWinrateById(@PathVariable Integer hero1Id,
                                                  @PathVariable Integer hero2Id,
                                                  @PathVariable int position1,
                                                  @PathVariable int position2) {
        return heroWithWinrateService.getHeroWithWinrateById(hero1Id, hero2Id, position1, position2);
    }

    @GetMapping("/update")
    public void updateHeroWithWinrate(){
        heroWithWinrateService.updateHeroWithWinrate();
        return;
    }
}