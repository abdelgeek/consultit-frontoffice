package com.consultitnow.model;

import com.consultitnow.app.entity.Country;

public class CountryResult {

	private String message;
	private Boolean isValid;
	private Country country;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Boolean getIsValid() {
		return isValid;
	}
	public void setIsValid(Boolean isValid) {
		this.isValid = isValid;
	}
	
	
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	public CountryResult(String message, Boolean isValid, Country country) {
		super();
		this.message = message;
		this.isValid = isValid;
		this.country = country;
	}
	public CountryResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
