package com.consultitnow.app.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CategoryPrice implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private Double price;
	
	private Boolean concernEncryptionFeature;

	
	@JsonIgnore
	@OneToMany(mappedBy = "categoryPrice")
	private List<CategoryPriceTechnologie> priceEquipementTech;

	
	@JsonIgnore
	@OneToMany(mappedBy = "categoryPrice")
	private List<CategoryPriceEquipementTypes> priceEquipementTypes;

	@ManyToOne(cascade = CascadeType.MERGE)
	private Agency agency;

	@ManyToOne(cascade = CascadeType.MERGE)
	private PriceCriteria priceCriteria;

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

	
	
	public Boolean getConcernEncryptionFeature() {
		return concernEncryptionFeature;
	}

	public void setConcernEncryptionFeature(Boolean concernEncryptionFeature) {
		this.concernEncryptionFeature = concernEncryptionFeature;
	}

	public PriceCriteria getPriceCriteria() {
		return priceCriteria;
	}

	public void setPriceCriteria(PriceCriteria priceCriteria) {
		this.priceCriteria = priceCriteria;
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
	
	

	public List<CategoryPriceTechnologie> getPriceEquipementTech() {
		return priceEquipementTech;
	}

	public void setPriceEquipementTech(List<CategoryPriceTechnologie> priceEquipementTech) {
		this.priceEquipementTech = priceEquipementTech;
	}

	@Override
	public String toString() {
		return "CategoryPrice [name=" + name + ", price=" + price + ", regardsTheEncryptionFunction="
				+ ", numberModules=" + ", priceEquipementTypes=" + priceEquipementTypes + ", agency=" + agency + "]";
	}

}
