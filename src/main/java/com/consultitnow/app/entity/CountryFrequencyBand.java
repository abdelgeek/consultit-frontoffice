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
@Table(uniqueConstraints = @UniqueConstraint(columnNames={"country","frequency"}))
public class CountryFrequencyBand implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "country", referencedColumnName="id")
	private Country  country;
	


	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "frequency", referencedColumnName="id")
	private FrequencyBand  frequencyBand;
	
	private boolean authorized;


	public boolean getAuthorized() {
		return authorized;
	}

	public void setAuthorized(boolean authorized) {
		this.authorized = authorized;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public FrequencyBand getFrequencyBand() {
		return frequencyBand;
	}

	public void setFrequencyBand(FrequencyBand frequencyBand) {
		this.frequencyBand = frequencyBand;
	}



	
	
}
