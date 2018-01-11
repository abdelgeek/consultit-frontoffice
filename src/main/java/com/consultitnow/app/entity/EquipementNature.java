package com.consultitnow.app.entity;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
public class EquipementNature implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	
	@ManyToOne()
	private ApprovalType approvalType;
	
	
	@JsonIgnoreProperties("equipementNature")
	@OneToMany(mappedBy="equipementNature")
	private List<EquipementTechnologie> equipementTechnologie;

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

	public ApprovalType getApprovalType() {
		return approvalType;
	}

	public void setApprovalType(ApprovalType approvalType) {
		this.approvalType = approvalType;
	}

	public List<EquipementTechnologie> getEquipementTechnologie() {
		return equipementTechnologie;
	}

	public void setEquipementTechnologie(List<EquipementTechnologie> equipementTechnologie) {
		this.equipementTechnologie = equipementTechnologie;
	}
	
	
	
	

}
