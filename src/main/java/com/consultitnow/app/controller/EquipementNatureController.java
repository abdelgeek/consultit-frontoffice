package com.consultitnow.app.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.consultitnow.app.dao.IApprovalTypeDao;
import com.consultitnow.app.dao.IEquipementNatureDao;
import com.consultitnow.app.entity.ApprovalType;
import com.consultitnow.app.entity.EquipementNature;
import com.consultitnow.app.entity.EquipementTechnologie;

@CrossOrigin
@RestController
public class EquipementNatureController  {


	@Autowired
	private IEquipementNatureDao equipementNatureDao;
	@Autowired
	private IApprovalTypeDao approvalTypeDao;
	
	@RequestMapping(value="/findEqmNatureByApprovalType", method=RequestMethod.GET)
	public List<EquipementNature> findByApprovalType(Long approvalId){
		
		System.out.println("***** Get equipement nature by approval type name ***");
		ApprovalType approvalType = new ApprovalType();
		List<EquipementNature> equipementNatures = new LinkedList<EquipementNature>();	
		
 		if(approvalId != null){
 			System.out.println("***** approval Type id non null ***");
 			System.out.println(approvalId);
			approvalType = approvalTypeDao.findOne(approvalId);
			
			equipementNatures = equipementNatureDao.findByApprovalType(approvalType);
		}else{
			System.out.println("***** approval Type id non null ***");
		}
 		
 		return equipementNatures;
	}
	
	
	@RequestMapping(value="/findEquipementNature", method=RequestMethod.GET)
	public EquipementNature findOne(Long id ){
		return equipementNatureDao.findOne(id);
	}
	
	
}
