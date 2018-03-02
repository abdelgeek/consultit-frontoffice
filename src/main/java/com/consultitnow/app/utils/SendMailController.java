package com.consultitnow.app.utils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class SendMailController {

	@Autowired
	private EmailService emailService;

	@GetMapping("/api/send")
	public void sendMail(MailBody mailBody) {

		String from = "toumoutou6c@gmail.com";
		String to = "abdeltoum6c@gmail.com";
		String subject="";

		String typetemplateEmail = mailBody.getTypeTemplateEmail();
		EmailTemplate template = new EmailTemplate(typetemplateEmail);

		Map<String, String> replacements = new HashMap<String, String>();

		switch (typetemplateEmail) {
		case "savedQuotation":
			replacements.put("QuotationId", mailBody.getQuotationNumber());
			
					
			
			DateFormat df = new SimpleDateFormat("mm-dd-yyyy");
			replacements.put("date", String.valueOf(CalendarConfig.addNDaysToDate(mailBody.getQuotationDate(), 30)));
			replacements.put("url", mailBody.getUrl());
			subject = "ConsultIt Saved Quotation";
			
			break;
		default:
			break;
		}

		String message = template.getTemplate(replacements);

		// Path invoice =
		// Paths.get("src/main/resources/static/upload-dir/20187131013229.pdf");
		// File invoiceFile = new File(invoice.toString());
		// FileSystemResource file = new FileSystemResource(invoiceFile);

		EmailModel email = new EmailModel(from, to, subject, message);
		email.setHtml(true);
		emailService.send(email);

	}

}
