package informational_systems.course.repository;

import informational_systems.course.items.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HeroRepository extends JpaRepository<Hero, Integer> {
    Optional<Hero> findByName(String name);
}
