package com.pnm.dataLayer.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.pnm.dataLayer.entities.Film;
import com.pnm.dataLayer.entities.Language;

public interface LanguageRepository extends CrudRepository<Language, Long>{
	
	List<Language> findByName(String name);

}
