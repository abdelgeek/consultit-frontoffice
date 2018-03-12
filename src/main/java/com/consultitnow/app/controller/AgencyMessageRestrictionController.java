package com.consultitnow.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consultitnow.app.dao.IAgencyMessageRestrictionDao;
import com.consultitnow.app.entity.AgencyMessageRestriction;

@RestController
@CrossOrigin
public class AgencyMessageRestrictionController {

	@Autowired
	private IAgencyMessageRestrictionDao iAgencyMessageRestrictionDao;
	
	
	@GetMapping("/api/findAgencyMessage")
	public List<AgencyMessageRestriction> findByAgencyCountryId(Long id){
		
		System.out.println(id);
		return iAgencyMessageRestrictionDao.findByAgencyCountryId(id);
	}
	
	
}
