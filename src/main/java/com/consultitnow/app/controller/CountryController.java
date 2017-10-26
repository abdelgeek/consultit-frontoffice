package com.consultitnow.app.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.consultitnow.app.dao.ICountryDao;
import com.consultitnow.app.entity.Country;
import com.consultitnow.model.Result;

@RestController
public class CountryController {

	@Autowired
	private ICountryDao countryDao;

	@RequestMapping(value = "/saveCountry", method = RequestMethod.POST)
	public Result save(Country country) {
		Result result = new Result();
		result.setIsValid(false);

		String countryName = country.getCountryName();
		Long countryId = country.getId();
		
		
		
		
		if (countryName.isEmpty()) {
			result.setMessage("Erreur: Entrez le nom du pays");
			System.out.println("Erreur:  nom du pays vide");
		} else {
			
			

			if (countryDao.findByCountryName(countryName) == null) {

				Country c = new Country();
				
				c.setCountryName(countryName);
				c.setId(countryId);
				
				countryDao.save(c);
				result.setIsValid(true);
				result.setMessage("Succes: Pays ajouté avec succes");
				System.out.println("Succes: Pays ajouté avec succes");

			} else {
				result.setMessage("Erreur: Ce pays existe déja");
				System.out.println("Erreur:  duplica du nom");
			}
		}

		return result;
	}

	@RequestMapping(value = "/findCountries", method = RequestMethod.GET)
	public List<Country> findAll() {
		return countryDao.findAll();
	}
}
