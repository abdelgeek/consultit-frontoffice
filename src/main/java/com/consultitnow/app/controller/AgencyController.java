package com.consultitnow.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.consultitnow.app.dao.IAgencyDao;
import com.consultitnow.app.dao.IApprovalType;
import com.consultitnow.app.dao.ICountryDao;
import com.consultitnow.app.entity.Agency;
import com.consultitnow.app.entity.ApprovalType;
import com.consultitnow.app.entity.Country;
import com.consultitnow.model.AgencyModel;
import com.consultitnow.model.AgencyResult;
import com.consultitnow.model.Result;

@RestController
public class AgencyController {

	@Autowired
	private IAgencyDao agencyDao;
	
	@Autowired
	private IApprovalType approvalDao;

	// find all agency
	@RequestMapping(value = "/findAgencies", method = RequestMethod.GET)
	public List<Agency> findAll() {
		return agencyDao.findAll();
	}
	
	
	//Find Agency by Approval Type
	@RequestMapping(value="/findAgencyByApprovalType", method = RequestMethod.GET)
	public List<Agency> findByAgencyApprovalTypesPrimaryKeyApprovalType(Long approvalTypeId) {
		return agencyDao.findByAgencyApprovalTypesPrimaryKeyApprovalType(approvalDao.findOne(approvalTypeId));
	}

	@RequestMapping(value="/findByAgencyfrequenct", method = RequestMethod.GET)
	 public List<Agency> findByAgencyfrequenct() {
		 return agencyDao.findByAgencyfrequenct();
	 }
}
