package informational_systems.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("informational_systems.course.repository")
@EntityScan("informational_systems.course.items")
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}