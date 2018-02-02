package com.consultitnow.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.consultitnow.app.dao.IEquipementDao;
import com.consultitnow.app.entity.Equipment;

@RestController
@CrossOrigin
public class EquipmentController {

	@Autowired
	private IEquipementDao equipementDao;

	public Equipment saveEquipment(Equipment equipment) {
		return equipementDao.save(equipment);
	}
}
