package com.consultitnow.app.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Agency implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	private String link;
	
	
	@ManyToOne
	private ApprovalType approvalType;

	@Column(nullable = false)
	private String agencyInitials;

	@ManyToOne(cascade = CascadeType.ALL)
	private Country country;

	public String getAgencyInitials() {
		return agencyInitials;
	}

	public void setAgencyInitials(String agencyInitials) {
		this.agencyInitials = agencyInitials;
	}

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

	public Agency(Long id, String name, String link, String agencyInitials, Country country) {
		super();
		this.id = id;
		this.name = name;
		this.link = link;
		this.agencyInitials = agencyInitials;
		this.country = country;

	}

}
