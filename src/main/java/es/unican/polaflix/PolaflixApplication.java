package es.unican.polaflix;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import es.unican.polaflix.domain.Serie;
import es.unican.polaflix.repo.SerieRepository;

@SpringBootApplication
public class PolaflixApplication {

	public static void main(String[] args) {
		SpringApplication.run(PolaflixApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner runner(SerieRepository sr){
		return args -> {
			List<Serie> series = sr.findSerieByName("a");
			System.out.println(series);
		};
	}
}
