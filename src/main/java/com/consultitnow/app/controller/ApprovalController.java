package com.consultitnow.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.consultitnow.app.dao.IApprovalTypeDao;
import com.consultitnow.app.entity.ApprovalType;

@CrossOrigin
@RestController
public class ApprovalController {

	@Autowired
	private IApprovalTypeDao approvalTypeDao;

	// find all approval type
	

	@GetMapping("/api/findApprovalType")
	public List<ApprovalType> findAll() {
		return approvalTypeDao.findAll();
	}


	@GetMapping("/api/findOneApprovalType")
	public ApprovalType findOne(Long approvalId) {
		return approvalTypeDao.findOne(approvalId);
	}
	
	public ApprovalType findByName(String approvalName) {
		return approvalTypeDao.findByName(approvalName);
	}

}
