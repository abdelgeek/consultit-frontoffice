package com.consultitnow.app.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames={"quotationId","EquipmentTechnologieId"}))
public class QuotationTechnologies implements Serializable{

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	@ManyToOne(cascade= CascadeType.MERGE )
	@JoinColumn(name="quotationId",referencedColumnName="id")
	private Quotation quotation;
	
	@ManyToOne(cascade= CascadeType.MERGE )
	@JoinColumn(name="EquipmentTechnologieId", referencedColumnName="id")
	private EquipmentTechnologie equipmentTechnologie;
	
	
	
	
	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public Quotation getQuotation() {
		return quotation;
	}




	public void setQuotation(Quotation quotation) {
		this.quotation = quotation;
	}




	public EquipmentTechnologie getEquipmentTechnologie() {
		return equipmentTechnologie;
	}




	public void setEquipmentTechnologie(EquipmentTechnologie equipmentTechnologie) {
		this.equipmentTechnologie = equipmentTechnologie;
	}




	public QuotationTechnologies() {
		// TODO Auto-generated constructor stub
	}

	
}
