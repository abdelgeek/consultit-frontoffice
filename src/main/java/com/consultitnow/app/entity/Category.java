package com.consultitnow.app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String categoryName;
	
	private Double categoryPrice;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Country country;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Double getCategoryPrice() {
		return categoryPrice;
	}

	public void setCategoryPrice(Double categoryPrice) {
		this.categoryPrice = categoryPrice;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(Long id, String categoryName, Double categoryPrice, Country country) {
		super();
		this.id = id;
		this.categoryName = categoryName;
		this.categoryPrice = categoryPrice;
		this.country = country;
	}
	
	
}
