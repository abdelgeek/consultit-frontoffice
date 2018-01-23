package com.consultitnow.app.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Quotation implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date date;
	private Integer status;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	private ApprovalType approvalType;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private EquipementType equipementType;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private EquipementNature equipementNature;
	
	
	@ManyToMany
	private List<FrequencyBand> frequencies;
	

	@ManyToMany
	private List<EquipementTechnologie> equipementTechnologie;
	
	@ManyToMany
	private List<Category> categories;
	
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


	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public ApprovalType getApprovalType() {
		return approvalType;
	}

	public void setApprovalType(ApprovalType approvalType) {
		this.approvalType = approvalType;
	}

	public EquipementType getEquipementType() {
		return equipementType;
	}

	public void setEquipementType(EquipementType equipementType) {
		this.equipementType = equipementType;
	}

	public EquipementNature getEquipementNature() {
		return equipementNature;
	}

	public void setEquipementNature(EquipementNature equipementNature) {
		this.equipementNature = equipementNature;
	}

	public List<FrequencyBand> getFrequencies() {
		return frequencies;
	}

	public void setFrequencies(List<FrequencyBand> frequencies) {
		this.frequencies = frequencies;
	}

	public List<EquipementTechnologie> getEquipementTechnologie() {
		return equipementTechnologie;
	}

	public void setEquipementTechnologie(List<EquipementTechnologie> equipementTechnologie) {
		this.equipementTechnologie = equipementTechnologie;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public Quotation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
