package com.consultitnow.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultitnow.app.entity.AgencyRequirements;

public interface AgencyRequirementsDao extends JpaRepository<AgencyRequirements, Long> {

	public List<AgencyRequirements> findByAgencyCountryIdAndIsRequired(Long countryId,boolean isRequired );
}
