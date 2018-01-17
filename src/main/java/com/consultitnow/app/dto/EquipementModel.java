package com.consultitnow.app.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.consultitnow.app.entity.ApprovalType;
import com.consultitnow.app.entity.Category;
import com.consultitnow.app.entity.EquipementNature;
import com.consultitnow.app.entity.EquipementTechnologie;
import com.consultitnow.app.entity.EquipementType;
import com.consultitnow.app.entity.FrequencyBand;

public class EquipementModel {

	private Long id;
	private String name;
	private String brand;
	private Boolean isEncrypt;
	private Long approvalTypeId;
	private Long equipementTypeId;
	private Long equipementNatureId;
	private List<Long> equipementTechnologieId;
	private List<Long> frequencyId;
	private List<Long> categoryId;

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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Boolean getIsEncrypt() {
		return isEncrypt;
	}

	public void setIsEncrypt(Boolean isEncrypt) {
		this.isEncrypt = isEncrypt;
	}

	public Long getApprovalTypeId() {
		return approvalTypeId;
	}

	public void setApprovalTypeId(Long approvalTypeId) {
		this.approvalTypeId = approvalTypeId;
	}

	public Long getEquipementTypeId() {
		return equipementTypeId;
	}

	public void setEquipementTypeId(Long equipementTypeId) {
		this.equipementTypeId = equipementTypeId;
	}

	public Long getEquipementNatureId() {
		return equipementNatureId;
	}

	public void setEquipementNatureId(Long equipementNatureId) {
		this.equipementNatureId = equipementNatureId;
	}

	public List<Long> getEquipementTechnologieId() {
		return equipementTechnologieId;
	}

	public void setEquipementTechnologieId(List<Long> equipementTechnologieId) {
		this.equipementTechnologieId = equipementTechnologieId;
	}

	public List<Long> getFrequencyId() {
		return frequencyId;
	}

	public void setFrequencyId(List<Long> frequencyId) {
		this.frequencyId = frequencyId;
	}

	public List<Long> getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(List<Long> categoryId) {
		this.categoryId = categoryId;
	}

	public EquipementModel() {
		super();
		// TODO Auto-generated constructor stub
	}

}
