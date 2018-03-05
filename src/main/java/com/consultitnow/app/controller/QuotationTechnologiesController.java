package com.consultitnow.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.consultitnow.app.dao.IQuotationTechnologiesDao;
import com.consultitnow.app.entity.QuotationTechnologies;

@RestController
public class QuotationTechnologiesController {

	
	
	@Autowired
	private IQuotationTechnologiesDao iQuotationTechnologiesDao;
	
	public QuotationTechnologies save(QuotationTechnologies quotationTechnologies) {
		return iQuotationTechnologiesDao.save(quotationTechnologies);
	}

}
