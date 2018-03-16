package com.consultitnow.app.controller;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.consultitnow.app.dao.IAgencyDao;
import com.consultitnow.app.dao.IApprovalTypeDao;
import com.consultitnow.app.dao.ICategoryPriceDao;
import com.consultitnow.app.dao.ICountryDao;
import com.consultitnow.app.dao.IEquipementTypeDao;
import com.consultitnow.app.entity.Agency;
import com.consultitnow.app.entity.ApprovalType;
import com.consultitnow.app.entity.CategoryPrice;
import com.consultitnow.app.entity.Country;
import com.consultitnow.app.entity.EquipmentType;
import com.consultitnow.model.QuotationModel;

@CrossOrigin
@RestController
public class CategoryPriceController {

	@Autowired
	private ICountryDao countryDao;
	@Autowired
	private IAgencyDao agencyDao;
	@Autowired
	private IApprovalTypeDao approvalTypeDao;
	@Autowired
	private ICategoryPriceDao categoryPriceDao;
	@Autowired
	private IEquipementTypeDao equipmentTypeDao;

	@PostMapping("/api/findCategoryPriceForQuotation")
	public List<CategoryPrice> findCategoryPriceForQuotation(@RequestBody QuotationModel quotationModel)
			throws FileNotFoundException {

		// create a list to return category price list
		List<CategoryPrice> categoryPrices = new LinkedList<CategoryPrice>();

		// create an approval object to get approval type of the quotation
		ApprovalType approvalType = new ApprovalType();
		approvalType = approvalTypeDao.findOne(quotationModel.getApprovalType());

		// create an equipmentType to get equipmentType of the quotation
		EquipmentType equipmentType = new EquipmentType();
		equipmentType = equipmentTypeDao.findOne(quotationModel.getEquipementType());

		// for each country concern by the quotation get the category price of
		// the equipement type

		for (Long countryId : quotationModel.getCountry()) {

			// get the current country
			Country country = new Country();
			country = countryDao.findOne(countryId);

			// get the country's agency which approval the approval type
			Agency agency = new Agency();
			agency = agencyDao.findByCountryAndApprovalTypeOrderByAgencyInitials(country, approvalType);

			// get the price criteria of the agency
			String methodPrice = agency.getMethodPrice();

			// create an object categoryPrice for the agency
			CategoryPrice categoryPrice = new CategoryPrice();
			// switch the criteria return the category price

			switch (methodPrice) {

			case "bur":
			case "bots":
			case "gha":
			case "gui":
			case "nig":
				categoryPrice = categoryPriceDao.findByAgencyAndPriceEquipementTypesEquipmentType(agency,
						equipmentType);
				break;

			case "nige":
				
				categoryPrice = categoryPriceDao.findByAgencyAndPriceEquipementTypesEquipmentType(agency,
						equipmentType);
				break;

			case "afr":
				categoryPrice = categoryPriceDao.findByAgencyAndPriceEquipementTypesEquipmentType(agency,
						equipmentType);
				break;

			case "tun":
				categoryPrice = categoryPriceDao.findByAgencyAndRegardsTheEncryptionFunction(agency,
						quotationModel.getHasEncryptionFeature());
				break;

			default:
				categoryPrice = agency.getCategoryPrices().get(0);
				break;
			}

			if (categoryPrice != null) {
				categoryPrices.add(categoryPrice);
			}

		}
		System.out.println(categoryPrices.size());
		return categoryPrices;
	}

	// find category price based on equipment type and agency
	public CategoryPrice findCategoryPriceByEquipmentType(Agency agency, EquipmentType equipmentType) {
		return categoryPriceDao.findByAgencyAndPriceEquipementTypesEquipmentType(agency, equipmentType);
	}

	// find category price based on encryption and agency
	public CategoryPrice findByAgencyAndRegardsTheEncryptionFunction(Agency agency,
			Boolean regardsTheEncryptionFunction) {
		return categoryPriceDao.findByAgencyAndRegardsTheEncryptionFunction(agency, regardsTheEncryptionFunction);
	}

	// find category price based on number of modules and agency
	public CategoryPrice findByAgencyAndNumberModules(Agency agency, Integer numberOfModules) {
		return categoryPriceDao.findByAgencyAndNumberModules(agency, numberOfModules);
	}
}
