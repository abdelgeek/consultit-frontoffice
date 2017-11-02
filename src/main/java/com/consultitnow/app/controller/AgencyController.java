package com.consultitnow.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.consultitnow.app.dao.IAgencyDao;
import com.consultitnow.app.dao.ICountryDao;
import com.consultitnow.app.entity.Agency;
import com.consultitnow.app.entity.Country;
import com.consultitnow.model.AgencyModel;
import com.consultitnow.model.AgencyResult;
import com.consultitnow.model.Result;

@RestController
public class AgencyController {

	@Autowired
	private IAgencyDao agencyDao;

	@Autowired
	private ICountryDao countryDao;

	// save a new agency
	@RequestMapping(value = "/saveAgency", method = RequestMethod.POST)
	public AgencyResult save(AgencyModel agencyModel) {

		System.out.println(agencyModel.toString());

		// 1-cree un objet AgencyResult qui va retourner les données a la vue

		AgencyResult result = new AgencyResult();
		result.setIsValid(false);
		result.setAgency(null);

		// 2- recuperer les données de la vue

		Long id = agencyModel.getId();
		String agencyName = agencyModel.getAgencyName();
		String agencyInitials = agencyModel.getAgencyInitials();
		String agencyLink = agencyModel.getLink();
		String countryName = agencyModel.getCountryName();
		Boolean isActive = agencyModel.getIsActive();

		if (agencyName.isEmpty() || agencyInitials.isEmpty()) {
			result.setMessage("Erreur: Renseignez tous les champs");
			System.out.println("Erreur:  renseigner tous les champs");
		} else {

			// 4- sinon verifie si le pays existe

			if (id != null) {
				if (agencyDao.findById(id) != null) {

					Country c = countryDao.findByCountryName(countryName);

					Agency agency = new Agency(id, agencyName, agencyLink, agencyInitials, c, isActive);
					agencyDao.save(agency);
					result.setIsValid(true);
					result.setAgency(agency);

					result.setMessage("Succes: Agence modifiée avec succes");

					System.out.println("Succes: Agence modifiée avec succes");

				} else {
					result.setMessage("Erreur: Cette agence n'existe pas");
					result.setIsValid(false);
					System.out.println("Erreur:   Cette agence n'existe pas");
				}
			} else {

				if (agencyDao.findByAgencyName(agencyName) == null) {

					Country c = countryDao.findByCountryName(countryName);

					Agency agency = new Agency(id, agencyName, agencyLink, agencyInitials, c, isActive);
					agencyDao.save(agency);
					result.setIsValid(true);

					result.setAgency(agency);
					result.setMessage("Succes: Agence enregistrée avec succes");

					System.out.println("Succes: Agence enregistrée avec succes");
				} else {
					result.setMessage("Erreur: Cette agence existe déja");
					System.out.println("Erreur:   Cette agence existe déja");
					result.setIsValid(false);
				}
			}

		}

		return result;
	}

	// find all agency
	@RequestMapping(value = "/findAgencies", method = RequestMethod.GET)
	public List<Agency> findAll() {
		return agencyDao.findByIsActiveAndCountryIsActive(true, true);
	}
	
	
	
	//delete an agency
		/*
		 * this method not delete the country but it disable it
		 */
		@RequestMapping(value="/deleteAngency", method=RequestMethod.POST)
		public Result delete(AgencyModel am){
			
			Result result = new Result("Erreur", false);
			
			
			System.out.println(am.toString());
			//1. verifie si le pays existe
			if (agencyDao.findById(am.getId()) == null){
				System.out.println("Erreur: Cette agence n'existe pas");
				result.setMessage("Erreur: Cette agence  n'existe pas");
			}else{
				
				Country c = countryDao.findByCountryName(am.getCountryName());
				Agency agency =new Agency(am.getId(), am.getAgencyName(), am.getLink(), am.getAgencyInitials(), c, false);
				
				agencyDao.save(agency);
				result.setMessage("Succes: Agence supprimée avec succes");
				result.setIsValid(true);
				System.out.println("Cette agence a été supprimée");
			}
			
			return result;
		}
}
