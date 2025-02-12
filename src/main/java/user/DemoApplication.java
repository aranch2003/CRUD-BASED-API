package user;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import run.Location;
import run.Run;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


@SpringBootApplication(scanBasePackages = {"user", "run"})//my first learning
public class DemoApplication {
public static final Logger log=  LoggerFactory.getLogger(DemoApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		log.info("Application started!!!!");
	}
		@Bean
		CommandLineRunner runner() {
			return args -> {
				Run run = new Run(1, "FIRST", LocalDateTime.now(), LocalDateTime.now().plus(1, ChronoUnit.HOURS), 5, Location.OUTDOOR);
				log.info("Run" + run);
			};
		}
	}


