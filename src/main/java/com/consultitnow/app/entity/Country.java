package com.consultitnow.app.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Country implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true, nullable = false)
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy ="country")
	private Collection<Agency> agencies;
	
	
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
	
	

	public Collection<Agency> getAgencies() {
		return agencies;
	}

	public void setAgencies(Collection<Agency> agencies) {
		this.agencies = agencies;
	}

	public Country() {
		// TODO Auto-generated constructor stub
	}


	public Country(Long id, String name, Collection<Agency> agencies) {
		this.id = id;
		this.name = name;
		this.agencies = agencies;
	}
	

}
