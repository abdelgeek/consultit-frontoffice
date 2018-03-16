package com.consultitnow.app.utils;

import java.util.Date;

public class SavedQuotationMailBody extends MailBody {

	private String number;
	private Date date;
	
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
