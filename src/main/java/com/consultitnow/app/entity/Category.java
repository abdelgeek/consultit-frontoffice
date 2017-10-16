package com.consultitnow.app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Category {

	@Id
	private long id;
	
	private String categoryWording;
	
	private Double categoryPrice;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Country country;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCategoryWording() {
		return categoryWording;
	}

	public void setCategoryWording(String categoryWording) {
		this.categoryWording = categoryWording;
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
	
	
}
