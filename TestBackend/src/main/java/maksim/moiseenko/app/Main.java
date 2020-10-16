package maksim.moiseenko.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@ComponentScan(basePackages = "maksim.moiseenko")
@EnableJpaRepositories("maksim.moiseenko.repositories")
@EntityScan(basePackages="maksim.moiseenko.models")
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }
}
