package com.pnm.dataLayer.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="language")
public class Language {
	
	public Language() {}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="language_id",unique=true,nullable=false)
	private Long id;
	
	@Column(nullable=false)
	private String name;
	
	@Column(name="last_update",nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdate;

	@OneToMany(mappedBy = "language")
    private Set<Film> filmLanguage = new HashSet<Film>();
	
	@OneToMany(mappedBy = "originalLanguage")
    private Set<Film> filmOriginalLanguage = new HashSet<Film>();
	
	
	// Metodi Getter e Setter
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Set<Film> getFilmLanguage() {
		return filmLanguage;
	}

	public void setFilmLanguage(Set<Film> filmLanguage) {
		this.filmLanguage = filmLanguage;
	}

	public Set<Film> getFilmOriginalLanguage() {
		return filmOriginalLanguage;
	}

	public void setFilmOriginalLanguage(Set<Film> filmOriginalLanguage) {
		this.filmOriginalLanguage = filmOriginalLanguage;
	}

}
