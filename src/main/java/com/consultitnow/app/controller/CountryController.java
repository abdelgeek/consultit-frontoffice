package com.consultitnow.app.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.consultitnow.app.dao.IApprovalTypeDao;
import com.consultitnow.app.dao.ICountryDao;
import com.consultitnow.app.entity.Agency;
import com.consultitnow.app.entity.AgencyFrequencyBand;
import com.consultitnow.app.entity.ApprovalType;
import com.consultitnow.app.entity.Country;
import com.consultitnow.app.entity.FrequencyBand;

@CrossOrigin
@RestController
public class CountryController {

	@Autowired
	private ICountryDao countryDao;

	
	@Autowired
	private IApprovalTypeDao approvalTypeDao;

	// find all country
	@GetMapping("/api/findCountries")
	public List<Country> findAll() {
		return countryDao.findAllByOrderByName();
	}

	// find a country by id
	@GetMapping("/api/findCountry")
	public Country findOne(Long countryId) {
		return countryDao.findOne(countryId);
	}

	// find by approval
	@GetMapping("/api/findCountryByApprovalTypes")
	public LinkedList<Country> findByApproval(Long approvalId) {

		ApprovalType approvalType = new ApprovalType();
		LinkedList<Country> countries = new LinkedList<>();
		if (approvalId != null) {
			approvalType = approvalTypeDao.findOne(approvalId);
			if (approvalType != null) {
				countries = countryDao.findByAgenciesApprovalTypeOrderByName(approvalType);
			}
		}
		return countries;
	}
	
	
	// check if Frequency has Country Restriction
			@GetMapping("/api/FrequencyhasCountryRestriction")
			public List<Country> FrequencyhasCountryRestriction(Long frequencyId) {
				List<Country> countries =new LinkedList<>();
				countries = countryDao.findByAgenciesAgencyFrequencyBandsFrequencyBandIdAndAgenciesAgencyFrequencyBandsHasRestriction(frequencyId,true);
				
				return countries;
			}

}
