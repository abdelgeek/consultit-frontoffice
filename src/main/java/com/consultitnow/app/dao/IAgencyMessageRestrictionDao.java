package com.consultitnow.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultitnow.app.entity.AgencyMessageRestriction;

public interface IAgencyMessageRestrictionDao extends JpaRepository<AgencyMessageRestriction, Long>{

	
	public List<AgencyMessageRestriction> findByAgencyCountryId(Long id);
	
	public AgencyMessageRestriction findByAgencyCountryIdAndAgencyAgencyFrequencyBandsFrequencyBandIdAndAgencyAgencyFrequencyBandsHasRestriction(Long cid,Long fid,Boolean hasRestriction);
}
