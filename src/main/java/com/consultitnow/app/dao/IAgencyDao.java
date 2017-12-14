package com.consultitnow.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.consultitnow.app.entity.Agency;
import com.consultitnow.app.entity.ApprovalType;
import com.consultitnow.app.entity.Country;


public interface IAgencyDao extends JpaRepository<Agency, Long> {

	 public List<Agency> findByAgencyApprovalTypesPrimaryKeyApprovalType(ApprovalType approvalType) ;

	 
	 /*select * from agency as
	 a,agency_approval_type as apt ,
	 approval_type as ap where a.id = apt.agency_id and 
	 apt.approval_type_id = ap.id and 2000<max_frequency and 2000>min_frequency*/
			 
			 
	 @Query("select a from Agency a, "
	 		+ " AgencyApprovalType apt, ApprovalType ap"
	 		+ " where a.id = apt.primaryKey.agency.id and apt.primaryKey.approvalType.id = ap.id")
	 public List<Agency> findByAgencyfrequenct();

}
