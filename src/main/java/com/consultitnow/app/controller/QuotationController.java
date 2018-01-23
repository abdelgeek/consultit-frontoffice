package com.consultitnow.app.controller;

import java.util.LinkedList;
import java.util.List;

import org.junit.experimental.categories.Categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.consultitnow.app.dao.IApprovalTypeDao;
import com.consultitnow.app.dao.ICategoryDao;
import com.consultitnow.app.dao.IEquipementNatureDao;
import com.consultitnow.app.dao.IEquipementTechnologieDao;
import com.consultitnow.app.dao.IEquipementTypeDao;
import com.consultitnow.app.dao.IQuotationDao;
import com.consultitnow.app.dao.IfrequencyDao;
import com.consultitnow.app.entity.ApprovalType;
import com.consultitnow.app.entity.Category;
import com.consultitnow.app.entity.EquipementNature;
import com.consultitnow.app.entity.EquipementTechnologie;
import com.consultitnow.app.entity.EquipementType;
import com.consultitnow.app.entity.FrequencyBand;
import com.consultitnow.app.entity.Quotation;
import com.consultitnow.model.QuotationModel;

@RestController
@CrossOrigin
public class QuotationController {

	@Autowired
	private IQuotationDao quotationDao;

	@Autowired
	private IApprovalTypeDao approvalTypeDao;

	@Autowired
	private ICategoryDao categorieDao;

	@Autowired
	private IEquipementNatureDao equipementNatureDao;

	@Autowired
	private IEquipementTechnologieDao equipementTechnologieDao;

	@Autowired
	private IEquipementTypeDao equipementTypeDao;
	
	@Autowired
	private IfrequencyDao frequencyDao;


	
	@PostMapping("/saveQuotation")
	public Quotation saveQuotation(@RequestBody QuotationModel quotationModel) {

		// get approval type
		ApprovalType approvalType = new ApprovalType();
		approvalType = approvalTypeDao.findOne(quotationModel.getApprovalType());

		// get categories
		List<Category> categories = new LinkedList<>();
		for (Long categoryId : quotationModel.getCategory()) {
			Category category = new Category();
			category = categorieDao.findOne(categoryId);
			categories.add(category);
		}

		// get equipement nature
		EquipementNature equipementNature = new EquipementNature();
		equipementNature = equipementNatureDao.findOne(quotationModel.getEquipementNature());

		// get equipement technologie
		List<EquipementTechnologie> equipementTechnologies = new LinkedList<>();
		for (Long equipementTechnologieId : quotationModel.getEquipementTechnologie()) {
			EquipementTechnologie equipementTechnologie = new EquipementTechnologie();
			equipementTechnologie = equipementTechnologieDao.findOne(equipementTechnologieId);
			equipementTechnologies.add(equipementTechnologie);
		}

		// get equipement nature
		EquipementType equipementType = new EquipementType();
		equipementType = equipementTypeDao.findOne(quotationModel.getEquipementType());

		// get equipement frequency
				List<FrequencyBand> frequencyBands = new LinkedList<>();
				for (Long frequencyId : quotationModel.getFrequencyBand()) {
					FrequencyBand frequencyBand = new FrequencyBand();
					frequencyBand = frequencyDao.findOne(frequencyId);
					frequencyBands.add(frequencyBand);
				}
				
		Quotation quotation = new Quotation();
		quotation.setApprovalType(approvalType);
		quotation.setCategories(categories);
		quotation.setDate(quotationModel.getDate());
		quotation.setEquipementNature(equipementNature);
		quotation.setEquipementTechnologie(equipementTechnologies);
		quotation.setEquipementType(equipementType);
		quotation.setStatus(quotationModel.getStatus());
		quotation.setFrequencies(frequencyBands);
		
		 return quotationDao.save(quotation);
	}
}
