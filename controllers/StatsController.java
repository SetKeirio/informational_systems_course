package informational_systems.course.controllers;

import informational_systems.course.items.Stats;
import informational_systems.course.services.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stats")
public class StatsController {

    @Autowired
    private StatsService statsService;

    // Получить все статистики
    @GetMapping
    public List<Stats> getAllStats() {
        return statsService.getAllStats();
    }

    // Получить статистику по ID
    @GetMapping("/{id}")
    public Stats getStatsById(@PathVariable Integer id) {
        return statsService.getStatsById(id);
    }
}