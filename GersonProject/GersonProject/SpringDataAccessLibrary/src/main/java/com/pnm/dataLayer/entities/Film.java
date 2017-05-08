package com.pnm.dataLayer.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name="film")
public class Film {
	
	public Film() {}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="film_id",unique=true,nullable=false)
	private Long id;
	
	@Column(nullable=false)
	private String title;
	
	@Column
	private String description;
	
	@Column(name="release_year")
	private Long releaseYear;

	@Column(name="rental_duration")
	private Long rentalDuration;

	@Column(name="rental_rate", precision=4, scale=2)
	private BigDecimal rentalRate;
	
	@Column
	private Long length;

	@Column(name="replacement_cost", precision=5, scale=2)
	private BigDecimal replacementCost;

	@Column
	private String rating;
	
	@Column(name="special_features")
	private String specialFeatures;
	
	@Column(name="last_update",nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdate;
	
	@ManyToOne
    @JoinColumn(name="language_id",nullable=false)
    private Language language;
	
	@ManyToOne
    @JoinColumn(name="original_language_id")
    private Language originalLanguage;
 
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "film_category", catalog = "sakila", joinColumns = {
			@JoinColumn(name = "FILM_ID", nullable = false, updatable = false) },
			inverseJoinColumns = { @JoinColumn(name = "CATEGORY_ID", nullable = false, updatable = false) })
	private Set<Category> categories = new HashSet<Category>(0);
	
	
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

	public Long getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Long releaseYear) {
		this.releaseYear = releaseYear;
	}

	public Long getRentalDuration() {
		return rentalDuration;
	}

	public void setRentalDuration(Long rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public BigDecimal getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(BigDecimal rentalRate) {
		this.rentalRate = rentalRate;
	}

	public Long getLength() {
		return length;
	}

	public void setLength(Long length) {
		this.length = length;
	}

	public BigDecimal getReplacementCost() {
		return replacementCost;
	}

	public void setReplacementCost(BigDecimal replacementCost) {
		this.replacementCost = replacementCost;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getSpecialFeatures() {
		return specialFeatures;
	}

	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public Language getOriginalLanguage() {
		return originalLanguage;
	}

	public void setOriginalLanguage(Language originalLanguage) {
		this.originalLanguage = originalLanguage;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	@Override
    public String toString() {
        return String.format(
                "Film[id=%d, title='%s', description='%s']",
                id, title, description);
    }
	

}

