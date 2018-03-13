package com.consultitnow.model;

import java.util.List;

public class ApprovalInformationReportModel {

	private String countryName;
private List<String> requirementsName;
	
	

	public String getCountryName() {
		return countryName;
	}




	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}




	public List<String> getRequirementsName() {
		return requirementsName;
	}


	public void setRequirementsName(List<String> requirementsName) {
		this.requirementsName = requirementsName;
	}


	public ApprovalInformationReportModel(String countryName, List<String> requirementsName) {
		super();
		this.countryName = countryName;
		this.requirementsName = requirementsName;
	}
	
	public ApprovalInformationReportModel(String countryName) {
		super();
		this.countryName = countryName;
		
	}




	public ApprovalInformationReportModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
