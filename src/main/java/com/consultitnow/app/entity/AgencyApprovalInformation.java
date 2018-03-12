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
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "agency", "approvalInformation" }))
public class AgencyApprovalInformation implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "agency", referencedColumnName = "id")
	private Agency agency;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "approvalInformation", referencedColumnName = "id")
	private ApprovalInformation approvalInformation;
	
	
	private Boolean isAccepted;
	private String duration;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Agency getAgency() {
		return agency;
	}

	public void setAgency(Agency agency) {
		this.agency = agency;
	}

	public ApprovalInformation getApprovalInformation() {
		return approvalInformation;
	}

	public void setApprovalInformation(ApprovalInformation approvalInformation) {
		this.approvalInformation = approvalInformation;
	}

	public Boolean getIsAccepted() {
		return isAccepted;
	}

	public void setIsAccepted(Boolean isAccepted) {
		this.isAccepted = isAccepted;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	

}
