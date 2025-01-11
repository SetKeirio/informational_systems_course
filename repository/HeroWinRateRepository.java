package informational_systems.course.repository;

import informational_systems.course.items.HeroWinRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HeroWinRateRepository extends JpaRepository<HeroWinRate, Integer> {
    List<HeroWinRate> findByPosition(int position);
}
