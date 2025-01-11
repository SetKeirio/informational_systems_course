package informational_systems.course.controllers;

import informational_systems.course.items.Hero;
import informational_systems.course.services.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/heroes")
public class HeroController {

    @Autowired
    private HeroService heroService;

    // Получить всех героев
    @GetMapping
    public List<Hero> getAllHeroes() {
        return heroService.getAllHeroes();
    }

    // Получить героя по ID
    @GetMapping("/{id}")
    public Hero getHeroById(@PathVariable Integer id) {
        return heroService.getHeroById(id);
    }
}