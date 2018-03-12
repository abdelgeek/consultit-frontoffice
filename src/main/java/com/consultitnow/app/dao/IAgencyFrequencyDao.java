package com.consultitnow.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultitnow.app.entity.Agency;
import com.consultitnow.app.entity.AgencyFrequencyBand;
import com.consultitnow.app.entity.FrequencyBand;

public interface IAgencyFrequencyDao extends JpaRepository<AgencyFrequencyBand, Long> {

	public List<AgencyFrequencyBand> findByFrequencyBandAndIsFrequencyAuthorized(FrequencyBand frequencyBand,Boolean isAuthorized) ;
	
	public List<AgencyFrequencyBand> findByFrequencyBand(FrequencyBand frequencyBand);
	

	public AgencyFrequencyBand findByFrequencyBandAndAgency(FrequencyBand frequencyBand, Agency agency);
}
