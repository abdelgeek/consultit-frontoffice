package com.consultitnow.app.utils;

import org.springframework.stereotype.Component;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;


@Component
public class EmailService {

	@Autowired
	private JavaMailSender mailSender;

	public void send(EmailModel eParams) {

		try {
			this.sendHtmlMail(eParams);
		} catch (MessagingException e) {
			// logger.error("Could not send email to : {} Error = {}",
			// eParams.getToAsList(), e.getMessage());
		}

	}

	private void sendHtmlMail(EmailModel eParams) throws MessagingException {

		boolean isHtml = true;

		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setTo(eParams.getTo());
		helper.setReplyTo(eParams.getFrom());
		helper.setFrom(eParams.getFrom());
		helper.setSubject(eParams.getSubject());
		helper.setText(eParams.getMessage(), isHtml);

		//helper.addAttachment("Invoice.pdf", eParams.getFile());

		if (eParams.getCc().size() > 0) {
			helper.setCc(eParams.getCc().toArray(new String[eParams.getCc().size()]));
		}

		mailSender.send(message);
	}

}
