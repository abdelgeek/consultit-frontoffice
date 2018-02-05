package com.consultitnow.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consultitnow.app.dao.AgencyRequirementsDao;
import com.consultitnow.app.entity.AgencyRequirements;

@CrossOrigin
@RestController
public class AgencyRequirementsController {

	@Autowired
	private AgencyRequirementsDao agencyRequirementsDao;

	@GetMapping(value = "/api/findRequirements")
	public List<AgencyRequirements> findByAgencyCountryIdAndIsRequired(Long countryId) {
		return agencyRequirementsDao.findByAgencyCountryIdAndIsRequired(countryId, true);
	}
	
	@GetMapping(value = "/api/findAllRequirements")
	public List<AgencyRequirements> findAll() {
		return agencyRequirementsDao.findAll();
	}
}
