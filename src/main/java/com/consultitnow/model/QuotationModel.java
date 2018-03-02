package com.consultitnow.model;

import java.util.List;

public class QuotationModel {

	private Integer id;
	
	private String date;

	private Integer status;

	private Long approvalType;

	private Long equipementType;

	private Long equipementNature;

	private List<Long> frequencyBand;

	private List<Long> equipementTechnologie;

	private List<Long> category;

	private List<Long> country;

	private Double totalAmount;

	private Boolean hasEncryptionFeature;

	private String dataSheetUrl;

	public String getDate() {
		return date;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<Long> getCountry() {
		return country;
	}

	public void setCountry(List<Long> country) {
		this.country = country;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getApprovalType() {
		return approvalType;
	}

	public String getDataSheetUrl() {
		return dataSheetUrl;
	}

	public void setDataSheetUrl(String dataSheetUrl) {
		this.dataSheetUrl = dataSheetUrl;
	}

	public List<Long> getFrequencyBand() {
		return frequencyBand;
	}

	public void setFrequencyBand(List<Long> frequencyBand) {
		this.frequencyBand = frequencyBand;
	}

	public Boolean getHasEncryptionFeature() {
		return hasEncryptionFeature;
	}

	public void setHasEncryptionFeature(Boolean hasEncryptionFeature) {
		this.hasEncryptionFeature = hasEncryptionFeature;
	}

	public void setApprovalType(Long approvalTypeId) {
		this.approvalType = approvalTypeId;
	}

	public Long getEquipementType() {
		return equipementType;
	}

	public void setEquipementType(Long equipementTypeId) {
		this.equipementType = equipementTypeId;
	}

	public Long getEquipementNature() {
		return equipementNature;
	}

	public void setEquipementNature(Long equipementNatureId) {
		this.equipementNature = equipementNatureId;
	}

	public List<Long> getEquipementTechnologie() {
		return equipementTechnologie;
	}

	public void setEquipementTechnologie(List<Long> equipementTechnologieId) {
		this.equipementTechnologie = equipementTechnologieId;
	}

	public List<Long> getCategory() {
		return category;
	}

	public void setCategory(List<Long> categoriesId) {
		this.category = categoriesId;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "QuotationModel [date=" + date + ", status=" + status + ", approvalType=" + approvalType
				+ ", equipementType=" + equipementType + ", equipementNature=" + equipementNature + ", frequencyBand="
				+ frequencyBand + ", equipementTechnologie=" + equipementTechnologie + ", category=" + category
				+ ", hasEncryptionFeature=" + hasEncryptionFeature + ", dataSheetUrl=" + dataSheetUrl + "]";
	}

}
