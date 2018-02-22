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
import javax.persistence.OneToMany;

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
	
	
	@OneToMany(mappedBy="categoryPrice")
	private List<CategoryPriceEquipementTypes> priceEquipementTypes;
	
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

	

	public List<CategoryPriceEquipementTypes> getPriceEquipementTypes() {
		return priceEquipementTypes;
	}

	public void setPriceEquipementTypes(List<CategoryPriceEquipementTypes> priceEquipementTypes) {
		this.priceEquipementTypes = priceEquipementTypes;
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

	@Override
	public String toString() {
		return "CategoryPrice [name=" + name + ", price=" + price + ", regardsTheEncryptionFunction="
				+ regardsTheEncryptionFunction + ", numberModules=" + numberModules + ", priceEquipementTypes="
				+ priceEquipementTypes + ", agency=" + agency + "]";
	}
	
	
}
