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
public class EquipmentTechnologie implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@ManyToOne(cascade = CascadeType.MERGE)
	private EquipmentNature equipmentNature;

	@JsonIgnore
	@OneToMany(mappedBy = "equipmentTechnologie")
	private List<QuotationTechnologies> quotationTechnologies;
	
	@JsonIgnore
	@OneToMany(mappedBy = "equipmentTechnologie")
	private List<CategoryPriceTechnologie> priceEquipementTech;

	public List<QuotationTechnologies> getQuotationTechnologies() {
		return quotationTechnologies;
	}

	public void setQuotationTechnologies(List<QuotationTechnologies> quotationTechnologies) {
		this.quotationTechnologies = quotationTechnologies;
	}

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

	public EquipmentTechnologie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EquipmentNature getEquipmentNature() {
		return equipmentNature;
	}

	public void setEquipmentNature(EquipmentNature equipmentNature) {
		this.equipmentNature = equipmentNature;
	}

	
	public List<CategoryPriceTechnologie> getPriceEquipementTech() {
		return priceEquipementTech;
	}

	public void setPriceEquipementTech(List<CategoryPriceTechnologie> priceEquipementTech) {
		this.priceEquipementTech = priceEquipementTech;
	}

	public EquipmentTechnologie(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "EquipementType [id=" + id + ", name=" + name + "]";
	}

}
