package com.consultitnow.app.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE )
@DiscriminatorColumn(name="TypeApprovalInformation")
public class ApprovalInformation implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;

	
	
	@JsonIgnore
	@OneToMany(mappedBy="approvalInformation")
	private List<AgencyApprovalInformation> agencyApprovalInformations;
	
	

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

	public List<AgencyApprovalInformation> getAgencyApprovalInformations() {
		return agencyApprovalInformations;
	}

	public void setAgencyApprovalInformations(List<AgencyApprovalInformation> agencyApprovalInformations) {
		this.agencyApprovalInformations = agencyApprovalInformations;
	}
	
	
	
}
