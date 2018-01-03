package com.consultitnow.app.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ApprovalType implements Serializable {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;

	 
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

	public ApprovalType() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	

	public ApprovalType(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
}
