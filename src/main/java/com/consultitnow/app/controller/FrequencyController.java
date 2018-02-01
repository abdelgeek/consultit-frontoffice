package com.consultitnow.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.consultitnow.app.dao.ICountryDao;
import com.consultitnow.app.dao.IfrequencyDao;
import com.consultitnow.app.entity.Country;
import com.consultitnow.app.entity.FrequencyBand;

@CrossOrigin

@RestController
public class FrequencyController {

	@Autowired
	private IfrequencyDao frequencyDao;

	@Autowired
	private ICountryDao countryDao;

	@RequestMapping(value = "/findFrequencyBand", method = RequestMethod.GET)
	public List<FrequencyBand> findFrequencyBand() {
		return frequencyDao.findAll();
	}

	@RequestMapping(value = "/findone", method = RequestMethod.GET)
	public FrequencyBand findOne(Long frequencyBandId) {
		return frequencyDao.findOne(frequencyBandId);
	}

	@RequestMapping(value = "/findFrequenciesCountry", method = RequestMethod.GET)
	public List<FrequencyBand> findByAgencyFrequencyBandsAgencyCountry(Long countryId) {
		Country country = countryDao.findOne(countryId);
		Boolean isAuthorized = true;
		return frequencyDao.findByAgencyFrequencyBandsAgencyCountryAndAgencyFrequencyBandsIsFrequencyAuthorized(country,isAuthorized);
	}
}
