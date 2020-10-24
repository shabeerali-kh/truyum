package com.cognizant.truyum.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	
	public static  Date convertToDate(String date)  {
		Date newDate = new Date();
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			newDate= f.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newDate;
	}
}
