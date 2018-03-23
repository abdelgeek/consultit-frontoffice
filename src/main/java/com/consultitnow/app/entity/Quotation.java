package com.consultitnow.app.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Quotation implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.DATE)
	private Date date;
	private Integer status;
	private Boolean hasEncryptionFeature;
	private String dataSheetUrl;
	private Double totalAmount;
	
	
	@Column(unique=true)
	private String number;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	private ApprovalType approvalType;

	@ManyToOne(cascade=CascadeType.MERGE)
	private EquipmentType equipmentType;

	@ManyToOne(cascade=CascadeType.MERGE)
	private EquipmentNature equipmentNature;

	@JsonIgnore
	@OneToMany(mappedBy="quotation")
	private List<QuotationFrequencies> quotationFrequencies;

	@JsonIgnore
	@OneToMany(mappedBy="quotation")
	private List<QuotationTechnologies> quotationTechnologies;

	
	@JsonIgnore
	@OneToMany(mappedBy = "quotation")
	private List<PurchaseOrder> purchaseOrders;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "quotation")
	private List<QuotationAgency> quotationAgencies;
	

	public Long getId() {
		return id;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
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

	public EquipmentType getEquipementType() {
		return equipmentType;
	}

	public void setEquipementType(EquipmentType equipmentType) {
		this.equipmentType = equipmentType;
	}

	public EquipmentNature getEquipementNature() {
		return equipmentNature;
	}

	public void setEquipementNature(EquipmentNature equipmentNature) {
		this.equipmentNature = equipmentNature;
	}


	public Boolean getHasEncryptionFeature() {
		return hasEncryptionFeature;
	}

	public void setHasEncryptionFeature(Boolean hasEncryptionFeature) {
		this.hasEncryptionFeature = hasEncryptionFeature;
	}

	public String getDataSheetUrl() {
		return dataSheetUrl;
	}

	public void setDataSheetUrl(String dataSheetUrl) {
		this.dataSheetUrl = dataSheetUrl;
	}

	public EquipmentType getEquipmentType() {
		return equipmentType;
	}

	public void setEquipmentType(EquipmentType equipmentType) {
		this.equipmentType = equipmentType;
	}

	public EquipmentNature getEquipmentNature() {
		return equipmentNature;
	}

	public void setEquipmentNature(EquipmentNature equipmentNature) {
		this.equipmentNature = equipmentNature;
	}

	
	public List<PurchaseOrder> getPurchaseOrders() {
		return purchaseOrders;
	}

	public void setPurchaseOrders(List<PurchaseOrder> purchaseOrders) {
		this.purchaseOrders = purchaseOrders;
	}

	
	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	
	

	public List<QuotationFrequencies> getQuotationFrequencies() {
		return quotationFrequencies;
	}

	public void setQuotationFrequencies(List<QuotationFrequencies> quotationFrequencies) {
		this.quotationFrequencies = quotationFrequencies;
	}

	public List<QuotationTechnologies> getQuotationTechnologies() {
		return quotationTechnologies;
	}

	public void setQuotationTechnologies(List<QuotationTechnologies> quotationTechnologies) {
		this.quotationTechnologies = quotationTechnologies;
	}
	
	

	public List<QuotationAgency> getQuotationAgencies() {
		return quotationAgencies;
	}

	public void setQuotationAgencies(List<QuotationAgency> quotationAgencies) {
		this.quotationAgencies = quotationAgencies;
	}

	public Quotation() {
		super();
		// TODO Auto-generated constructor stub
	}

}
