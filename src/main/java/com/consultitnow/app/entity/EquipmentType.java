package com.consultitnow.app.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class EquipmentType implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique=true)
	private String name;
	
	@OneToMany(mappedBy="equipmentType")
	private List<CategoryPriceEquipementTypes> priceEquipementTypes;
	
	
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
	
	
	public List<CategoryPriceEquipementTypes> getPriceEquipementTypes() {
		return priceEquipementTypes;
	}
	public void setPriceEquipementTypes(List<CategoryPriceEquipementTypes> priceEquipementTypes) {
		this.priceEquipementTypes = priceEquipementTypes;
	}
	public EquipmentType() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
