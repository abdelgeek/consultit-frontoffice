package com.consultitnow.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.consultitnow.app.dao.IfrequencyDao;
import com.consultitnow.app.entity.FrequencyBand;


@CrossOrigin

@RestController
public class FrequencyController {

	@Autowired
	private IfrequencyDao frequencyDao;
	
	@RequestMapping(value="/findFrequencyBand", method= RequestMethod.GET)
	public List<FrequencyBand> findFrequencyBand(){
		return frequencyDao.findAll();
	}
	
	@RequestMapping(value="/findone", method= RequestMethod.GET)
	public FrequencyBand finfO(){
		return frequencyDao.findOne(5L);
	}
}
