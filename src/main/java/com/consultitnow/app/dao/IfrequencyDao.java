package com.consultitnow.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultitnow.app.entity.Country;
import com.consultitnow.app.entity.FrequencyBand;

public interface IfrequencyDao extends JpaRepository<FrequencyBand, Long>{

	
	
	public List<FrequencyBand> findByAgencyFrequencyBandsAgencyCountryAndAgencyFrequencyBandsIsFrequencyAuthorized(Country country,Boolean isAuthorized);
}
