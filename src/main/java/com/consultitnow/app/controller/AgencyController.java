package com.consultitnow.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.consultitnow.app.dao.IAgencyDao;
import com.consultitnow.app.dao.IApprovalTypeDao;
import com.consultitnow.app.dao.ICountryDao;
import com.consultitnow.app.entity.Agency;
import com.consultitnow.app.entity.ApprovalType;
import com.consultitnow.app.entity.Country;

@CrossOrigin
@RestController
public class AgencyController {

	@Autowired 
	private IAgencyDao agencyDao;
	
	@Autowired
	private IApprovalTypeDao approvalDao;
	
	@Autowired
	private ICountryDao countryDao;

	// find all agency
	@GetMapping("/api/findAgencies")
	public List<Agency> findAll() {
		return agencyDao.findAll();
	}
	
	
	// find an agency by country and approvalType
	@GetMapping("/api/findByCountryAndApprovalType")
	public Agency findByCountryAndApprovalType(Long countryId, Long approvalTypeId){
		
		Agency agency = new Agency();
		
		if( countryId != null && approvalTypeId !=null){
			
			
			System.out.println(approvalTypeId);
			Country country = countryDao.findOne(countryId);
			ApprovalType approvalType = approvalDao.findOne(approvalTypeId);
			
			agency = agencyDao.findByCountryAndApprovalTypeOrderByAgencyInitials(country, approvalType);
		}
		return agency;
	}
	
	
}
