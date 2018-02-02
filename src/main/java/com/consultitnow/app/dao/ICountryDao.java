package com.consultitnow.app.dao;

import java.util.LinkedList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.consultitnow.app.entity.ApprovalType;
import com.consultitnow.app.entity.Country;
import com.consultitnow.app.entity.FrequencyBand;

public interface ICountryDao extends JpaRepository<Country, Long> {

	public LinkedList<Country> findByAgenciesApprovalType(ApprovalType approvalType);

	public List<Country> findByAgenciesAgencyFrequencyBandsFrequencyBandAndAgenciesAgencyFrequencyBandsIsFrequencyAuthorized(
			FrequencyBand frequencyBand, Boolean isAuthorized);

}
