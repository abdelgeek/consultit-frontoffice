package com.consultitnow.app.entity;

import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Transient;

@Entity
@AssociationOverrides({
    @AssociationOverride(name = "primaryKey.agency",
        joinColumns = @JoinColumn(name = "agencyId")),
    @AssociationOverride(name = "primaryKey.approvalType",
        joinColumns = @JoinColumn(name = "approvalTypeId")) })
public class AgencyApprovalType implements Serializable{
	
	@EmbeddedId
	private AgencyApprovalId primaryKey;
	
	private Float minFrequency;
	private Float maxFrequency;
		
	public AgencyApprovalId getPrimaryKey() {
		return primaryKey;
	}



	public void setPrimaryKey(AgencyApprovalId primaryKey) {
		this.primaryKey = primaryKey;
	}



	public Float getMinFrequency() {
		return minFrequency;
	}



	public void setMinFrequency(Float minFrequency) {
		this.minFrequency = minFrequency;
	}



	public Float getMaxFrequency() {
		return maxFrequency;
	}



	public void setMaxFrequency(Float maxFrequency) {
		this.maxFrequency = maxFrequency;
	}



	
	@Transient
	public Agency getAgency() {
		return this.getPrimaryKey().getAgency();
	}

	public void setAgency(Agency agency) {
		this.getPrimaryKey().setAgency(agency); 
	}

	public ApprovalType getApprovalType() {
		return this.getPrimaryKey().getApprovalType();
	}

	@Transient
	public void setApprovalType(ApprovalType approvalType) {
		this.getPrimaryKey().setApprovalType(approvalType);
	}
	
}
