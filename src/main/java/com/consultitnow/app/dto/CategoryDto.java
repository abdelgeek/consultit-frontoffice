package com.consultitnow.app.dto;

public class CategoryDto {

	private String agencyInitial;
	private String countryName;
	private float categoryPrice;
	
	public String getAgencyInitial() {
		return agencyInitial;
	}
	public void setAgencyInitial(String agencyInitial) {
		this.agencyInitial = agencyInitial;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public float getCategoryPrice() {
		return categoryPrice;
	}
	public void setCategoryPrice(float categoryPrice) {
		this.categoryPrice = categoryPrice;
	}
	public CategoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
