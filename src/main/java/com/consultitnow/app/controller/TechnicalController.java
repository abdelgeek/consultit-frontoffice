package com.consultitnow.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.consultitnow.app.dao.ITechnicalRequirementDao;

@RestController
public class TechnicalController {

	@Autowired
	private ITechnicalRequirementDao technicalRequirementDao;
}
