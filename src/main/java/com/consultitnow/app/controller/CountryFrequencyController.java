package com.consultitnow.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.consultitnow.app.dao.ICountryFrequencyDao;
import com.consultitnow.app.dao.IfrequencyDao;
import com.consultitnow.app.entity.CountryFrequencyBand;
import com.consultitnow.app.entity.FrequencyBand;

@CrossOrigin
@RestController
public class CountryFrequencyController {
	
	@Autowired
	private ICountryFrequencyDao countryFrequencyDao;
	
	@Autowired
	private IfrequencyDao ifrequencyDao;
	

	
	@GetMapping("/findByFrequencyBandAndAuthorized")
	public List<CountryFrequencyBand> findByFrequencyBandAndAuthorized(Long idFrequencyBand){
		
		
		FrequencyBand frequencyBand = new FrequencyBand();
		
		frequencyBand = ifrequencyDao.getOne(idFrequencyBand);
		
		
		System.out.println(frequencyBand.toString());
		return countryFrequencyDao.findAll();
	}
}
