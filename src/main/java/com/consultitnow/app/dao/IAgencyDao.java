package com.consultitnow.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.consultitnow.app.entity.Agency;
import com.consultitnow.app.entity.ApprovalType;
import com.consultitnow.app.entity.Country;


public interface IAgencyDao extends JpaRepository<Agency, Long> {


	 
	
	public Agency findByCountryAndApprovalTypeOrderByAgencyInitials(Country country, ApprovalType approvalType);
	
	public Agency findByCountry(Country country);
}
