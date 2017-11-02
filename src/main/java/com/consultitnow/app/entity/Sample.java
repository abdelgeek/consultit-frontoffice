package com.consultitnow.app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Sample {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private Boolean isNewApproval;
	private Boolean isRenewal;
	private String type;
	private String localTest ;
	private String note;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Agency agency;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Boolean getIsNewApproval() {
		return isNewApproval;
	}

	public void setIsNewApproval(Boolean isNewApproval) {
		this.isNewApproval = isNewApproval;
	}

	public Boolean getIsRenewal() {
		return isRenewal;
	}

	public void setIsRenewal(Boolean isRenewal) {
		this.isRenewal = isRenewal;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLocalTest() {
		return localTest;
	}

	public void setLocalTest(String localTest) {
		this.localTest = localTest;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Agency getAgency() {
		return agency;
	}

	public void setAgency(Agency agency) {
		this.agency = agency;
	}

	public Sample() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
