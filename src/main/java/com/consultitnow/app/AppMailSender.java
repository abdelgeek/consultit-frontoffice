package com.consultitnow.app;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.consultitnow.app.utils.EmailModel;
import com.consultitnow.app.utils.EmailService;
import com.consultitnow.app.utils.EmailTemplate;

/**
 * @author pavan.solapure
 *
 */
@Component
public class AppMailSender {

	@Autowired
	EmailService emailService;

	/*
	 * @Override public void run(ApplicationArguments args) throws Exception {
	 * System.out.println("begin"); sendHtmltMail(); sendTextMail();
	 * 
	 * }
	 */

	private void sendTextMail() {

		String from = "toumoutou6c@gmail.com";
		String to = "abdeltoum6c@gmail.com";
		String subject = "Java Mail with Spring Boot - Plain Text";

		EmailTemplate template = new EmailTemplate("hello-world-plain.txt");

		Map<String, String> replacements = new HashMap<String, String>();
		replacements.put("user", "Abdem");
		replacements.put("today", String.valueOf(new Date()));

		String message = template.getTemplate(replacements);

		// EmailModel email = new EmailModel(from, to, subject, message);

		// emailService.send(email);
	}

	private void sendHtmltMail() {

		String from = "toumoutou6c@gmail.com";
		String to = "abdeltoum6c@gmail.com";
		String subject = "Java Mail with Spring Boot";

		EmailTemplate template = new EmailTemplate("hello-world.html");

		Map<String, String> replacements = new HashMap<String, String>();
		replacements.put("user", "Pavan");
		replacements.put("today", String.valueOf(new Date()));

		String message = template.getTemplate(replacements);

		/*EmailModel email = new EmailModel(from, to, subject, message);
		email.setHtml(true);
		emailService.send(email);*/

		System.out.println("send");
	}

}