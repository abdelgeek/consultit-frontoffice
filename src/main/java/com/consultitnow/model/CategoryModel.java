package com.consultitnow.model;

public class CategoryModel {

	
	private Long id;
	private String categoryName;
	private Double categoryPrice;
	private String country;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Double getCategoryPrice() {
		return categoryPrice;
	}
	public void setCategoryPrice(Double categoryPrice) {
		this.categoryPrice = categoryPrice;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public CategoryModel(Long id, String categoryName, Double categoryPrice, String country) {
		super();
		this.id = id;
		this.categoryName = categoryName;
		this.categoryPrice = categoryPrice;
		this.country = country;
	}
	public CategoryModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CategoryModel [id=" + id + ", categoryName=" + categoryName + ", categoryPrice=" + categoryPrice
				+ ", country=" + country + "]";
	}

	
	
}
