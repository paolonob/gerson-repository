package com.pnm.dataLayer.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.pnm.dataLayer.entities.Category;
import com.pnm.dataLayer.entities.Film;

public interface CategoryRepository extends CrudRepository<Category, Long>{
	
	public Category findByName(String name);
	
	public List<Category> findByFilms(Film film);


}
