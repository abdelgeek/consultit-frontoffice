package com.consultitnow.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.consultitnow.app.dao.IEquipementTypeDao;
import com.consultitnow.app.entity.EquipmentType;

@RestController
@CrossOrigin
public class EquipementTypeController {

	@Autowired
	private IEquipementTypeDao equipementTypeDao;
	
	
	@RequestMapping(value="/findEquipementTypes", method=RequestMethod.GET)
	public List<EquipmentType> findAll(){
		return equipementTypeDao.findAll();
	}
}
