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

import com.consultitnow.app.dao.IAgencyDao;
import com.consultitnow.app.dao.IApprovalTypeDao;
import com.consultitnow.app.dao.ICountryDao;
import com.consultitnow.app.dao.IEquipementNatureDao;
import com.consultitnow.app.dao.IEquipementTechnologieDao;
import com.consultitnow.app.dao.IEquipementTypeDao;
import com.consultitnow.app.dao.IQuotationAgencyDao;
import com.consultitnow.app.dao.IQuotationDao;
import com.consultitnow.app.dao.IQuotationFrequenciesDao;
import com.consultitnow.app.dao.IQuotationTechnologiesDao;
import com.consultitnow.app.dao.IfrequencyDao;
import com.consultitnow.app.entity.Agency;
import com.consultitnow.app.entity.ApprovalType;
import com.consultitnow.app.entity.Country;
import com.consultitnow.app.entity.EquipmentNature;
import com.consultitnow.app.entity.EquipmentTechnologie;
import com.consultitnow.app.entity.EquipmentType;
import com.consultitnow.app.entity.FrequencyBand;
import com.consultitnow.app.entity.Quotation;
import com.consultitnow.app.entity.QuotationAgency;
import com.consultitnow.app.entity.QuotationFrequencies;
import com.consultitnow.app.entity.QuotationTechnologies;
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
	private IQuotationTechnologiesDao quotationTechnologiesDao;

	@Autowired
	private GenerateNumber generateNumber;

	@Autowired
	private IQuotationFrequenciesDao quotationFrequenciesDao;

	@Autowired
	private ICountryDao countryDao;

	@Autowired
	private IAgencyDao agencyDao;

	@Autowired
	private IQuotationAgencyDao iQuotationAgencyDao;
	
	

	
	
	

	@PostMapping("/api/saveQuotation")
	public QuotationResultModel saveQuotation(@RequestBody QuotationModel quotationModel) {

		Quotation quotation = new Quotation();
		Result result = new Result();
		String quotationNum="";

		DateFormat df = new SimpleDateFormat("dd-mm-yyyy");

		/*
		 * quotation status -1 - quote request 0 - quote saved not placed 1 -
		 * quote saved and placed
		 */
		QuotationResultModel quotationResultModel = new QuotationResultModel();
		result.setIsValid(false);
		result.setMessage("");

		
		if (quotationModel != null) {
		if(quotationModel.getId() !=null){
			//find all quotation agency
			List<QuotationAgency> quotationAgencies = new LinkedList<>();
			quotationAgencies = iQuotationAgencyDao.findByQuotationId(quotationModel.getId());
			System.out.println(quotationAgencies.size());
			
			for(QuotationAgency quotationAgency: quotationAgencies){
				iQuotationAgencyDao.delete(quotationAgency);
			}
			
			
			//find all quotation technologie
			List<QuotationTechnologies> lquotationTechnologies = new LinkedList<>();
			lquotationTechnologies = quotationTechnologiesDao.findByQuotationId(quotationModel.getId());
			System.out.println(lquotationTechnologies.size());
			
			for(QuotationTechnologies quotationTechnologies: lquotationTechnologies){
				quotationTechnologiesDao.delete(quotationTechnologies);
			}
			
			
			//find all quotation frequency
			List<QuotationFrequencies> lquotationFrequencies = new LinkedList<>();
			lquotationFrequencies = quotationFrequenciesDao.findByQuotationId(quotationModel.getId());
			System.out.println(lquotationFrequencies.size());
			
			for(QuotationFrequencies quotationFrequencies: lquotationFrequencies){
				quotationFrequenciesDao.delete(quotationFrequencies);
			}
		}
		
		
	

			// get Quotation Date
			Date quotationDate = new Date();

			try {
				quotationDate = df.parse(quotationModel.getDate());
				quotation.setDate(quotationDate);

			} catch (ParseException e) { // TODO Auto-generated catch block
				e.printStackTrace();
			}

			// get quotation number
			if (quotationModel.getNumber() == null) {
				quotationNum = generateNumber.getRecordCounter("quot");
				quotation.setNumber(quotationNum);
			} else {
				quotationNum = quotationModel.getNumber();
				quotation.setNumber(quotationNum);
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

			// set equipement type
			if (quotationModel.getEquipementType() != null) {
				EquipmentType equipmentType = new EquipmentType();
				equipmentType = equipementTypeDao.findOne(quotationModel.getEquipementType());
				quotation.setEquipementType(equipmentType);

			}

			// set Encryption feature
			quotation.setHasEncryptionFeature(quotationModel.getHasEncryptionFeature());

			// setQuotationId

			if (quotationModel.getId() != null) {
				quotation.setId(quotationModel.getId());
			}

			quotationDao.saveAndFlush(quotation);

			// set equipement technologie et set to quotation

			for (Long equipementTechnologieId : quotationModel.getEquipementTechnologie()) {

				if (equipementTechnologieId != null) {
					EquipmentTechnologie equipmentTechnologie = new EquipmentTechnologie();
					equipmentTechnologie = equipementTechnologieDao.findOne(equipementTechnologieId);

					QuotationTechnologies quotationTechnologies = new QuotationTechnologies();
					quotationTechnologies.setEquipmentTechnologie(equipmentTechnologie);
					quotationTechnologies.setQuotation(quotation);
					quotationTechnologiesDao.save(quotationTechnologies);
				}

			}

			// set equipement frequency and set to quotation

			for (Long frequencyId : quotationModel.getFrequencyBand()) {
				if (frequencyId != null) {
					FrequencyBand frequencyBand = new FrequencyBand();
					frequencyBand = frequencyDao.findOne(frequencyId);

					QuotationFrequencies quotationFrequencies = new QuotationFrequencies();
					quotationFrequencies.setFrequencyBand(frequencyBand);
					quotationFrequencies.setQuotation(quotation);
					quotationFrequenciesDao.save(quotationFrequencies);

				}
			}

			// retrieve quotation Agency;

			// set equipement frequency and set to quotation

			for (Long countryId : quotationModel.getCountry()) {
				if (countryId != null) {
					Country country = new Country();
					country = countryDao.findOne(countryId);

					Agency agency = new Agency();

					ApprovalType approvalType = new ApprovalType();
					approvalType = approvalTypeDao.findOne(quotationModel.getApprovalType());

					agency = agencyDao.findByCountryAndApprovalTypeOrderByAgencyInitials(country, approvalType);

					QuotationAgency quotationAgency = new QuotationAgency();
					quotationAgency.setAgency(agency);
					quotationAgency.setQuotation(quotation);

					iQuotationAgencyDao.save(quotationAgency);

				}
			}

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

	@GetMapping("/api/findQuotationModelsByStatus")
	public List<QuotationModel> findQuotationModelsByStatus(String status) {

		List<Quotation> quotations = new LinkedList<>();
		List<QuotationModel> quotationModels = new LinkedList<>();

		quotations = quotationDao.findByStatusOrderByDate(Status.getValue(status));

		for (Quotation quotationItem : quotations) {
			QuotationModel quotationModel = this.getQuotationModel(quotationItem);
			quotationModels.add(quotationModel);
		}

		return quotationModels;
	}

	private QuotationModel getQuotationModel(Quotation quotation) {

		QuotationModel quotationModel = new QuotationModel();

		quotationModel.setApprovalType(quotation.getApprovalType().getId());
		quotationModel.setDataSheetUrl(quotation.getDataSheetUrl());
		quotationModel.setDate(String.valueOf(quotation.getDate()));
		quotationModel.setEquipementNature(quotation.getEquipementNature().getId());
		quotationModel.setEquipementType(quotation.getEquipementType().getId());
		quotationModel.setHasEncryptionFeature(quotation.getHasEncryptionFeature());
		quotationModel.setId(quotation.getId());
		quotationModel.setStatus(quotation.getStatus());
		quotationModel.setTotalAmount(quotation.getTotalAmount());
		quotationModel.setNumber(quotation.getNumber());

		if (!quotation.getQuotationFrequencies().isEmpty()) {

			List<Long> frequencyBandId = new LinkedList<>();
			for (QuotationFrequencies quotationFrequencies : quotation.getQuotationFrequencies()) {
				frequencyBandId.add(quotationFrequencies.getFrequencyBand().getId());
				quotationModel.setFrequencyBand(frequencyBandId);
			}

		}

		if (!quotation.getQuotationTechnologies().isEmpty()) {
			List<Long> equipementTechnologieId = new LinkedList<>();
			for (QuotationTechnologies quotationTechnologies : quotation.getQuotationTechnologies()) {

				equipementTechnologieId.add(quotationTechnologies.getEquipmentTechnologie().getId());
				quotationModel.setEquipementTechnologie(equipementTechnologieId);

			}
		}

		if (!quotation.getQuotationAgencies().isEmpty()) {
			List<Long> countryId = new LinkedList<>();
			for (QuotationAgency quotationAgency : quotation.getQuotationAgencies()) {

				countryId.add(quotationAgency.getAgency().getCountry().getId());
				quotationModel.setCountry(countryId);

			}
		}

		return quotationModel;
	}
}
