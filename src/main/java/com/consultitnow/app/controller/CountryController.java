package com.consultitnow.app.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.consultitnow.app.dao.ICountryDao;
import com.consultitnow.app.entity.Country;
import com.consultitnow.app.entity.EquipementType;
import com.consultitnow.model.CountryResult;
import com.consultitnow.model.Result;

@RestController
public class CountryController {

	@Autowired
	private ICountryDao countryDao;

		
	//find all counrty
	@RequestMapping(value = "/findCountries", method = RequestMethod.GET)
	public List<Country> findAll() {
		return countryDao.findAll();
	}
	
	
	//get a country that approve an equipement type
	/*@RequestMapping(value = "/findCountryByEquipementTypes", method = RequestMethod.GET)
	public List<Country> findByAgenciesEquipementTypes(EquipementType equipementType){
		return  countryDao.findByAgenciesEquipementTypes(equipementType);
	}*/
		

}
