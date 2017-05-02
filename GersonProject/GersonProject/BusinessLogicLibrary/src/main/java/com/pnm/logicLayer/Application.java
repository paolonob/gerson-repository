package com.pnm.logicLayer;

import java.util.List;

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
import com.pnm.dataLayer.repositories.CategoryRepository;
import com.pnm.dataLayer.repositories.FilmRepository;
import com.pnm.dataLayer.repositories.LanguageRepository;

@SpringBootApplication
@ComponentScan(basePackages = {"com.pnm.dataLayer.repositories"})
@EntityScan("com.pnm.dataLayer.entities")
@EnableJpaRepositories("com.pnm.dataLayer")
public class Application {
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}
	
	@Autowired
	public FilmRepository iFilm;
	
	@Autowired
	public CategoryRepository iCategory;
	
	
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
			
//			String categoria = "Action";
//			Long anno = 2017L;
//			List<Film> films = findFilmByCategoryAndYear(categoria, anno);
			
			List<Film> films = filmRepository.findByTitleLike("%ACADEMY%");
			
			if(films!=null){				
			
				//log.info("Elenco Film di categoria "+categoria+" : "+films.size());
				log.info("Elenco Film : "+films.size());
				for (Film film : films) {
					log.info("Titolo: "+film.getTitle());
					log.info("     Anno: "+film.getReleaseYear());
					
					for (Category cats : film.getCategories()) {
						log.info("     Categorie: "+cats.getName());
					}
					
					log.info("     Lingua: "+film.getLanguage().getName());
					
					if(film.getOriginalLanguage()!=null){
						log.info("     Lingua Originale: "+film.getOriginalLanguage().getName());
					}else{
						log.info("     Lingua Originale: non presente");
					}
					
				}		
				
			}else{
				log.info("Nessun film trovato.");
			}

		};
		
		
	}
	
}
