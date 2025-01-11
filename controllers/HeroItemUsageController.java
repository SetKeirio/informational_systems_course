package informational_systems.course.controllers;

import informational_systems.course.items.HeroItemUsage;
import informational_systems.course.services.HeroItemUsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/itemusage")
public class HeroItemUsageController {

    @Autowired
    private Environment env;

    @Autowired
    private HeroItemUsageService heroItemUsageService;

    // Эндпоинт для загрузки данных из CSV
    @GetMapping("/reset")
    public void uploadHeroItemUsageData() {
        String csvTable = env.getProperty("csv.all-winrates");
        try {
            heroItemUsageService.parseCsvAndSaveHeroItemUsage(csvTable);
        } catch (Exception e) {}
        return;
    }

    @GetMapping("/items/{heroName}/{position}")
    public List<HeroItemUsage> getHeroItemUsageByHeroAndPosition(
            @PathVariable String heroName,
            @PathVariable int position) {
        return heroItemUsageService.getHeroItemUsageByHeroAndPosition(heroName, position);
    }
}
