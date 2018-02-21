package com.consultitnow.model;


import com.consultitnow.app.entity.CategoryPrice;

public class CategoryPriceResult {
	private String message;
	private Boolean isValid;
	private CategoryPrice categoryPrice;
	
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
	public CategoryPrice getCategory() {
		return categoryPrice;
	}
	public void setCategory(CategoryPrice categoryPrice) {
		this.categoryPrice = categoryPrice;
	}
	
}
