package com.consultitnow.app.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames={"agency","frequency"}))
public class AgencyFrequencyBand implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "agency", referencedColumnName="id")
	private Agency  agency;
	


	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "frequency", referencedColumnName="id")
	private FrequencyBand  frequencyBand;
	
	private Boolean  isAuthorized;
	
	private Boolean  hasRestriction;
	
	

	public Boolean getIsAuthorized() {
		return isAuthorized;
	}

	public void setIsAuthorized(Boolean isAuthorized) {
		this.isAuthorized = isAuthorized;
	}

	public Boolean getHasRestriction() {
		return hasRestriction;
	}

	public void setHasRestriction(Boolean hasRestriction) {
		this.hasRestriction = hasRestriction;
	}

	public AgencyFrequencyBand() {
		super();
		// TODO Auto-generated constructor stub
	}

	private boolean isFrequencyAuthorized;


	

	public Agency getAgency() {
		return agency;
	}

	public void setAgency(Agency agency) {
		this.agency = agency;
	}

	public boolean isFrequencyAuthorized() {
		return isFrequencyAuthorized;
	}

	public void setFrequencyAuthorized(boolean isFrequencyAuthorized) {
		this.isFrequencyAuthorized = isFrequencyAuthorized;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public FrequencyBand getFrequencyBand() {
		return frequencyBand;
	}

	
	
	public void setFrequencyBand(FrequencyBand frequencyBand) {
		this.frequencyBand = frequencyBand;
	}



	
	
}
