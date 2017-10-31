package com.consultitnow.app.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("administrative")
public class AdministrativeRequirements extends Requirements {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Integer leadtime;
	private Integer certificateValidity;
	private String localRepresentative;
	private String modularApproval;
	private String famillyApproval;
	private String note;
	public Integer getLeadtime() {
		return leadtime;
	}
	public void setLeadtime(Integer leadtime) {
		this.leadtime = leadtime;
	}
	public Integer getCertificateValidity() {
		return certificateValidity;
	}
	public void setCertificateValidity(Integer certificateValidity) {
		this.certificateValidity = certificateValidity;
	}
	public String getLocalRepresentative() {
		return localRepresentative;
	}
	public void setLocalRepresentative(String localRepresentative) {
		this.localRepresentative = localRepresentative;
	}
	public String getModularApproval() {
		return modularApproval;
	}
	public void setModularApproval(String modularApproval) {
		this.modularApproval = modularApproval;
	}
	public String getFamillyApproval() {
		return famillyApproval;
	}
	public void setFamillyApproval(String famillyApproval) {
		this.famillyApproval = famillyApproval;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public AdministrativeRequirements() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
