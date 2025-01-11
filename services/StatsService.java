package informational_systems.course.services;

import informational_systems.course.items.Stats;
import informational_systems.course.repository.StatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatsService {

    @Autowired
    private StatsRepository statsRepository;

    // Получить все статистики
    public List<Stats> getAllStats() {
        return statsRepository.findAll();
    }

    // Получить статистику по ID
    public Stats getStatsById(Integer id) {
        return statsRepository.findById(id).orElse(null);
    }

    // Создать новую статистику
    public Stats createStats(Stats stats) {
        return statsRepository.save(stats);
    }

    // Обновить статистику
    public Stats updateStats(Integer id, Stats statsDetails) {
        Stats stats = statsRepository.findById(id).orElse(null);
        if (stats != null) {
            stats.setDamage(statsDetails.getDamage());
            stats.setHeal(statsDetails.getHeal());
            stats.setKda(statsDetails.getKda());
            stats.setGpm(statsDetails.getGpm());
            stats.setXpm(statsDetails.getXpm());
            stats.setLastHits(statsDetails.getLastHits());
            stats.setDeny(statsDetails.getDeny());
            return statsRepository.save(stats);
        }
        return null;
    }

    // Удалить статистику
    public void deleteStats(Integer id) {
        statsRepository.deleteById(id);
    }
}