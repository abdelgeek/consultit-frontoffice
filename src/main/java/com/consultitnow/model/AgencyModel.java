package com.consultitnow.model;


public class AgencyModel {

	private Long id;
	private String agencyName;
	private String link;
	private String agencyInitials;
	private String countryName;
	private Boolean isActive;
	
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
	public String getAgencyInitials() {
		return agencyInitials;
	}
	public void setAgencyInitials(String agencyInitials) {
		this.agencyInitials = agencyInitials;
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
	
	public AgencyModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public String toString() {
		return "AgencyModel [id=" + id + ", agencyName=" + agencyName + ", link=" + link + ", agencyInitials="
				+ agencyInitials + ", countryName=" + countryName + ", isActive=" + isActive + "]";
	}
	
	
	
	
}
