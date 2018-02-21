package com.consultitnow.app.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.consultitnow.app.controller.EquipementTypeController;

@Entity
public class CategoryPrice implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private Double price;
	
	private Boolean regardsTheEncryptionFunction;
	
	private Integer numberModules;
	
	
	@ManyToMany
	private List<EquipmentType> equipementTypes;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Agency agency;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Boolean getRegardsTheEncryptionFunction() {
		return regardsTheEncryptionFunction;
	}

	public void setRegardsTheEncryptionFunction(Boolean regardsTheEncryptionFunction) {
		this.regardsTheEncryptionFunction = regardsTheEncryptionFunction;
	}

	public Integer getNumberModules() {
		return numberModules;
	}

	public void setNumberModules(Integer numberModules) {
		this.numberModules = numberModules;
	}

	public List<EquipmentType> getEquipementTypes() {
		return equipementTypes;
	}

	public void setEquipementTypes(List<EquipmentType> equipementTypes) {
		this.equipementTypes = equipementTypes;
	}

	public Agency getAgency() {
		return agency;
	}

	public void setAgency(Agency agency) {
		this.agency = agency;
	}

	public CategoryPrice() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategoryPrice(String name, Double price, Boolean regardsTheEncryptionFunction, Integer numberModules,
			List<EquipmentType> equipementTypes, Agency agency) {
		super();
		this.name = name;
		this.price = price;
		this.regardsTheEncryptionFunction = regardsTheEncryptionFunction;
		this.numberModules = numberModules;
		this.equipementTypes = equipementTypes;
		this.agency = agency;
	}
	
	
	
	
}
