package com.consultitnow.app.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Technical")
public class TechnicalRequirement extends Requirements {
	
	private String loA;
	private String doC;
	private String dataSheet;
	private String userguide;
	private String manufacturerBusiness;
	public String getLoA() {
		return loA;
	}
	public void setLoA(String loA) {
		this.loA = loA;
	}
	public String getDoC() {
		return doC;
	}
	public void setDoC(String doC) {
		this.doC = doC;
	}
	public String getDataSheet() {
		return dataSheet;
	}
	public void setDataSheet(String dataSheet) {
		this.dataSheet = dataSheet;
	}
	public String getUserguide() {
		return userguide;
	}
	public void setUserguide(String userguide) {
		this.userguide = userguide;
	}
	public String getManufacturerBusiness() {
		return manufacturerBusiness;
	}
	public void setManufacturerBusiness(String manufacturerBusiness) {
		this.manufacturerBusiness = manufacturerBusiness;
	}
	
	
	
}
