package com.consultitnow.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultitnow.app.entity.Agency;
import com.consultitnow.app.entity.AgencyRequirements;

public interface IAgencyRequirementsDao extends JpaRepository<AgencyRequirements, Long> {

	
	public List<AgencyRequirements> findByAgency(Agency agency);
}
