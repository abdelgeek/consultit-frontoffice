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
import com.consultitnow.app.dao.IEquipementTechnologieDao;
import com.consultitnow.app.entity.ApprovalType;
import com.consultitnow.app.entity.EquipementNature;
import com.consultitnow.app.entity.EquipementTechnologie;

@CrossOrigin("*")
@RestController
public class EquipementTechnologieController {
	
	@Autowired
	private IEquipementTechnologieDao equipementTechnologieDao;
	
	@Autowired
	private IEquipementNatureDao equipementNatureDao;
	
	@RequestMapping(value="/findByEquipementNature", method=RequestMethod.GET)
	public LinkedList<EquipementTechnologie> findByEquipementNature(Long eqpmtNatureId){
		
		System.out.println("***** Get equipement by equipepemnt nature ***");
		EquipementNature equipementNature = new EquipementNature();
		equipementNature = equipementNatureDao.findOne(eqpmtNatureId);
		
		System.out.println(equipementNature.toString());
		LinkedList<EquipementTechnologie> equipementTechnologies = new LinkedList<>();	
 		if(eqpmtNatureId != null){
			equipementTechnologies = equipementTechnologieDao.findByEquipementNature(equipementNature);
		}
		return equipementTechnologies;
	}
	
}
