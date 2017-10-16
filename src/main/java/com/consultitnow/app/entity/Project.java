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
	private String ProjectStatus;
	private String Description;
	private String EquipementName;
	private String EquipementModel;
	private String EquipementMark;
	private String EquipementManufacturer;
	
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
		return ProjectStatus;
	}
	public void setProjectStatus(String projectStatus) {
		ProjectStatus = projectStatus;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getEquipementName() {
		return EquipementName;
	}
	public void setEquipementName(String equipementName) {
		EquipementName = equipementName;
	}
	public String getEquipementModel() {
		return EquipementModel;
	}
	public void setEquipementModel(String equipementModel) {
		EquipementModel = equipementModel;
	}
	public String getEquipementMark() {
		return EquipementMark;
	}
	public void setEquipementMark(String equipementMark) {
		EquipementMark = equipementMark;
	}
	public String getEquipementManufacturer() {
		return EquipementManufacturer;
	}
	public void setEquipementManufacturer(String equipementManufacturer) {
		EquipementManufacturer = equipementManufacturer;
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
	
	
	
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
