package informational_systems.course.repository;

import informational_systems.course.items.Stats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StatsRepository extends JpaRepository<Stats, Integer> {
}