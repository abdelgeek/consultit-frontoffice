package com.consultitnow.app.controller;

import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.consultitnow.app.dao.IAgencyDao;
import com.consultitnow.app.dao.IApprovalTypeDao;
import com.consultitnow.app.dao.ICountryDao;
import com.consultitnow.app.entity.Agency;
import com.consultitnow.app.entity.ApprovalType;
import com.consultitnow.app.entity.Country;
import com.consultitnow.model.AgencyModel;
import com.consultitnow.model.AgencyResult;
import com.consultitnow.model.Result;

@RestController
public class AgencyController {

	@Autowired 
	private IAgencyDao agencyDao;
	
	@Autowired
	private IApprovalTypeDao approvalDao;

	// find all agency
	@RequestMapping(value = "/findAgencies", method = RequestMethod.GET)
	public List<Agency> findAll() {
		return agencyDao.findAll();
	}
	
	
	// find all agency
	@RequestMapping(value = "/findAgencyByCountry", method = RequestMethod.GET)
	public Country findByCountry(Country country){
		
		return agencyDao.findByCountry(country);
	}
	
	
}
