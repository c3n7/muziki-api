package tech.c3n7.muziki;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tech.c3n7.muziki.core.service.StorageService;

@SpringBootApplication
public class MuzikiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MuzikiApplication.class, args);
	}

	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args -> {
			storageService.init();
		});
	}
}
