package com.consultitnow.app.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.consultitnow.app.dao.IApprovalTypeDao;
import com.consultitnow.app.dao.IEquipementNatureDao;
import com.consultitnow.app.entity.ApprovalType;
import com.consultitnow.app.entity.EquipmentNature;

@CrossOrigin
@RestController
public class EquipementNatureController {

	@Autowired
	private IEquipementNatureDao equipementNatureDao;
	@Autowired
	private IApprovalTypeDao approvalTypeDao;

	@GetMapping("/api/findEqmNatureByApprovalType")
	public List<EquipmentNature> findByApprovalType(Long approvalId) {

		System.out.println("***** Get equipement nature by approval type name ***");

		System.out.println(approvalId);
		ApprovalType approvalType = new ApprovalType();
		List<EquipmentNature> equipmentNatures = new LinkedList<EquipmentNature>();

		if (approvalId != null) {

			approvalType = approvalTypeDao.findOne(approvalId);

			equipmentNatures = equipementNatureDao.findByApprovalType(approvalType);

			System.out.println("equipmentNatures.toString()");
			System.out.println(equipmentNatures.toString());
		} else {
			System.out.println("***** approval Type id non null ***");
		}

		return equipmentNatures;
	}

	@GetMapping("/api/findEquipementNature")
	public EquipmentNature findOne(Long id) {
		return equipementNatureDao.findOne(id);
	}

}
