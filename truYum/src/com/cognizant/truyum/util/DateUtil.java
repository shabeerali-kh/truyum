package com.cognizant.truyum.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	
	public static  Date convertToDate(String date) throws ParseException {
		Date newDate = new Date();
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		
		newDate= f.parse(date);
		return newDate;
	}
}
