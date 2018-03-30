package com.consultitnow.app.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.consultitnow.app.dao.IAgencyDao;
import com.consultitnow.app.dao.IAgencyFrequencyDao;
import com.consultitnow.app.dao.IAgencyMessageRestrictionDao;
import com.consultitnow.app.dao.IApprovalTypeDao;
import com.consultitnow.app.dao.ICountryDao;
import com.consultitnow.app.dao.IfrequencyDao;
import com.consultitnow.app.entity.Agency;
import com.consultitnow.app.entity.AgencyFrequencyBand;
import com.consultitnow.app.entity.AgencyMessageRestriction;
import com.consultitnow.app.entity.ApprovalType;
import com.consultitnow.app.entity.Country;
import com.consultitnow.app.entity.FrequencyBand;
import com.consultitnow.model.CountryFrequencyModel;
import com.consultitnow.model.FrequencyCountryModel;

@CrossOrigin
@RestController
public class AgencyController {

	@Autowired
	private IAgencyDao agencyDao;

	@Autowired
	private IApprovalTypeDao approvalDao;

	@Autowired
	private IfrequencyDao ifrequencyDao;

	@Autowired
	private ICountryDao countryDao;

	@Autowired
	private IAgencyFrequencyDao agencyFrequencyDao;
	
	@Autowired
	private IAgencyMessageRestrictionDao agencyMessageRestrictionDao;

	// find all agency
	@GetMapping("/api/findAgencies")
	public List<Agency> findAll() {
		return agencyDao.findAll();
	}

	// find an agency by country and approvalType
	@GetMapping("/api/findByCountryAndApprovalType")
	public Agency findByCountryAndApprovalType(@RequestBody Long countryId, @RequestBody Long approvalTypeId) {

		Agency agency = new Agency();

		if (countryId != null && approvalTypeId != null) {

			System.out.println(approvalTypeId);
			Country country = countryDao.findOne(countryId);
			ApprovalType approvalType = approvalDao.findOne(approvalTypeId);

			agency = agencyDao.findByCountryAndApprovalTypeOrderByAgencyInitials(country, approvalType);
		}
		return agency;
	}

	// check if agency has restriction
	@PostMapping("/api/hasCountryFrequencyRestriction")
	public Boolean hasFrequencyRestriction(@RequestBody CountryFrequencyModel countryFrequencyModel) {

		Boolean hasRestiction = false;

		LinkedList<Long> lfrequencyId = countryFrequencyModel.getLfrequencyId();
		Long countryId = countryFrequencyModel.getCountryId();

		Country country = new Country();
		country = countryDao.findOne(countryId);

		Agency agency = new Agency();
		agency = agencyDao.findByCountry(country);

		if (lfrequencyId.size() > 0) {
			for (Long item : lfrequencyId) {
				FrequencyBand frequencyBand = new FrequencyBand();
				frequencyBand = ifrequencyDao.findOne(item);

				AgencyFrequencyBand agencyFrequencyBand = new AgencyFrequencyBand();

				agencyFrequencyBand = agencyFrequencyDao.findByFrequencyBandAndAgency(frequencyBand, agency);

				hasRestiction = agencyFrequencyBand.getHasRestriction();

				if (hasRestiction) {
					break;
				}
			}
		}
		return hasRestiction;
	}

	// check if frequency has restricted on the selected country
	@PostMapping("/api/findFrequencyAgencyMessage")
	public List<String> findFrequencyAgencyMessage(@RequestBody FrequencyCountryModel FrequencyCountryModel) {

		
		
		List<String> lMessage = new LinkedList<>();
		Long frequencyId = FrequencyCountryModel.getFrequencyId();
		FrequencyBand frequencyBand = new FrequencyBand();
		
		System.out.println("frequencyId" + FrequencyCountryModel.getFrequencyId());
		frequencyBand = ifrequencyDao.findOne(frequencyId);

		LinkedList<Long> lCountryId = FrequencyCountryModel.getlCountryId();

		if (lCountryId.size() > 0) {
			for (Long countryId : lCountryId) {
				Country country = new Country();
				country = countryDao.findOne(countryId);

				Agency agency = new Agency();
				agency = agencyDao.findByCountry(country);
				
				AgencyFrequencyBand agencyFrequencyBand = new AgencyFrequencyBand();
				agencyFrequencyBand = agencyFrequencyDao.findByFrequencyBandAndAgency(frequencyBand, agency);

				Boolean hasRestiction = agencyFrequencyBand.getHasRestriction();
				
				if(hasRestiction){
					AgencyMessageRestriction agencyMessageRestriction = new AgencyMessageRestriction();
					agencyMessageRestriction =agencyMessageRestrictionDao.findByAgencyCountryIdAndAgencyAgencyFrequencyBandsFrequencyBandIdAndAgencyAgencyFrequencyBandsHasRestriction(countryId, frequencyId, true);
				lMessage.add(agencyMessageRestriction.getMessage());
				}

			}
		}

		
		return lMessage;
	}

}
