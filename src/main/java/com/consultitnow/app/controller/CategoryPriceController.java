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
import com.consultitnow.app.entity.PriceCriteria;
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
			agency = agencyDao.findByCountryAndApprovalType(country, approvalType);

			// get the price criteria of the agency
			PriceCriteria priceCriteria = agency.getPriceCriteria();

			System.out.println("country " + country.getName());
			System.out.println("agency " + agency.getAgencyInitials());
			System.out.println("price criteria " + priceCriteria.getName());

			// create an object categoryPrice for the agency
			CategoryPrice categoryPrice = new CategoryPrice();
			// switch the criteria return the category price
			switch (priceCriteria.getId().intValue()) {

			// case 0: no criteria
			case 0:
				if (agency.getCategoryPrices().size() > 1) {
					System.out.println("pas normal");
				} else {
					System.out.println("price " + agency.getCategoryPrices().get(0).getPrice());
					categoryPrice = agency.getCategoryPrices().get(0);
				}
				break;

			// case 1: equipement type criteria
			case 1:
				System.out.println("get the equipement type");
				categoryPrice = this.findCategoryPriceByEquipmentType(agency, equipmentType);

				if (categoryPrice != null) {
					System.out.println(categoryPrice.toString());
				} else {
					System.out.println("category not found");
				}

				break;

			// case 2: encryption type feature
			case 2:
				System.out.println("has encryption feature : " + quotationModel.getHasEncryptionFeature());

				categoryPrice = this.findByAgencyAndRegardsTheEncryptionFunction(agency,
						quotationModel.getHasEncryptionFeature());

				System.out.println(categoryPrice.toString());
				break;

			// case 3 : number of module
			case 3:
				System.out.println(quotationModel.getEquipementTechnologie().size());

				categoryPrice = this.findByAgencyAndNumberModules(agency,
						quotationModel.getEquipementTechnologie().size());
				if (categoryPrice != null) {
					System.out.println(categoryPrice.toString());
				} else {
					System.out.println("category not found");
				}
				break;
			}

			if (categoryPrice != null) {
				categoryPrices.add(categoryPrice);
			}

			System.out.println("********************************************************");
		}
		List<CategoryPrice> categoryPricees = new LinkedList<CategoryPrice>();
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
