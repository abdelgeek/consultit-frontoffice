package com.consultitnow.model;

public class Result {
 
	private String message;
	private Boolean isValid;
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
	public Result(String message, Boolean isValid) {
		super();
		this.message = message;
		this.isValid = isValid;
	}
	public Result() {
		this.isValid = false;
	
		// TODO Auto-generated constructor stub
	}
	
	
}
