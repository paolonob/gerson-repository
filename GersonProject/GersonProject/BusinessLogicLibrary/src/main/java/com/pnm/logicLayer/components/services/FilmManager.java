package com.pnm.logicLayer.components.services;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pnm.dataLayer.entities.Film;
import com.pnm.dataLayer.repositories.FilmRepository;
import com.pnm.logicLayer.Application;


@Service
public class FilmManager implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
	@Autowired
	public FilmRepository iFilm;
	
	public List<Film> searchByTitle(String title){
		List<Film> list = null;
		
		log.info("search...");
		list = iFilm.findByTitleLike("%"+title+"%");
		
		return list;
	}
	
	public void aggiungiFilm(Film newFilm){
		log.info("saving...");
		iFilm.save(newFilm);
		log.info("save");
	}

}
