package com.consultitnow.app.controller;


import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.consultitnow.app.dao.IEquipementNatureDao;
import com.consultitnow.app.dao.IEquipementTechnologieDao;
import com.consultitnow.app.entity.EquipmentNature;
import com.consultitnow.app.entity.EquipmentTechnologie;

@CrossOrigin("*")
@RestController
public class EquipementTechnologieController {
	
	@Autowired
	private IEquipementTechnologieDao equipementTechnologieDao;
	
	@Autowired
	private IEquipementNatureDao equipementNatureDao;
	
	@GetMapping("/api/findByEquipementNature")
	public LinkedList<EquipmentTechnologie> findByEquipementNature(Long eqpmtNatureId){
		
		System.out.println("***** Get equipement by equipepemnt nature ***");
		EquipmentNature equipmentNature = new EquipmentNature();
		equipmentNature = equipementNatureDao.findOne(eqpmtNatureId);
		
		System.out.println(equipmentNature.toString());
		LinkedList<EquipmentTechnologie> equipmentTechnologies = new LinkedList<>();	
 		if(eqpmtNatureId != null){
			equipmentTechnologies = equipementTechnologieDao.findByEquipmentNature(equipmentNature);
		}
		return equipmentTechnologies;
	}
	
}
