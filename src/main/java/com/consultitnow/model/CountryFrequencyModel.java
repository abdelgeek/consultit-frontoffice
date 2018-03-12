package com.consultitnow.model;

import java.util.LinkedList;

public class CountryFrequencyModel {

	private LinkedList<Long> lfrequencyId;
	private Long countryId;

	public LinkedList<Long> getLfrequencyId() {
		return lfrequencyId;
	}

	public void setLfrequencyId(LinkedList<Long> lfrequencyId) {
		this.lfrequencyId = lfrequencyId;
	}

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public CountryFrequencyModel(){
		
	}
}
