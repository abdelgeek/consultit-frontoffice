package com.consultitnow.app.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.consultitnow.app.dao.IApprovalTypeDao;
import com.consultitnow.app.dao.ICountryDao;
import com.consultitnow.app.dao.ICountryFrequencyDao;
import com.consultitnow.app.dao.IfrequencyDao;
import com.consultitnow.app.entity.ApprovalType;
import com.consultitnow.app.entity.Country;
import com.consultitnow.app.entity.CountryFrequencyBand;
import com.consultitnow.app.entity.FrequencyBand;

@CrossOrigin
@RestController
public class CountryController {

	@Autowired
	private ICountryDao countryDao;

	@Autowired
	private IfrequencyDao ifrequencyDao;

	@Autowired
	private IApprovalTypeDao approvalTypeDao;

	// find all counrty
	@RequestMapping(value = "/findCountries", method = RequestMethod.GET)
	public List<Country> findAll() {
		return countryDao.findAll();
	}

	// find a counrty by id
	@RequestMapping(value = "/findCountry", method = RequestMethod.GET)
	public Country findOne(Long countryId) {
		return countryDao.findOne(countryId);
	}

	// find by approval
	@RequestMapping(value = "/findCountryByApprovalTypes", method = RequestMethod.GET)
	public LinkedList<Country> findByApproval(Long approvalId) {

		ApprovalType approvalType = new ApprovalType();
		LinkedList<Country> countries = new LinkedList<>();
		if (approvalId != null) {
			approvalType = approvalTypeDao.findOne(approvalId);
			if (approvalType != null) {
				countries = countryDao.findByAgenciesApprovalType(approvalType);
			}
		}
		return countries;
	}

	// find contry by frequency
	@GetMapping("/findCountryfrequency")
	public List<Country> findByFrequencyBandAndAuthorized(Long idFrequency) {

		FrequencyBand frequencyBand = new FrequencyBand();
		frequencyBand = ifrequencyDao.findOne(idFrequency);
		return countryDao.findByCountryFrequencyBandsFrequencyBandAndCountryFrequencyBandsAuthorized(frequencyBand,true);
	}

}
