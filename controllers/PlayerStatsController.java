package informational_systems.course.controllers;

import informational_systems.course.items.PlayerStats;
import informational_systems.course.services.PlayerStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/playerstats")
public class PlayerStatsController {

    @Autowired
    private PlayerStatsService playerStatsService;

    // Получить все статистики игроков по героям
    @GetMapping
    public List<PlayerStats> getAllPlayerStats() {
        return playerStatsService.getAllPlayerStats();
    }

    // Получить статистику игрока на герое по ID
    @GetMapping("/{playerId}/{heroId}")
    public PlayerStats getPlayerStatsById(@PathVariable Integer playerId, @PathVariable Integer heroId) {
        return playerStatsService.getPlayerStatsById(playerId, heroId);
    }

    @PostMapping
    public ResponseEntity<PlayerStats> addPlayerStats(@RequestBody PlayerStats playerStats) {
        PlayerStats newPlayerStats = playerStatsService.addPlayerStats(playerStats);
        return new ResponseEntity<>(newPlayerStats, HttpStatus.CREATED);
    }

    @GetMapping("/populate")
    public void populatePlayerStats() {
        playerStatsService.populatePlayerStats();
        return;
    }

}
