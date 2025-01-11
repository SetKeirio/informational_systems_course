package informational_systems.course.controllers;

import informational_systems.course.items.Match;
import informational_systems.course.services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matches")
public class MatchController {

    @Autowired
    private MatchService matchService;

    // Получить все матчи
    @GetMapping()
    public List<Match> getAllMatches() {
        return matchService.getAllMatches();
    }

    // Получить матч по ID
    @GetMapping("/{id}")
    public Match getMatchById(@PathVariable int id) {
        return matchService.getMatchById(id);
    }

    @PostMapping
    public Match addMatch(@RequestBody Match match) {
        return matchService.addMatch(match);
    }
}
