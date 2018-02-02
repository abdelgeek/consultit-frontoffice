package com.consultitnow.app.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
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
import com.consultitnow.app.entity.EquipmentNature;
import com.consultitnow.app.entity.EquipmentTechnologie;
import com.consultitnow.app.entity.EquipmentType;
import com.consultitnow.app.entity.FrequencyBand;
import com.consultitnow.app.entity.Quotation;
import com.consultitnow.model.QuotationModel;

@RestController
@CrossOrigin
@Configurable
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

		Quotation quotation = new Quotation();

		// get Quotation Date
		Date quotationDate = new Date();
		DateFormat df = new SimpleDateFormat("dd-mm-yyyy");

		try {
			quotationDate = df.parse(quotationModel.getDate());
			quotation.setDate(quotationDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// get quotation status
		quotation.setStatus(quotationModel.getStatus());

		// get approval type

		if (quotationModel.getApprovalType() != null) {
			ApprovalType approvalType = new ApprovalType();

			System.out.println("approval " + quotationModel.getApprovalType());
			approvalType = approvalTypeDao.findOne(quotationModel.getApprovalType());

			quotation.setApprovalType(approvalType);
		}

		approvalTypeDao.findAll();

		// get categories and set to quotation
		List<Category> categories = new LinkedList<>();
		for (Long categoryId : quotationModel.getCategory()) {

			if (categoryId != null) {
				Category category = new Category();
				category = categorieDao.findOne(categoryId);
				categories.add(category);
			}
		}
		quotation.setCategories(categories);

		// get equipement nature
		if (quotationModel.getEquipementNature() != null) {
			EquipmentNature equipmentNature = new EquipmentNature();
			equipmentNature = equipementNatureDao.findOne(quotationModel.getEquipementNature());

			quotation.setEquipementNature(equipmentNature);
		}

		// get equipement technologie et set to quotation
		List<EquipmentTechnologie> equipmentTechnologies = new LinkedList<>();
		for (Long equipementTechnologieId : quotationModel.getEquipementTechnologie()) {

			if (equipementTechnologieId != null) {
				EquipmentTechnologie equipmentTechnologie = new EquipmentTechnologie();
				equipmentTechnologie = equipementTechnologieDao.findOne(equipementTechnologieId);
				equipmentTechnologies.add(equipmentTechnologie);
			}

		}
		quotation.setEquipementTechnologie(equipmentTechnologies);

		// get equipement type
		if (quotationModel.getEquipementType() != null) {
			EquipmentType equipmentType = new EquipmentType();
			equipmentType = equipementTypeDao.findOne(quotationModel.getEquipementType());
			quotation.setEquipementType(equipmentType);

		}

		// get equipement frequency and set to quotation
		List<FrequencyBand> frequencyBands = new LinkedList<>();
		for (Long frequencyId : quotationModel.getFrequencyBand()) {
			if (frequencyId != null) {
				FrequencyBand frequencyBand = new FrequencyBand();
				frequencyBand = frequencyDao.findOne(frequencyId);
				frequencyBands.add(frequencyBand);
			}
		}
		quotation.setFrequencies(frequencyBands);

		// get Encryption feature
		quotation.setHasEncryptionFeature(quotationModel.getHasEncryptionFeature());

		// set datasheet url
		quotation.setDataSheetUrl(quotationModel.getDataSheetUrl());

		return quotationDao.save(quotation);
	}
}
