package com.consultitnow.app.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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

	// return the number generate
	public String getRecordCounter(String typeofGeneration) {

		recordCounter = recordCounterController.findRecordCounter();
		String number = "";

		switch (typeofGeneration) {

		case "quot":

			DateFormat yearFormat = new SimpleDateFormat("yy");
			DateFormat monthFormat = new SimpleDateFormat("MM");
			DateFormat dayFormat = new SimpleDateFormat("dd");

			String currentYear = yearFormat.format(new Date());
			String currentMonth = monthFormat.format(new Date());
			String currentDay = dayFormat.format(new Date());

			recordCounter = this.setRecordCounter(recordCounter, currentMonth);
			number = "QUOT" + currentYear + currentMonth + currentDay + "" + recordCounter.getQuotationCounter();

			break;

		default:
			break;
		}

		return number;
	}

	// initialise recounter number
	private RecordCounter setRecordCounter(RecordCounter recordCounter, String currentMonth) {

		if (recordCounter == null) {

			RecordCounter rCounter = new RecordCounter(1, currentMonth);
			recordCounter = rCounter;

		} else if (Integer.parseInt(recordCounter.getCurrentMonth()) != Integer.parseInt(currentMonth)) {
			recordCounter.setCurrentMonth(currentMonth);
			recordCounter.setQuotationCounter(1);
		} else {
			Integer cpt = recordCounter.getQuotationCounter() + 1;
			recordCounter.setQuotationCounter(cpt);
		}
		

		return recordCounterController.saveRecordCounter(recordCounter);
	}

}
