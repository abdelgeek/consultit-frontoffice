package com.consultitnow.app.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class AgencyFrenquencyId implements Serializable{

	
	@ManyToOne
	private Agency agency;
	
	@ManyToOne
	private FrequencyBand freqencyBand;

	public Agency getAgency() {
		return agency;
	}

	public void setAgency(Agency agency) {
		this.agency = agency;
	}

	public FrequencyBand getFreqencyBand() {
		return freqencyBand;
	}

	public void setFreqencyBand(FrequencyBand freqencyBand) {
		this.freqencyBand = freqencyBand;
	}
	
	
	
}
