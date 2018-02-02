package com.consultitnow.app.entity;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class EquipmentNature implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;

	@ManyToOne()
	private ApprovalType approvalType;

	@Column(nullable = false)
	private Boolean hasFrequency;

	/*
	 * @JsonIgnore
	 * 
	 * @OneToMany(mappedBy="equipmentNature") private List<EquipmentTechnologie>
	 * equipmentTechnologie;
	 */

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

	public Boolean getHasFrequency() {
		return hasFrequency;
	}

	public void setHasFrequency(Boolean hasFrequency) {
		this.hasFrequency = hasFrequency;
	}

	public void setApprovalType(ApprovalType approvalType) {
		this.approvalType = approvalType;
	}

	/*
	 * public List<EquipmentTechnologie> getEquipementTechnologie() { return
	 * equipmentTechnologie; }
	 * 
	 * public void setEquipementTechnologie(List<EquipmentTechnologie>
	 * equipmentTechnologie) { this.equipmentTechnologie = equipmentTechnologie;
	 * }
	 * 
	 * /* public List<EquipmentTechnologie> getEquipmentTechnologie() { return
	 * equipmentTechnologie; }
	 * 
	 * public void setEquipmentTechnologie(List<EquipmentTechnologie>
	 * equipmentTechnologie) { this.equipmentTechnologie = equipmentTechnologie;
	 * }
	 */

	public EquipmentNature() {
		super();
		// TODO Auto-generated constructor stub
	}

}
