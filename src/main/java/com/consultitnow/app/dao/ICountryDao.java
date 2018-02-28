package com.consultitnow.app.dao;

import java.util.LinkedList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.consultitnow.app.entity.ApprovalType;
import com.consultitnow.app.entity.Country;
import com.consultitnow.app.entity.FrequencyBand;

public interface ICountryDao extends JpaRepository<Country, Long> {

	public LinkedList<Country> findByAgenciesApprovalTypeOrderByName(ApprovalType approvalType);

	public List<Country> findByAgenciesAgencyFrequencyBandsFrequencyBandAndAgenciesAgencyFrequencyBandsIsFrequencyAuthorizedOrderByName(
			FrequencyBand frequencyBand, Boolean isAuthorized);
	
	public List<Country> findAllByOrderByName();

}
