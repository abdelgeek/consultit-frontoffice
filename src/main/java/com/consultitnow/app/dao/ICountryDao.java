package com.consultitnow.app.dao;

import java.util.LinkedList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.consultitnow.app.entity.Agency;
import com.consultitnow.app.entity.ApprovalType;
import com.consultitnow.app.entity.Country;
import com.consultitnow.app.entity.EquipementType;

public interface ICountryDao extends JpaRepository<Country, Long> {

	@Query(value="select distinct country.id,country.name "
			+ " from agency, country,agency_approval_type,approval_type,equipement_type "
			+ " where country.id = agency.COUNTRY_id and "
			+ "agency.id = agency_approval_type.agency_id and "
			+ " approval_type.id = agency_approval_type.approval_type_id "
			+ "and equipement_type.approval_type_id =  approval_type.id "
			+ "and equipement_type.id = ?1", nativeQuery = true)
	public LinkedList<Country> findByEquipement(Long equipementId);
	
	
	@Query(value="select distinct country.id,country.name "
			+ " from agency, country,agency_approval_type,approval_type,equipement_type "
			+ " where country.id = agency.COUNTRY_id and "
			+ "agency.id = agency_approval_type.agency_id and "
			+ " approval_type.id = agency_approval_type.approval_type_id "
			+ "and agency_approval_type.id = ?1", nativeQuery = true)
	public LinkedList<Country> findByApproval(Long approvalId);
	
	
	@Query(value="select distinct country.id,country.name "
			+ " from agency, country,agency_approval_type,approval_type,equipement_type "
			+ " where country.id = agency.COUNTRY_id and "
			+ "agency.id = agency_approval_type.agency_id and "
			+ " approval_type.id = agency_approval_type.approval_type_id "
			+ " and equipement_type.approval_type_id =  approval_type.id "
			+ " and equipement_type.id = ?1"
			+ " and agency_approval_type.minFrequency<?2"
			+ " and agency_approval_type.maxFrequency>?3", nativeQuery = true)
	public LinkedList<Country> findByFrenquency(Long equipementId,float minFrequency, float maxFrequency);

}
