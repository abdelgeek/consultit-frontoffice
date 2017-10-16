package com.consultitnow.app.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("client")
public class Client extends User {

	private String company;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private InternalAgent internalAgent;

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public InternalAgent getInternalAgent() {
		return internalAgent;
	}

	public void setInternalAgent(InternalAgent internalAgent) {
		this.internalAgent = internalAgent;
	}

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
