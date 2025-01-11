package informational_systems.course.repository;

import informational_systems.course.items.HeroItemUsage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface HeroItemUsageRepository extends JpaRepository<HeroItemUsage, Integer> {
    List<HeroItemUsage> findByHeroNameAndPosition(String heroName, int position);
}
