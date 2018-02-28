package com.consultitnow.app.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.FileSystemResource;

public class EmailModel {

	private String from;

	private FileSystemResource file;

	private String to;

	private List<String> cc;

	private String subject;

	private String message;

	private boolean isHtml;

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public List<String> getCc() {
		return cc;
	}

	public void setCc(List<String> cc) {
		this.cc = cc;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isHtml() {
		return isHtml;
	}

	public void setHtml(boolean isHtml) {
		this.isHtml = isHtml;
	}

	
	
	public FileSystemResource getFile() {
		return file;
	}

	public void setFile(FileSystemResource file) {
		this.file = file;
	}

	public EmailModel() {
		this.cc = new ArrayList<String>();
	}
	
	

	public EmailModel(String from, String to, String subject, String message, FileSystemResource file) {
		this();
		this.from = from;
		this.subject = subject;
		this.message = message;
		this.to = to;
		this.file = file;
	}
	
	
	public EmailModel(String from, String to, String subject, String message) {
		this();
		this.from = from;
		this.subject = subject;
		this.message = message;
		this.to = to;
	}

	public EmailModel(String from, String to, String ccList, String subject, String message, FileSystemResource file) {
		this();
		this.from = from;
		this.subject = subject;
		this.message = message;
		this.to = to;
		this.cc.addAll(Arrays.asList(splitByComma(ccList)));
		this.file = file;
	}

	private String[] splitByComma(String toMultiple) {
		String[] toSplit = toMultiple.split(",");
		return toSplit;
	}

	// public String getToAsList() { return AppUtil.concatenate(this.to, ","); }

}
