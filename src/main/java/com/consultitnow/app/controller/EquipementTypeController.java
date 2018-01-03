package com.consultitnow.app.controller;


import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.consultitnow.app.dao.IApprovalType;
import com.consultitnow.app.dao.IEquipementTypeDao;
import com.consultitnow.app.entity.ApprovalType;
import com.consultitnow.app.entity.EquipementType;

@CrossOrigin("*")
@RestController
public class EquipementTypeController {
	
	@Autowired
	private IEquipementTypeDao equipementTypeDao;
	
	@Autowired
	private IApprovalType approvalTypeDao;
	
	@RequestMapping(value="/findEqmtypeByApprovalType", method=RequestMethod.GET)
	public LinkedList<EquipementType> findByApprovalType(Long approvalId){
		
		System.out.println("***** Get equipement by approval type name ***");
		ApprovalType approvalType = new ApprovalType();
		LinkedList<EquipementType> equipementTypes = new LinkedList<>();	
 		if(approvalType != null){
			approvalType = approvalTypeDao.findOne(approvalId);
			equipementTypes = equipementTypeDao.findByApprovalType(approvalType);
		}
		return equipementTypes;
	}
}
