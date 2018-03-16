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
		String subject = "";

		String typetemplateEmail = mailBody.getTypeTemplateEmail();
		EmailTemplate template = new EmailTemplate(typetemplateEmail);

		Map<String, String> replacements = new HashMap<String, String>();

		switch (typetemplateEmail) {
		case "savedQuotation":
			SavedQuotationMailBody smMailBody = new SavedQuotationMailBody();
			smMailBody = (SavedQuotationMailBody) mailBody;
			replacements.put("QuotationId", smMailBody.getNumber());

			DateFormat df = new SimpleDateFormat("mm-dd-yyyy");
			replacements.put("date", String.valueOf(CalendarConfig.addNDaysToDate(smMailBody.getDate(), 30)));
			subject = "ConsultIt Saved Quotation " + smMailBody.getNumber();

			break;

		case "invoice":
			InvoiceMailBody iMBody = new InvoiceMailBody();
			iMBody = (InvoiceMailBody) mailBody;
			replacements.put("amount", iMBody.getAmount());

			DateFormat df2 = new SimpleDateFormat("MM-dd-yyyy");
			replacements.put("date", String.valueOf(iMBody.getDate()));
			subject = "ConsultIt Invoice " + iMBody.getNumber();

			break;
		default:
			break;
		}

		String message = template.getTemplate(replacements);

		EmailModel email = new EmailModel(from, to, subject, message);
		email.setHtml(true);
		emailService.send(email);

	}

}
