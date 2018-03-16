package com.consultitnow.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RecordCounter implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Integer quotationCounter;

	private String currentDayOfMonth;

	private String currentMonth;

	private String currentYear;
	private String type;

	public RecordCounter() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuotationCounter() {
		return quotationCounter;
	}

	public String getCurrentDayOfMonth() {
		return currentDayOfMonth;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setCurrentDayOfMonth(String currentDayOfMonth) {
		this.currentDayOfMonth = currentDayOfMonth;
	}

	public String getCurrentMonth() {
		return currentMonth;
	}

	public void setCurrentMonth(String currentMonth) {
		this.currentMonth = currentMonth;
	}

	public String getCurrentYear() {
		return currentYear;
	}

	public void setCurrentYear(String currentYear) {
		this.currentYear = currentYear;
	}

	public void setQuotationCounter(Integer quotationCounter) {
		this.quotationCounter = quotationCounter;
	}

	public RecordCounter(Integer quotationCounter, String currentDayOfMonth) {
		super();
		this.quotationCounter = quotationCounter;
		this.currentDayOfMonth = currentDayOfMonth;
	}

	public RecordCounter(Integer quotationCounter, String currentDayOfMonth, String currentMonth, String currentYear,
			String type) {
		super();
		this.quotationCounter = quotationCounter;
		this.currentDayOfMonth = currentDayOfMonth;
		this.currentMonth = currentMonth;
		this.currentYear = currentYear;
		this.type = type;
	}

}
