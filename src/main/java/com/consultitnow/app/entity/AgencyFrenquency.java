package com.consultitnow.app.entity;

import java.beans.Transient;
import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;

@Entity
@AssociationOverrides({
    @AssociationOverride(name = "pk.agency",
        joinColumns = @JoinColumn(name = "agencyId")),
    @AssociationOverride(name = "pk.freqencyBand",
        joinColumns = @JoinColumn(name = "freqencyBandId")) })
public class AgencyFrenquency implements Serializable{
	
	@EmbeddedId
	private AgencyFrenquencyId pk;
	
	private Boolean isHomologue;

	public AgencyFrenquencyId getPk() {
		return pk;
	}

	public void setPk(AgencyFrenquencyId pk) {
		this.pk = pk;
	}

	public Boolean getIsHomologue() {
		return isHomologue;
	}

	public void setIsHomologue(Boolean isHomologue) {
		this.isHomologue = isHomologue;
	}
	
	
	
	@Transient
	public void setAgency(Agency agency) {
		this.pk.setAgency(agency); 
	}

	
	public Agency getAgency(){
		return this.pk.getAgency();
	}
	public FrequencyBand getFreqencyBand() {
		return this.pk.getFreqencyBand();
	}

	@Transient
	public void setFreqencyBand(FrequencyBand freqencyBand) {
		this.pk.setFreqencyBand(freqencyBand);
	}

}
