package com.consultitnow.app.controller;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.consultitnow.app.dao.IApprovalTypeDao;
import com.consultitnow.app.dao.ICategoryDao;
import com.consultitnow.app.dao.IEquipementDao;
import com.consultitnow.app.dao.IEquipementNatureDao;
import com.consultitnow.app.dao.IEquipementTechnologieDao;
import com.consultitnow.app.dao.IEquipementTypeDao;
import com.consultitnow.app.dao.IfrequencyDao;
import com.consultitnow.app.dto.EquipementModel;
import com.consultitnow.app.entity.ApprovalType;
import com.consultitnow.app.entity.Category;
import com.consultitnow.app.entity.Equipement;
import com.consultitnow.app.entity.EquipementNature;
import com.consultitnow.app.entity.EquipementTechnologie;
import com.consultitnow.app.entity.EquipementType;
import com.consultitnow.app.entity.FrequencyBand;

@CrossOrigin
@RestController
public class EquipementController {

	@Autowired
	private IEquipementDao equipementDao;

	@Autowired
	private IApprovalTypeDao approvalTypeDao;

	@Autowired
	private ICategoryDao categoryDao;

	@Autowired
	private IEquipementNatureDao equipementNatureDao;

	@Autowired
	private IEquipementTechnologieDao equipementTechnologieDao;

	@Autowired
	private IEquipementTypeDao equipementTypeDao;
	
	@Autowired
	private IfrequencyDao frequencyDao;

	
	@RequestMapping(value="/saveEquipement", method=RequestMethod.POST)	
	public Equipement saveEquipement(EquipementModel equipementModel) {
		Equipement equipement = new Equipement();

		/*
		// get approvalType
		ApprovalType approvalType = new ApprovalType();
		approvalType = approvalTypeDao.findOne(equipementModel.getApprovalTypeId());

		// get Categories List
		List<Category> categories = new LinkedList<>();

		for (Long categoryId : equipementModel.getCategoryId()) {
			Category c = new Category();
			c = categoryDao.findOne(categoryId);
			categories.add(c);
		}

		// get Category nature
		EquipementNature equipementNature = new EquipementNature();
		equipementNature = equipementNatureDao.findOne(equipementModel.getEquipementNatureId());

		// get equipement technology List
		List<EquipementTechnologie> equipementTechnologies = new LinkedList<>();

		for (Long equipementTechnologieId : equipementModel.getEquipementTechnologieId()) {
			EquipementTechnologie et = new EquipementTechnologie();
			et = equipementTechnologieDao.findOne(equipementTechnologieId);
			equipementTechnologies.add(et);
		}
		
		// get Frequency band List
				List<FrequencyBand> frequencyBands = new LinkedList<>();

				for (Long frequencyBandId : equipementModel.getFrequencyId()) {
					FrequencyBand fb = new FrequencyBand();
					fb = frequencyDao.findOne(frequencyBandId);
					frequencyBands.add(fb);
				}

		// get Equipement type
		EquipementType equipementType = new EquipementType();
		equipementType = equipementTypeDao.findOne(equipementModel.getEquipementTypeId());
		
		*/

		/*
		 * equipement.setApprovalType(approvalType);
		equipement.setBrand(equipementModel.getBrand());
		equipement.setCategories(categories);
		equipement.setEquipementNature(equipementNature);
		equipement.setEquipementTechnologie(equipementTechnologies);
		equipement.setEquipementType(equipementType);
		equipement.setFrequencies(frequencyBands);
		equipement.setIsEncrypt(equipementModel.getIsEncrypt());*/
		equipement.setName(equipementModel.getName());

		
		
		System.out.println(equipementDao.save(equipement));
		return equipement;
	}
}
