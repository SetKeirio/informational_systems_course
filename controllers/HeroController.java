package informational_systems.course.controllers;

import informational_systems.course.items.CharacterName;
import informational_systems.course.items.Hero;
import informational_systems.course.services.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @GetMapping("/names")
    public List<CharacterName> getAllHeroesNames() {
        List<Hero> list = heroService.getAllHeroes();
        List<CharacterName> answer = new ArrayList<>();
        for (Hero i: list){
            answer.add(new CharacterName(i.getName(), i.getId().intValue()));
        }
        return answer;
    }

    // Получить героя по ID
    @GetMapping("/{id}")
    public Hero getHeroById(@PathVariable Integer id) {
        return heroService.getHeroById(id);
    }
}