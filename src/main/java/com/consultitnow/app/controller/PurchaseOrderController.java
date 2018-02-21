package com.consultitnow.app.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.consultitnow.app.dao.ICountryDao;
import com.consultitnow.app.dao.IEquipementDao;
import com.consultitnow.app.dao.IInvoiceDao;
import com.consultitnow.app.dao.IProjectDao;
import com.consultitnow.app.dao.IPurchaseOrderDao;
import com.consultitnow.app.entity.Country;
import com.consultitnow.app.entity.Equipment;
import com.consultitnow.app.entity.Invoice;
import com.consultitnow.app.entity.Project;
import com.consultitnow.app.entity.PurchaseOrder;
import com.consultitnow.app.entity.Quotation;
import com.consultitnow.app.utils.EmailService;
import com.consultitnow.model.EquipmentModel;
import com.consultitnow.model.PurchaseOrderModel;
import com.consultitnow.model.QuotationModel;

@CrossOrigin
@RestController
public class PurchaseOrderController {

	@Autowired
	private IPurchaseOrderDao purchaseOrderDao;

	@Autowired
	private ICountryDao countryDao;

	@Autowired
	private IProjectDao projectDao;

	@Autowired
	private IEquipementDao equipementDao;

	@Autowired
	private IInvoiceDao invoiceDao;

	@Autowired
	private QuotationController quotationController;

	@Autowired
	private SendMailController sendMailController;

	@PostMapping("/api/purchaseOrder")
	public PurchaseOrder savePurchaseOrder(@RequestBody PurchaseOrderModel purchaseOrderModel) throws ParseException {

		Date placeOrderDate;
		DateFormat df = new SimpleDateFormat("dd-mm-yyyy");

		// save quotation

		QuotationModel quotationModel = new QuotationModel();
		quotationModel = purchaseOrderModel.getQuotationModel();
		placeOrderDate = df.parse(purchaseOrderModel.getPlaceOrderDate());

		Quotation quotation = new Quotation();

		quotation = quotationController.saveQuotation(quotationModel).getQuotation();

		// save order

		PurchaseOrder purchaseOrder = new PurchaseOrder();
		PurchaseOrder savedPurchaseOrder = new PurchaseOrder();

		purchaseOrder.setQuotation(quotation);
		purchaseOrder.setTotalAmount(quotation.getTotalAmount());
		purchaseOrder.setDate(placeOrderDate);

		savedPurchaseOrder = purchaseOrderDao.save(purchaseOrder);

		// save Equipment
		EquipmentModel equipmentModel = new EquipmentModel();
		equipmentModel = purchaseOrderModel.getEquipmentModel();

		Equipment equipment = new Equipment();
		equipment.setBrand(equipmentModel.getBrand());
		equipment.setModel(equipmentModel.getModel());
		equipment.setName(equipmentModel.getName());
		equipment = equipementDao.save(equipment);

		// save the invoice
		Invoice invoice = new Invoice();
		invoice.setDate(placeOrderDate);
		invoice.setPurchaseOrder(savedPurchaseOrder);
		invoice.setTotalAmount(quotation.getTotalAmount());
		invoiceDao.save(invoice);

		// save projects

		for (Long i : quotationModel.getCountry()) {
			System.out.println(i);

			// find Country
			Country country = new Country();
			country = countryDao.findOne(i);

			Project project = new Project();
			project.setCountry(country);
			project.setEquipment(equipment);
			project.setDate(placeOrderDate);
			project.setPurchaseOrder(savedPurchaseOrder);

			projectDao.save(project);
		}

		System.out.println(savedPurchaseOrder.toString());

		// send mail

		sendMailController.sendMail();
		return savedPurchaseOrder;
	}
}
