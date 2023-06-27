package kr.kyusung.locationsaver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class LocationSaverApplication {

    public static void main(String[] args) {
        SpringApplication.run(LocationSaverApplication.class, args);
    }

}
