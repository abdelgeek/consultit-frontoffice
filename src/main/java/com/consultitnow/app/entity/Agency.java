package com.consultitnow.app.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Agency implements Serializable {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private String agencyName;
	
	private String link;
	
	@Column(nullable=false)
	private String agencyInitials;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Country country;
	private Boolean isActive;
	
	
	public String getAgencyInitials() {
		return agencyInitials;
	}

	public void setAgencyInitials(String agencyInitials) {
		this.agencyInitials = agencyInitials;
	}

	

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAgencyName() {
		return agencyName;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Agency() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Agency(Long id, String agencyName, String link, String agencyInitials, Country country, Boolean isActive) {
		super();
		this.id = id;
		this.agencyName = agencyName;
		this.link = link;
		this.agencyInitials = agencyInitials;
		this.country = country;
		this.isActive = isActive;
	}
	
	
	
	
}
