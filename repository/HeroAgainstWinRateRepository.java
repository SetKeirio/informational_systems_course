package informational_systems.course.repository;

import informational_systems.course.items.HeroAgainstWinRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HeroAgainstWinRateRepository extends JpaRepository<HeroAgainstWinRate, Integer> {
    @Query(value = "SELECT update_heroagainstwinrate()", nativeQuery = true)
    void updateHeroWithWinrate();
}