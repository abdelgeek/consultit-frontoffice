package com.consultitnow.app.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class EquipmentTechnologie implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@ManyToOne
	private EquipmentNature equipmentNature;

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
