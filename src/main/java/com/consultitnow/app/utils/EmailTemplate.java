package com.consultitnow.app.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class EmailTemplate {
	private String templateId;

	private String template;

	private Map<String, String> replacementParams;

	private final Path emailLocation = Paths.get("src/main/resources/static/emailTemplate");

	public EmailTemplate(String typetemplateEmail) {

		switch (typetemplateEmail) {
		case "savedQuotation":
			this.templateId = "savedQuoteMail.html";
			break;

		default:
			break;
		}

		try {
			this.template = loadTemplate(templateId);
		} catch (Exception e) {

			System.out.println("Could not read template with ID = " + templateId);
			this.template = Constants.BLANK;
		}
	}

	private String loadTemplate(String templateId) throws Exception {

		Path filePath = Paths.get(emailLocation.toString() + "/" + templateId);

		String content = Constants.BLANK;

		if (Files.exists(filePath)) {
			System.out.println("dirLocation");

			try {
				content = new String(Files.readAllBytes(filePath));
			} catch (IOException e) {
				throw new Exception("Could not read template with ID = " + templateId);
			}
		}
		return content;
	}

	public String getTemplate(Map<String, String> replacements) {
		String cTemplate = this.getTemplate();

		if (!AppUtil.isObjectEmpty(cTemplate)) {
			for (Map.Entry<String, String> entry : replacements.entrySet()) {
				cTemplate = cTemplate.replace("{{" + entry.getKey() + "}}", entry.getValue());
			}
		}

		return cTemplate;
	}

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public Map<String, String> getReplacementParams() {
		return replacementParams;
	}

	public void setReplacementParams(Map<String, String> replacementParams) {
		this.replacementParams = replacementParams;
	}

}
