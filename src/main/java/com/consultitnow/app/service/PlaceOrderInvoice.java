package com.consultitnow.app.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.consultitnow.app.dao.ICategoryPriceDao;
import com.consultitnow.app.dao.IPurchaseOrderDao;
import com.consultitnow.app.entity.Agency;
import com.consultitnow.app.entity.ApprovalType;
import com.consultitnow.app.entity.CategoryPrice;
import com.consultitnow.app.entity.Country;
import com.consultitnow.app.entity.EquipmentType;
import com.consultitnow.app.entity.Project;
import com.consultitnow.app.entity.PurchaseOrder;
import com.consultitnow.app.entity.Quotation;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

public class PlaceOrderInvoice {

	@Autowired
	private static ICategoryPriceDao categoryPriceDao;

	public static void Generate(PurchaseOrder purchaseOrder) throws JRException, FileNotFoundException {

		List<Map<String, Object>> parameters = new LinkedList<>();
		List<Project> projects = new LinkedList<>();
		projects = purchaseOrder.getProjects();

		for (Project project : projects) {

			Map<String, Object> parameterItem = new HashMap();

			// get Agency
			Agency agency = new Agency();
			agency = project.getAgency();
			String countryName = agency.getCountry().getName();

			// get quotation
			Quotation quotation = new Quotation();
			quotation = purchaseOrder.getQuotation();

			// create an approval object to get approval type of the quotation
			ApprovalType approvalType = new ApprovalType();
			approvalType = quotation.getApprovalType();

			// create an equipmentType to get equipmentType of the quotation
			EquipmentType equipmentType = new EquipmentType();
			equipmentType = quotation.getEquipementType();

			// for each country concern by the quotation get the category price
			// of
			// the equipement type


			CategoryPrice categoryPrice = new CategoryPrice();


			parameterItem.put("country", countryName);
			parameterItem.put("price", categoryPrice.getPrice());
			parameters.add(parameterItem);
		}

		// path

	//	FileInputStream in = new FileInputStream("src/main/resources/static/report/invoice.jrxml");
		
		JasperExportManager.exportReportToPdfFile(String.valueOf(Paths.get("src/main/resources/static/report/invoice.jrxml")));
		/*JasperDesign design = JRXmlLoader.load(in);
		JasperReport jasperReport = JasperCompileManager.compileReport(design);

		Map<String, Object> params = new HashMap<>();
		JRDataSource dataSource = new JRBeanCollectionDataSource(parameters);

		params.put("datasource", dataSource);

		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,params,dataSource);

		
		File destFile = new File("src/main/resources/static/report/invoice.pdf");
		
		JasperExportManager.exportReportToPdfFile(jasperPrint, destFile.getAbsolutePath());*/

		
	}

}
