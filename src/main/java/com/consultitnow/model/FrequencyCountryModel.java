package com.consultitnow.model;

import java.util.LinkedList;

public class FrequencyCountryModel {
	
	
	private Long frequencyId;
	private LinkedList<Long>  lCountryId;
	
	
	public Long getFrequencyId() {
		return frequencyId;
	}


	public void setFrequencyId(Long frequencyId) {
		this.frequencyId = frequencyId;
	}




	public LinkedList<Long> getlCountryId() {
		return lCountryId;
	}


	public void setlCountryId(LinkedList<Long> lCountryId) {
		this.lCountryId = lCountryId;
	}


	public FrequencyCountryModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	
}
