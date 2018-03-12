package com.consultitnow.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.consultitnow.app.dao.IQuotationAgencyDao;
import com.consultitnow.app.entity.Agency;



@RestController
public class QuotationAgencyController {

	
	@Autowired
	private IQuotationAgencyDao quotationAgencyDao;
	
	
	
}
