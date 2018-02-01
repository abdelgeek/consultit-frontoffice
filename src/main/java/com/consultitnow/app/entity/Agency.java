package com.consultitnow.app.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Agency implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	private String link;
	
	
	@ManyToOne
	private ApprovalType approvalType;
	
	@JsonIgnore
	@OneToMany(mappedBy="agency", fetch=FetchType.LAZY)
	private List<AgencyFrequencyBand> agencyFrequencyBands;

	@Column(nullable = false)
	private String agencyInitials;

	@ManyToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
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

	

	public ApprovalType getApprovalType() {
		return approvalType;
	}

	public void setApprovalType(ApprovalType approvalType) {
		this.approvalType = approvalType;
	}

	public List<AgencyFrequencyBand> getAgencyFrequencyBands() {
		return agencyFrequencyBands;
	}

	public void setAgencyFrequencyBands(List<AgencyFrequencyBand> agencyFrequencyBands) {
		this.agencyFrequencyBands = agencyFrequencyBands;
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

	public Agency(Long id, String link, String agencyInitials, Country country) {
		super();
		this.id = id;
		this.link = link;
		this.agencyInitials = agencyInitials;
		this.country = country;

	}

}
