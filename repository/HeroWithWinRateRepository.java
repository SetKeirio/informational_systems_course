package informational_systems.course.repository;

import informational_systems.course.items.HeroWithWinRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HeroWithWinRateRepository extends JpaRepository<HeroWithWinRate, Integer> {
    @Query(value = "SELECT update_herowithwinrate()", nativeQuery = true)
    void updateHeroWithWinrate();
}
