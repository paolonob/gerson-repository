package com.pnm.dataLayer;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.pnm.dataLayer.entities.Category;
import com.pnm.dataLayer.entities.Film;
import com.pnm.dataLayer.entities.Language;
import com.pnm.dataLayer.repositories.CategoryRepository;
import com.pnm.dataLayer.repositories.FilmRepository;
import com.pnm.dataLayer.repositories.LanguageRepository;

@SpringBootApplication
public class Application {
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}
	
	@Bean
	public ApplicationRunner demo(FilmRepository filmRepository, LanguageRepository languageRepository, CategoryRepository categoryRepository) {
		return (args) -> {
			
			log.info("Hello!");
			
			Long id = 1000L;
			
//			Language ln = languageRepository.findOne(id);
//			log.info("Film found with language: "+ln.getName());
//			log.info("--------------------------------");
//
//			List<Film> filmList = filmRepository.findByLanguage(ln);
			
//			Category cat = categoryRepository.findOne(id);
//			log.info("Film found with category: "+cat.getName());
//			log.info("--------------------------------");
//
//			List<Film> filmList = filmRepository.findByCategories(cat);
//
//			log.info("Elenco: "+filmList.size());
//			for (Film film : filmList) {
//				log.info(film.toString());
//				
//				List<Category> categoryList = categoryRepository.findByFilms(film);
//				for (Category category : categoryList) {
//					log.info("Categorie: "+category.getName());
//				}
//				
//				Language language = languageRepository.findByFilmLanguage(film);
//				log.info("Lingua: "+language.getName());
//				
//				Language languageOrigin = languageRepository.findByFilmLanguage(film);
//				log.info("Lingua Originale: "+languageOrigin.getName());
//			}
			
			Film film = filmRepository.findOne(id);
			log.info("Film: "+film.getTitle());
			log.info("--------------------------------");

			Language language = languageRepository.findByFilmLanguage(film);
			log.info("Lingua: "+language.getName());
			
			Language languageOrigin = languageRepository.findByFilmOriginalLanguage(film);
			if(languageOrigin!=null){
				log.info("Lingua Originale: "+languageOrigin.getName());
			}else{
				log.info("Lingua Originale: non presente");
			}
			
			List<Category> categoryList = categoryRepository.findByFilms(film);
			
			log.info("Elenco: "+categoryList.size());
			for (Category category : categoryList) {
				log.info("Categorie: "+category.getName());
			}

		};
		
		
	}
	
//	@Bean
//	public CommandLineRunner demo(FilmRepository repository) {
//		return (args) -> {
//			
//			log.info("Hello!");
////			log.info("Inserisco un film...");
//			//repository.save(new Film("Via col vento", "AA BB CC DD EE FF"));
////			repository.save(new Film("Odissea 2001", "GG EE HH"));
////			repository.save(new Film("Moon", "GG EE HH"));
//			
//			// fetch all film
////			log.info("Films found with findAll():");
////			log.info("-------------------------------");
////			for (Film film : repository.findAll()) {
////				log.info(film.toString());
////			}
////			log.info("");
//			
//			 Long id = 1000L;
//			 Film film = repository.findOne(id);
//			 film.getDescription();
//				log.info("Film found with id:"+id);
//				log.info("--------------------------------");
//				log.info(film.toString());				log.info("");
//				log.info("Lingua: "+film.getLanguage().getName());
//				
//				Language ln = repository.findOne(2L);
//				log.info("Film in lingua italiana: "+);
//
//				// fetch customers by last name
////				log.info("Film found with findByTitle('AGENT TRUMAN'):");
////				log.info("--------------------------------------------");
////				List<Film> filmList = repository.findByTitle("AGENT TRUMAN");
//////				for (Film film : repository.findByTitle("AGENT TRUMAN")) {
//////					log.info(film.toString());
//////				}
////				log.info(filmList.get(0).toString());
////				log.info("");
//		};
//		
//		
//	}
}
