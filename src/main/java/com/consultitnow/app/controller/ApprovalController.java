package com.consultitnow.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.consultitnow.app.dao.IApprovalTypeDao;
import com.consultitnow.app.entity.ApprovalType;


@RestController
public class ApprovalController {

	@Autowired
	private IApprovalTypeDao approvalTypeDao;

	// find all approval type
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/findApprovalType", method = RequestMethod.GET)
	public List<ApprovalType> findAll() {
		return approvalTypeDao.findAll();
	}


	@RequestMapping(value = "/findOneApprovalType", method = RequestMethod.GET)
	public ApprovalType findOne(Long approvalId) {
		return approvalTypeDao.findOne(approvalId);
	}
	
	public ApprovalType findByName(String approvalName) {
		return approvalTypeDao.findByName(approvalName);
	}

}
