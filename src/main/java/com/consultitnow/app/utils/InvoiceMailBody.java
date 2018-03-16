package com.consultitnow.app.utils;

import java.util.Date;

public class InvoiceMailBody extends MailBody {

	private String amount;
	private Date date;
	private String number;
	
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public InvoiceMailBody(String amount, Date date, String number) {
		super();
		this.amount = amount;
		this.date = date;
		this.number = number;
	}
	public InvoiceMailBody() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}