package com.consultitnow.app.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Quotation implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date date;
	private Boolean isPlacedOrder;
	
	@OneToOne
	private Equipement equipement;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Equipement getEquipement() {
		return equipement;
	}

	public void setEquipement(Equipement equipement) {
		this.equipement = equipement;
	}

	
	
	public Boolean getIsPlacedOrder() {
		return isPlacedOrder;
	}

	public void setIsPlacedOrder(Boolean isPlacedOrder) {
		this.isPlacedOrder = isPlacedOrder;
	}

	public Quotation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
