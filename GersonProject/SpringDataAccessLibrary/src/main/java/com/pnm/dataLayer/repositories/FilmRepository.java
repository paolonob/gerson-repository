package com.pnm.dataLayer.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.pnm.dataLayer.entities.Film;
import com.pnm.dataLayer.entities.Language;

public interface FilmRepository extends CrudRepository<Film, Long>{
	
	List<Film> findByTitle(String title);
	
	List<Film> findByLanguage(Language language);

}
