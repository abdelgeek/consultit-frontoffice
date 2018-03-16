package com.consultitnow.app.controller;

import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.consultitnow.app.dao.IAgencyDao;
import com.consultitnow.app.dao.IApprovalTypeDao;
import com.consultitnow.app.dao.ICountryDao;
import com.consultitnow.app.dao.IEquipementDao;
import com.consultitnow.app.dao.IInvoiceDao;
import com.consultitnow.app.dao.IProjectDao;
import com.consultitnow.app.dao.IPurchaseOrderDao;
import com.consultitnow.app.entity.Agency;
import com.consultitnow.app.entity.ApprovalType;
import com.consultitnow.app.entity.Country;
import com.consultitnow.app.entity.Equipment;
import com.consultitnow.app.entity.Invoice;
import com.consultitnow.app.entity.Project;
import com.consultitnow.app.entity.PurchaseOrder;
import com.consultitnow.app.entity.Quotation;
import com.consultitnow.app.service.PlaceOrderInvoice;
import com.consultitnow.app.utils.EmailService;
import com.consultitnow.app.utils.GenerateNumber;
import com.consultitnow.app.utils.InvoiceMailBody;
import com.consultitnow.app.utils.MailBody;
import com.consultitnow.app.utils.SendMailController;
import com.consultitnow.model.EquipmentModel;
import com.consultitnow.model.PurchaseOrderModel;
import com.consultitnow.model.QuotationModel;
import com.consultitnow.model.Result;

import net.sf.jasperreports.engine.JRException;

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
	private GenerateNumber generateNumber;

	@Autowired
	private QuotationController quotationController;

	@Autowired
	private SendMailController sendMailController;

	@Autowired
	private IApprovalTypeDao approvalTypeDao;
	@Autowired
	private IAgencyDao agencyDao;

	@PostMapping("/api/purchaseOrder")
	public Result savePurchaseOrder(@RequestBody PurchaseOrderModel purchaseOrderModel)
			throws ParseException, JRException, FileNotFoundException {

		Result result = new Result();

		Date placeOrderDate;
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");

		// save quotation

		QuotationModel quotationModel = new QuotationModel();
		quotationModel = purchaseOrderModel.getQuotationModel();
		placeOrderDate = df.parse(purchaseOrderModel.getPlaceOrderDate());

		Quotation quotation = new Quotation();

		quotation = quotationController.saveQuotation(quotationModel).getQuotation();

		// save order

		PurchaseOrder purchaseOrder = new PurchaseOrder();
		PurchaseOrder savedPurchaseOrder = new PurchaseOrder();

		// get quotation number
		String purchaseNum = generateNumber.getRecordCounter("inv");
		purchaseOrder.setNumber(purchaseNum);

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

		List<Project> projects = new LinkedList<>();
		for (Long countryId : quotationModel.getCountry()) {
			System.out.println(countryId);

			// find agency

			Country country = new Country();
			country = countryDao.findOne(countryId);

			Agency agency = new Agency();

			ApprovalType approvalType = new ApprovalType();
			approvalType = approvalTypeDao.findOne(quotationModel.getApprovalType());

			agency = agencyDao.findByCountryAndApprovalTypeOrderByAgencyInitials(country, approvalType);

			Project project = new Project();
			project.setAgency(agency);
			project.setEquipment(equipment);
			project.setDate(placeOrderDate);
			project.setPurchaseOrder(savedPurchaseOrder);

			projectDao.save(project);

			projects.add(project);
		}

		savedPurchaseOrder.setProjects(projects);
		System.out.println(savedPurchaseOrder.toString());
		result.setIsValid(true);
		// PlaceOrderInvoice.Generate(savedPurchaseOrder);
		// send mail


			MailBody mailBody = new InvoiceMailBody(String.valueOf(invoice.getTotalAmount()), placeOrderDate,purchaseOrder.getNumber());
			mailBody.setTypeTemplateEmail("invoice");
			
			sendMailController.sendMail(mailBody);
		
			
		// sendMailSavedQuotationController.sendMail("order.html");
		return result;
	}
}
