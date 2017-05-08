package com.pnm.logicLayer;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
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
import com.pnm.logicLayer.components.services.FilmManager;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.pnm.dataLayer.entities"})
@EntityScan("com.pnm.dataLayer.entities")
@EnableJpaRepositories("com.pnm.dataLayer")
public class Application {
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}
	
//	@Autowired
//	public Film film;
//	
//	@Autowired
//	public Category category;
//	
//	@Autowired
//	public Language language;
	
	@Autowired
	public FilmRepository iFilm;
	
	@Autowired
	public CategoryRepository iCategory;
	
	@Autowired
	public FilmManager filmManager;
	
	
	public List<Film> findFilmByCategoryAndYear(String category, Long year){
		
		Category cat = (Category) iCategory.findByName(category);
		
		List<Film> films = null;
		if(year==0){
			films = iFilm.findByCategories(cat);
		}else{
			films = iFilm.findByCategoriesAndReleaseYear(cat, year);
		}
		
		return films;
	};
	
	@Bean
	public ApplicationRunner demo(FilmRepository filmRepository, LanguageRepository languageRepository, CategoryRepository categoryRepository) {
		return (args) -> {
			
			log.info("Hello!");
			
//			Film film = new Film();
//			film.setTitle("NUOVO FILM COMPLETO");
//			film.setDescription("Un nuovo film completo di tutti i campi");
//			film.setReleaseYear(2017L);
//			
//			List<Language> listLanguage = (List<Language>) languageRepository.findAll();
//			film.setLanguage(listLanguage.get(1));
//			film.setOriginalLanguage(listLanguage.get(0));
//			
//			film.setRentalDuration(3L);
//			
//			BigDecimal rentalRate = new BigDecimal("5");
//			film.setRentalRate(rentalRate);
//			
//			film.setLength(600L);
//			
//			BigDecimal rep = new BigDecimal("20");
//			film.setReplacementCost(rep);
//			
//			film.setRating("G");
//			
//			film.setSpecialFeatures("Trailers,Behind the Scenes");			
//			
//			Date lastUpdate = new Date();
//			film.setLastUpdate(lastUpdate);
//			
//			HashSet<Category> listCat = new HashSet<Category>();
//			Category cat = categoryRepository.findByName("Action");
//			listCat.add(cat);
//			film.setCategories(listCat);
//			
//			filmManager.aggiungiFilm(film);
//			log.info("Aggiunto Film : "+film.getTitle());
			
			String fileName = "C:\\Users\\ITAdmin\\Documents\\file.csv";
			//C:\Users\ITAdmin\Documents
			log.info("Stampo file: "+fileName);

			List<String> list = new ArrayList<>();

			try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

				//stream.forEach(System.out::println);
				
				//1. filter line 3
				//2. convert all content to upper case
				//3. convert it into a List
				list = stream
						.filter(line -> !line.startsWith("film_id"))
						.map(String::toUpperCase)
						.collect(Collectors.toList());

			} catch (IOException e) {
				e.printStackTrace();
			}

			log.info("List di "+list.size()+" elementi:");
			
			list.forEach(System.out::println);
			
			log.info("Fine file");
			
			String record = list.get(0);
			String[] split = record.split(",");
			Film film = new Film();
			film.setTitle(split[1]);
			
			log.info("Title :"+film.getTitle());

		};
		
	}
	
}
