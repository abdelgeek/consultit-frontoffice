package com.consultitnow.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultitnow.app.entity.Agency;


public interface IAgencyDao extends JpaRepository<Agency, Long> {

	
	//get all active country
		public List<Agency> findByIsActiveAndCountryIsActive(Boolean isActiveAgency,Boolean isActiveCountry);
		
		//get one agency by his  name
		public Agency findByAgencyName(String AgencyName);
		
	
		
		//get one agency by his  id
		public Agency findById(Long AgencyId);
		
}
