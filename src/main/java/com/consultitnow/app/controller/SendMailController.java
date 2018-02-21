package com.consultitnow.app.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consultitnow.app.utils.EmailModel;
import com.consultitnow.app.utils.EmailService;
import com.consultitnow.app.utils.EmailTemplate;

@CrossOrigin
@RestController
public class SendMailController {

	@Autowired
	private EmailService emailService;

	@GetMapping("/sendMail")
	public void sendMail() {

		String from = "toumoutou6c@gmail.com";

		String to = "abdeltoum6c@gmail.com";
		String subject = "Order Invoice";

		EmailTemplate template = new EmailTemplate("order.html");

		Map<String, String> replacements = new HashMap<String, String>();
		replacements.put("user", "Abdel");
		replacements.put("today", String.valueOf(new Date()));

		String message = template.getTemplate(replacements);

		Path invoice = Paths.get("src/main/resources/static/upload-dir/20187131013229.pdf");
		File invoiceFile = new File(invoice.toString());

		
		if(invoiceFile.exists()){
			System.out.println("eux");
		}
		FileSystemResource file = new FileSystemResource(invoiceFile);

		EmailModel email = new EmailModel(from, to, subject, message, file);
		email.setHtml(true);
		emailService.send(email);

		System.out.println("send");
	}

}
