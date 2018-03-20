package com.consultitnow.app.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.consultitnow.app.controller.RecordCounterController;
import com.consultitnow.app.entity.RecordCounter;

@Configurable
@Service
public class GenerateNumber {

	@Autowired
	private RecordCounterController recordCounterController;

	private RecordCounter recordCounter = new RecordCounter();
	
	
	
	private DateFormat yearFormat = new SimpleDateFormat("yy");
	private DateFormat monthFormat = new SimpleDateFormat("MM");
	private DateFormat dayFormat = new SimpleDateFormat("dd");

	

	private String currentYear = yearFormat.format(new Date());
	private String currentMonth = monthFormat.format(new Date());
	private String currentDayOfMonth = dayFormat.format(new Date());


	
	
	// return the number generate
	public String getRecordCounter(String typeofGeneration) {

		 Random randomGenerator = new Random();
		 int randomInt = randomGenerator.nextInt(100);
		
		recordCounter = recordCounterController.findRecordCounter("quotation");
		String number = "";

		
		switch (typeofGeneration) {

		case "quot":

			recordCounter = this.setRecordCounter(recordCounter, currentDayOfMonth);
			number = "QUOTATION CIT-CI" + currentYear + currentMonth  + currentDayOfMonth  + randomInt + recordCounter.getQuotationCounter();

			break;

		case "inv":

			recordCounter = this.setRecordCounter(recordCounter, currentDayOfMonth);
			number = "INVOICE CIT-CI" + currentYear+ "." + currentMonth + "." + currentDayOfMonth + "." + randomInt + recordCounter.getQuotationCounter();

			break;

		default:
			break;
		}

		return number;
	}

	// initialise recounter number
	private RecordCounter setRecordCounter(RecordCounter recordCounter, String currentDay) {

		if (recordCounter == null || recordCounter.getCurrentDayOfMonth() == null) {

			RecordCounter rCounter = new RecordCounter(1, currentDayOfMonth, currentDay, currentDay, "quotation");
			recordCounter = rCounter;

		} else if (Integer.parseInt(recordCounter.getCurrentDayOfMonth()) != Integer.parseInt(currentDay)) {
			recordCounter.setCurrentDayOfMonth(currentDay);
			recordCounter.setQuotationCounter(1);
		} else {
			Integer cpt = recordCounter.getQuotationCounter() + 1;
			recordCounter.setQuotationCounter(cpt);
		}

		return recordCounterController.saveRecordCounter(recordCounter);
	}

}
