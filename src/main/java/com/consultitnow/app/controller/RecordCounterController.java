package com.consultitnow.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import com.consultitnow.app.dao.IRecordCounterDao;
import com.consultitnow.app.entity.RecordCounter;


@RestController
@Configurable
public class RecordCounterController {

	
	@Autowired
	private IRecordCounterDao counterDao;
	
	public RecordCounter findRecordCounter(){
		System.out.println("test");
		return counterDao.findOne(1L);
	}
	
	
	public  RecordCounter saveRecordCounter(RecordCounter recordCounter){
		return counterDao.saveAndFlush(recordCounter);
	}
}
