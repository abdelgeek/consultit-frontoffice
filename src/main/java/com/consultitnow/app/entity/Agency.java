package com.consultitnow.app.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
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
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Agency implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String link;

	private Integer leadTime;

	@JsonIgnore
	@OneToMany(mappedBy = "agency")
	private List<AgencyRequirements> agencyRequirements;

	@ManyToOne
	private ApprovalType approvalType;

	@JsonIgnore
	@OneToMany(mappedBy = "agency")
	private List<AgencyFrequencyBand> agencyFrequencyBands;

	@Column(nullable = false)
	private String agencyInitials;

	@ManyToOne(cascade = CascadeType.ALL)
	private Country country;

	@JsonIgnore
	@OneToMany(mappedBy = "agency")
	private List<CategoryPrice> categoryPrices;

	@ManyToOne(cascade = CascadeType.ALL)
	private PriceCriteria priceCriteria;

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

	public Integer getLeadTime() {
		return leadTime;
	}

	public void setLeadTime(Integer leadTime) {
		this.leadTime = leadTime;
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
	

	public List<CategoryPrice> getCategoryPrices() {
		return categoryPrices;
	}

	public void setCategoryPrices(List<CategoryPrice> categoryPrices) {
		this.categoryPrices = categoryPrices;
	}

	public PriceCriteria getPriceCriteria() {
		return priceCriteria;
	}

	public void setPriceCriteria(PriceCriteria priceCriteria) {
		this.priceCriteria = priceCriteria;
	}

	public Agency() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<AgencyRequirements> getAgencyRequirements() {
		return agencyRequirements;
	}

	public void setAgencyRequirements(List<AgencyRequirements> agencyRequirements) {
		this.agencyRequirements = agencyRequirements;
	}

	public Agency(Long id, String link, String agencyInitials, Country country) {
		super();
		this.id = id;
		this.link = link;
		this.agencyInitials = agencyInitials;
		this.country = country;

	}

}
