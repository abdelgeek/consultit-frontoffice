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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Agency implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String link;
	
	private String methodPrice;

	@JsonIgnore
	@OneToMany(mappedBy="agency")
	private List<AgencyMessageRestriction> agencyMessageRestriction;

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
	
	@JsonIgnore
	@OneToMany(mappedBy = "agency")
	private List<QuotationAgency> quotationAgencies ;


	@JsonIgnore
	@OneToMany(mappedBy="agency")
	private List<AgencyApprovalInformation> agencyApprovalInformations;
	
	
	
	
	public List<AgencyMessageRestriction> getAgencyMessageRestriction() {
		return agencyMessageRestriction;
	}

	public void setAgencyMessageRestriction(List<AgencyMessageRestriction> agencyMessageRestriction) {
		this.agencyMessageRestriction = agencyMessageRestriction;
	}

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

	

	public String getMethodPrice() {
		return methodPrice;
	}

	public void setMethodPrice(String methodPrice) {
		this.methodPrice = methodPrice;
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
	

	public List<QuotationAgency> getQuotationAgencies() {
		return quotationAgencies;
	}

	public void setQuotationAgencies(List<QuotationAgency> quotationAgencies) {
		this.quotationAgencies = quotationAgencies;
	}
	
	
	public List<AgencyApprovalInformation> getAgencyApprovalInformations() {
		return agencyApprovalInformations;
	}

	public void setAgencyApprovalInformations(List<AgencyApprovalInformation> agencyApprovalInformations) {
		this.agencyApprovalInformations = agencyApprovalInformations;
	}

	public Agency(Long id, String link, String agencyInitials, Country country) {
		super();
		this.id = id;
		this.link = link;
		this.agencyInitials = agencyInitials;
		this.country = country;

	}

}
