package com.consultitnow.app.utils;

import java.util.Date;

public class MailBody {

	
	private String quotationNumber;
	private Date quotationDate;
	private String typeTemplateEmail;
	private String url;
	
	
	public String getQuotationNumber() {
		return quotationNumber;
	}
	public void setQuotationNumber(String quotationNumber) {
		this.quotationNumber = quotationNumber;
	}
	public Date getQuotationDate() {
		return quotationDate;
	}
	public void setQuotationDate(Date quotationDate) {
		this.quotationDate = quotationDate;
	}
	public String getTypeTemplateEmail() {
		return typeTemplateEmail;
	}
	public void setTypeTemplateEmail(String typeTemplateEmail) {
		this.typeTemplateEmail = typeTemplateEmail;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
}
