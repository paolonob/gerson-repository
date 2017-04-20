package com.pnm.dataLayer.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name="film")
public class Film {
	
	public Film() {}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="film_id")
	private Long id;
	
	@Column
	private String title;
	
	@Column
	private String description;
	
//	@Column
//	private Long language_id;
	
	@Column
	private Long release_year;

	@Column
	private Long original_language_id;

	@Column
	private Long rental_duration;

	@Column
	private BigDecimal rental_rate;
	
	@Column
	private Long length;

	@Column
	private BigDecimal replacement_cost;

	@Column
	private String rating;
	
	@Column
	private String special_features;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date last_update;
	
	@ManyToOne
    @JoinColumn(name="language_id")
    private Language language;
	
//	@ManyToOne
//    @JoinColumn(name="original_language_id")
//    private Language language;
 
	
	// Metodi Getter e Setter

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getRelease_year() {
		return release_year;
	}

	public void setRelease_year(Long release_year) {
		this.release_year = release_year;
	}

	public Long getOriginal_language_id() {
		return original_language_id;
	}

	public void setOriginal_language_id(Long original_language_id) {
		this.original_language_id = original_language_id;
	}

	public Long getRental_duration() {
		return rental_duration;
	}

	public void setRental_duration(Long rental_duration) {
		this.rental_duration = rental_duration;
	}

	public BigDecimal getRental_rate() {
		return rental_rate;
	}

	public void setRental_rate(BigDecimal rental_rate) {
		this.rental_rate = rental_rate;
	}

	public Long getLength() {
		return length;
	}

	public void setLength(Long length) {
		this.length = length;
	}

	public BigDecimal getReplacement_cost() {
		return replacement_cost;
	}

	public void setReplacement_cost(BigDecimal replacement_cost) {
		this.replacement_cost = replacement_cost;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getSpecial_features() {
		return special_features;
	}

	public void setSpecial_features(String special_features) {
		this.special_features = special_features;
	}

	public Date getLast_update() {
		return last_update;
	}

	public void setLast_update(Date last_update) {
		this.last_update = last_update;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	@Override
    public String toString() {
        return String.format(
                "Film[id=%d, title='%s', description='%s']",
                id, title, description);
    }
	

}

