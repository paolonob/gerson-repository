package com.pnm.dataLayer.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	@Column(name="language_id")
	private Long id;
	
	@Column
	private String name;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date last_update;

	@OneToMany(mappedBy = "language")
    private Set<Film> film = new HashSet<Film>();
	
	
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

	public Date getLast_update() {
		return last_update;
	}

	public void setLast_update(Date last_update) {
		this.last_update = last_update;
	}

	public Set<Film> getFilm() {
		return film;
	}

	public void setFilm(Set<Film> film) {
		this.film = film;
	}

}
