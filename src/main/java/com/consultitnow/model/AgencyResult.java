package com.consultitnow.model;

import com.consultitnow.app.entity.Agency;

public class AgencyResult {

	private String message;
	private Boolean isValid;
	private Agency agency;
	
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
	
	
	public Agency getAgency() {
		return agency;
	}
	public void setAgency(Agency agency) {
		this.agency = agency;
	}
	public AgencyResult(String message, Boolean isValid, Agency agency) {
		super();
		this.message = message;
		this.isValid = isValid;
		this.agency = agency;
	}
	public AgencyResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
