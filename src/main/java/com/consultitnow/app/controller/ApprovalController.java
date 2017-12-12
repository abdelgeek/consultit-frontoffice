package com.consultitnow.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.consultitnow.app.dao.IApprovalType;
import com.consultitnow.app.entity.ApprovalType;

@RestController
public class ApprovalController {

	@Autowired
	private IApprovalType approvalTypeDao;

	// find all approval type
	@RequestMapping(value = "/findApprovalType", method = RequestMethod.GET)
	public List<ApprovalType> findAll() {
		return approvalTypeDao.findAll();
	}

	public ApprovalType findOne(Long approvalId) {
		return approvalTypeDao.findOne(approvalId);
	}

}
