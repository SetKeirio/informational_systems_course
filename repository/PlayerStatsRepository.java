package informational_systems.course.repository;

import informational_systems.course.items.PlayerStats;
import informational_systems.course.items.PlayerStatsPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerStatsRepository extends JpaRepository<PlayerStats, PlayerStatsPK> {
    @Query(value = "SELECT populate_playerstats()", nativeQuery = true)
    void populatePlayerStats();
}
