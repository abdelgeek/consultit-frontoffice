package com.consultitnow.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultitnow.app.entity.CountryFrequencyBand;
import com.consultitnow.app.entity.FrequencyBand;

public interface ICountryFrequencyDao extends JpaRepository<CountryFrequencyBand, Long> {

	public List<CountryFrequencyBand> findByFrequencyBandAndAuthorized(FrequencyBand frequencyBand,Boolean isAuthorized) ;
	
	public List<CountryFrequencyBand> findByFrequencyBand(FrequencyBand frequencyBand);}
