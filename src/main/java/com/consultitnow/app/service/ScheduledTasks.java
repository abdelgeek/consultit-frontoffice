package com.consultitnow.app.service;

import java.text.ParseException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.apache.tomcat.util.bcel.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.consultitnow.app.dao.IQuotationDao;
import com.consultitnow.app.entity.Quotation;
import com.consultitnow.app.entity.Status;
import com.consultitnow.app.utils.CalendarConfig;

@Service
public class ScheduledTasks {

	@Autowired
	private IQuotationDao iQuotationDao;
	private int cpt = 0;

	// scheduled task to delete expired quotation
	// fixedRate = 86400000
	@Scheduled(fixedRate = 300000)
	public void RemovedQuotation() throws ParseException {
		List<Quotation> quotations = new LinkedList<>();
		quotations = iQuotationDao.findByStatusOrderByDate(Status.Saved.getValue());

		for (Quotation quotation : quotations) {

			Date quotationDate = quotation.getDate();

			// get deadline for current quotation on dd-mm-yyyy format
			Date deadline = CalendarConfig.addNDaysToDate(quotationDate, 60);

			// compare 2 date  et retourne 0 si les 2 dates sont egales 
			if (CalendarConfig.compare2Date(new Date(), deadline) == 0) {
				iQuotationDao.delete(quotation);
			} 

		}

	}
}
