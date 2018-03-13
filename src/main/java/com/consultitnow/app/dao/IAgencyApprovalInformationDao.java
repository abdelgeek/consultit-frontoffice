package com.consultitnow.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultitnow.app.entity.Agency;
import com.consultitnow.app.entity.AgencyApprovalInformation;
import com.consultitnow.app.entity.AgencyRequirements;

public interface IAgencyApprovalInformationDao extends JpaRepository<AgencyApprovalInformation, Long> {

	
	public List<AgencyApprovalInformation> findByAgency(Agency agency);
		
	public List<AgencyApprovalInformation> findByAgencyCountryId(Long countryId);
}
