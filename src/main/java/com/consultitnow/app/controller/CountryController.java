package com.consultitnow.app.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.consultitnow.app.dao.ICountryDao;
import com.consultitnow.app.entity.Country;
import com.consultitnow.model.CountryResult;
import com.consultitnow.model.Result;

@RestController
public class CountryController {

	@Autowired
	private ICountryDao countryDao;

	
	
	// save a new country
	@RequestMapping(value = "/saveCountry", method = RequestMethod.POST)
	public CountryResult save(Country country) {
		
		//1-cree un objet CountryResult qui varetourner les données a la vue
		
		CountryResult result = new CountryResult();
		result.setIsValid(false);
		result.setCountry(null);

		//2- recuperer les données de la vue
		
		String countryName = country.getCountryName();
		Long countryId = country.getId();

		//3-verifie si le pays est null
		
		if (countryName.isEmpty()) {
			result.setMessage("Erreur: Entrez le nom du pays");
			System.out.println("Erreur:  nom du pays vide");
		} else {

			//4- sinon verifie si le pays existe
			
			if (countryDao.findByCountryName(countryName.trim()) == null) {

				Country c = new Country();
				System.out.println(countryName.trim().toUpperCase());
				c = countryDao.save(new Country(countryId, countryName.trim().toUpperCase(),true));

				result.setIsValid(true);
				result.setMessage("Succes: Pays ajouté avec succes");
				result.setCountry(c);

				System.out.println("Succes: Pays ajouté avec succes");

			} else {
				result.setMessage("Erreur: Ce pays existe déja");
				System.out.println("Erreur:  duplica du nom");
			}
		}

		return result;
	}

	
	//find all counrty
	@RequestMapping(value = "/findCountries", method = RequestMethod.GET)
	public List<Country> findAll() {
		return countryDao.findByIsActive(true);
	}
	
	
	
	//delete a country
	/*
	 * this method not delete the country but it disable it
	 */
	@RequestMapping(value="/deleteCountry", method=RequestMethod.POST)
	public Result delete(Country c){
		
		Result result = new Result("Erreur", false);
		boolean isDeleted = false;
		System.out.println(c.toString());
		
		//1. verifie si le pays existe
		if (countryDao.findByCountryName(c.getCountryName().trim()) == null){
			System.out.println("Erreur: Cet pays n'existe pas");
			result.setMessage("Erreur: Cet pays n'existe pas");
		}else{
			c.setIsActive(false);
			countryDao.save(c);
			result.setMessage("Succes: Pays supprimé avec succes");
			result.setIsValid(true);
			System.out.println("Cet pays a été supprimé");
		}
		
		return result;
	}
}
