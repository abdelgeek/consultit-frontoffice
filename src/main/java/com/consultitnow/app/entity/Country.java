package com.consultitnow.app.entity;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Country implements Serializable {

	private Long id;
	private String countryName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
