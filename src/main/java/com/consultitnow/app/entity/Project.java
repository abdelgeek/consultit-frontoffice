package com.consultitnow.app.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Project implements Serializable {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Date orderDate;
	private String projectStatus;
	private String description;
	private String productName;
	private String productModel;
	private String productBrand;
	private String brandManufacturer;
	private Double price;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Category category;
	

	@ManyToOne(cascade=CascadeType.ALL)
	private Country Country;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Agency agency;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getProjectStatus() {
		return projectStatus;
	}
	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEquipementName() {
		return productName;
	}
	public void setEquipementName(String productName) {
		this.productName = productName;
	}
	public String getEquipementModel() {
		return productModel;
	}
	public void setEquipementModel(String productModel) {
		this.productModel = productModel;
	}
	public String getEquipementMark() {
		return productBrand;
	}
	public void setEquipementMark(String productBrand) {
		this.productBrand = productBrand;
	}
	public String getEquipementManufacturer() {
		return brandManufacturer;
	}
	public void setEquipementManufacturer(String equipementManufacturer) {
		this.brandManufacturer = equipementManufacturer;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Country getCountry() {
		return Country;
	}
	public void setCountry(Country country) {
		Country = country;
	}
	public Agency getAgency() {
		return agency;
	}
	public void setAgency(Agency agency) {
		this.agency = agency;
	}
	
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
