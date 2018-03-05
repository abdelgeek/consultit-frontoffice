package com.consultitnow.app.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Requirements implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;

	@JsonIgnore
	@OneToMany(mappedBy = "requirements")
	private List<AgencyRequirements> agencyRequirements;

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

	public List<AgencyRequirements> getAgencyRequirements() {
		return agencyRequirements;
	}

	public void setAgencyRequirements(List<AgencyRequirements> agencyRequirements) {
		this.agencyRequirements = agencyRequirements;
	}

	public Requirements() {
		super();
		// TODO Auto-generated constructor stub
	}

}
