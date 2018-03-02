package com.consultitnow.app.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.exolab.castor.xml.handlers.ValueOfFieldHandler;

public class CalendarConfig {

	public static Date addNDaysToDate(Date date, Integer ndays) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_MONTH, 30);

		return cal.getTime();
	}

	public static Date convertDate(Date date, String dateformat) throws ParseException {

		DateFormat df = new SimpleDateFormat(dateformat);
		return df.parse(String.valueOf(date));
	}

	public static int compare2Date(Date date1, Date date2) {

		int result = -1;

		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTime(date1);
		cal2.setTime(date2);

		if (cal1.equals(cal2)) {
			result = 0;
		} else if (cal1.after(cal2)) {
			result = 1;
		}

		return result;

	}

}
