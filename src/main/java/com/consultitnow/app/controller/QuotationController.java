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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.consultitnow.app.dao.IApprovalTypeDao;
import com.consultitnow.app.dao.IEquipementNatureDao;
import com.consultitnow.app.dao.IEquipementTechnologieDao;
import com.consultitnow.app.dao.IEquipementTypeDao;
import com.consultitnow.app.dao.IQuotationDao;
import com.consultitnow.app.dao.IfrequencyDao;
import com.consultitnow.app.entity.ApprovalType;
import com.consultitnow.app.entity.EquipmentNature;
import com.consultitnow.app.entity.EquipmentTechnologie;
import com.consultitnow.app.entity.EquipmentType;
import com.consultitnow.app.entity.FrequencyBand;
import com.consultitnow.app.entity.Quotation;
import com.consultitnow.app.entity.Status;
import com.consultitnow.app.utils.GenerateNumber;
import com.consultitnow.app.utils.MailBody;
import com.consultitnow.app.utils.SendMailController;
import com.consultitnow.model.QuotationModel;
import com.consultitnow.model.QuotationResultModel;
import com.consultitnow.model.Result;

@RestController
@CrossOrigin
@Configurable
public class QuotationController {

	@Autowired
	private IQuotationDao quotationDao;

	@Autowired
	private IApprovalTypeDao approvalTypeDao;

	@Autowired
	private SendMailController sendMailController;

	@Autowired
	private IEquipementNatureDao equipementNatureDao;

	@Autowired
	private IEquipementTechnologieDao equipementTechnologieDao;

	@Autowired
	private IEquipementTypeDao equipementTypeDao;

	@Autowired
	private IfrequencyDao frequencyDao;

	@Autowired
	private GenerateNumber generateNumber;

	@PostMapping("/api/saveQuotation")
	public QuotationResultModel saveQuotation(@RequestBody QuotationModel quotationModel) {

		Quotation quotation = new Quotation();
		Result result = new Result();
		String quotationNum;

		DateFormat df = new SimpleDateFormat("dd-mm-yyyy");

		/*
		 * quotation status -1 - quote request 0 - quote saved not placed 1 -
		 * quote saved and placed
		 */
		QuotationResultModel quotationResultModel = new QuotationResultModel();
		result.setIsValid(false);
		result.setMessage("");

		if (quotationModel != null) {

			// get Quotation Date
			Date quotationDate = new Date();

			quotationNum = generateNumber.getRecordCounter("quot");
			quotation.setNumber(quotationNum);

			try {
				quotationDate = df.parse(quotationModel.getDate());
				quotation.setDate(quotationDate);

			} catch (ParseException e) { // TODO Auto-generated catch block
				e.printStackTrace();
			}

			// set Datasheet url
			quotation.setDataSheetUrl(quotationModel.getDataSheetUrl());

			// set quotation amount
			quotation.setTotalAmount(quotationModel.getTotalAmount());

			// set quotation status
			quotation.setStatus(quotationModel.getStatus());

			// set approval type
			if (quotationModel.getApprovalType() != null) {
				ApprovalType approvalType = new ApprovalType();

				approvalType = approvalTypeDao.findOne(quotationModel.getApprovalType());

				quotation.setApprovalType(approvalType);
			}

			// set equipement nature
			if (quotationModel.getEquipementNature() != null) {
				EquipmentNature equipmentNature = new EquipmentNature();
				equipmentNature = equipementNatureDao.findOne(quotationModel.getEquipementNature());

				quotation.setEquipementNature(equipmentNature);
			}

			// set equipement technologie et set to quotation
			List<EquipmentTechnologie> equipmentTechnologies = new LinkedList<>();
			for (Long equipementTechnologieId : quotationModel.getEquipementTechnologie()) {

				if (equipementTechnologieId != null) {
					EquipmentTechnologie equipmentTechnologie = new EquipmentTechnologie();
					equipmentTechnologie = equipementTechnologieDao.findOne(equipementTechnologieId);
					equipmentTechnologies.add(equipmentTechnologie);
				}

			}
			quotation.setEquipementTechnologie(equipmentTechnologies);

			// set equipement type
			if (quotationModel.getEquipementType() != null) {
				EquipmentType equipmentType = new EquipmentType();
				equipmentType = equipementTypeDao.findOne(quotationModel.getEquipementType());
				quotation.setEquipementType(equipmentType);

			}

			// set equipement frequency and set to quotation
			List<FrequencyBand> frequencyBands = new LinkedList<>();
			for (Long frequencyId : quotationModel.getFrequencyBand()) {
				if (frequencyId != null) {
					FrequencyBand frequencyBand = new FrequencyBand();
					frequencyBand = frequencyDao.findOne(frequencyId);
					frequencyBands.add(frequencyBand);
				}
			}
			quotation.setFrequencies(frequencyBands);

			// set Encryption feature
			quotation.setHasEncryptionFeature(quotationModel.getHasEncryptionFeature());

			quotationDao.save(quotation);

			result.setIsValid(true);
			result.setMessage("Quotation sved successfully");

			quotationResultModel.setQuotation(quotation);
			quotationResultModel.setResult(result);

			if (quotationModel.getStatus().equals(0)) {
				MailBody mailBody = new MailBody();

				mailBody.setQuotationDate(quotationDate);
				mailBody.setQuotationNumber(quotationNum);
				mailBody.setTypeTemplateEmail("savedQuotation");
				mailBody.setUrl("url");

				sendMailController.sendMail(mailBody);
			}

		}

		return quotationResultModel;
	}

	@GetMapping("/api/findQuotationsByStatus")
	public List<Quotation> findQuotationsByStatus(String status) {
		System.out.println(Status.getValue(status));
		return quotationDao.findByStatusOrderByDate(Status.getValue(status));
	}
}
