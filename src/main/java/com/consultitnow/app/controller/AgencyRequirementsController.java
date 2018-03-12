package com.consultitnow.app.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.consultitnow.app.dao.AgencyRequirementsDao;
import com.consultitnow.app.dao.ICountryDao;
import com.consultitnow.app.entity.AgencyRequirements;
import com.consultitnow.app.entity.Country;
import com.consultitnow.model.ApprovalInformationReportModel;


import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;



@CrossOrigin
@RestController
public class AgencyRequirementsController {

	@Autowired
	private AgencyRequirementsDao agencyRequirementsDao;

	@Autowired
	private ICountryDao countryDao;

	/*
	@GetMapping(value = "/api/findRequirementsByAgency")
	public List<AgencyRequirements> findByAgencyCountryIdAndIsRequired(Long countryId) {
		return agencyRequirementsDao.findByAgencyCountryIdAndIsRequired(countryId, true);
	}
*/
	@PostMapping(value = "/api/findRequirementsByAgency")
	public ModelAndView findAgencyRequirementsTo(@RequestBody LinkedList<Long> lCountryId) throws JRException {
		
		List<ApprovalInformationReportModel> approvalInformationReportModels  = new LinkedList<>();
		
		
		for(Long item : lCountryId){
			
			Country c = new Country();
			c = countryDao.findOne(item);
			
			ApprovalInformationReportModel approvalInformationReportModel = new ApprovalInformationReportModel(c.getName());
			approvalInformationReportModels.add(approvalInformationReportModel);
		}
		
		
		
		JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(approvalInformationReportModels);
		Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("ItemDataSource1", itemsJRBean);
		 
         /* Using compiled version(.jasper) of Jasper report to generate PDF */
         JasperReport jasperReport = JasperCompileManager.compileReport("C:\\Users\\Cissé\\JaspersoftWorkspace\\MyReports\\approvalInformation.jrxml");
 		
         JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
		
		 JasperExportManager.exportReportToPdfFile(jasperPrint,"C:\\Users\\Cissé\\JaspersoftWorkspace\\MyReports\\simpleReport.pdf");

		return null;
	}

	
	@GetMapping(value = "/api/findAllRequirements")
	public List<AgencyRequirements> findAll() {
		return agencyRequirementsDao.findAll();
	}
}
