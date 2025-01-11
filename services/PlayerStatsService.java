package informational_systems.course.services;

import informational_systems.course.items.PlayerStats;
import informational_systems.course.items.PlayerStatsPK;
import informational_systems.course.repository.PlayerStatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerStatsService {

    @Autowired
    private PlayerStatsRepository playerStatsRepository;

    // Получить все статистики игрока
    public List<PlayerStats> getAllPlayerStats() {
        return playerStatsRepository.findAll();
    }

    // Получить статистику игрока по ID
    public PlayerStats getPlayerStatsById(Integer playerId, Integer heroId) {
        PlayerStatsPK key = new PlayerStatsPK();
        key.setPlayerId(playerId);
        key.setHeroId(heroId);
        return playerStatsRepository.findById(key).orElse(null);
    }

    // Создать статистику игрока
    public PlayerStats createPlayerStats(PlayerStats playerStats) {
        return playerStatsRepository.save(playerStats);
    }

    // Обновить статистику игрока
    public PlayerStats updatePlayerStats(Integer playerId, Integer heroId, PlayerStats playerStatsDetails) {
        PlayerStatsPK key = new PlayerStatsPK();
        key.setPlayerId(playerId);
        key.setHeroId(heroId);
        PlayerStats playerStats = playerStatsRepository.findById(key).orElse(null);
        if (playerStats != null) {
            playerStats.setWins(playerStatsDetails.getWins());
            playerStats.setLoses(playerStatsDetails.getLoses());
            return playerStatsRepository.save(playerStats);
        }
        return null;
    }

    // Удалить статистику игрока
    public void deletePlayerStats(Integer playerId, Integer heroId) {
        PlayerStatsPK key = new PlayerStatsPK();
        key.setPlayerId(playerId);
        key.setHeroId(heroId);
        playerStatsRepository.deleteById(key);
    }

    public PlayerStats addPlayerStats(PlayerStats playerStats) {
        return playerStatsRepository.save(playerStats);
    }

    public void populatePlayerStats() {
        playerStatsRepository.populatePlayerStats();
    }
}