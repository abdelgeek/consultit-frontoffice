package com.consultitnow.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Country implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(unique=true, nullable=false)
	private String countryName;
	
	
	private Boolean isActive;
	
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
	
	
	
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Country(Long id, String countryName,Boolean isActive) {
		super();
		this.id = id;
		this.countryName = countryName;
		this.isActive = isActive;
	}
	@Override
	public String toString() {
		return "Country [id=" + id + ", countryName=" + countryName + ", isActive=" + isActive + "]";
	}
	
	
	
	
}
