package tech.c3n7.muziki;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import tech.c3n7.muziki.core.config.StorageProperties;
import tech.c3n7.muziki.core.service.StorageService;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
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
