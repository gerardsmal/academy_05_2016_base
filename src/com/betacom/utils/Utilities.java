package com.betacom.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

import com.betacom.exception.AcademyException;

public class Utilities {
	private final static String PATTERN_DATE = "d/M/yyyy HH:mm:ss";
	/*
	 * transform date to format string
	 */
	
	public static String dateToString(LocalDateTime myDate) {
		return dateToString(PATTERN_DATE,myDate);
	}	
	public static String dateToString(String pattern, LocalDateTime myDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, Locale.ITALIAN);		
		return myDate.format(formatter);
	}
	
	public static String dateToString(String pattern, LocalDate myDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, Locale.ITALIAN);		
		return myDate.format(formatter);
	}
	
	public static LocalDate stringToDate(String pattern, String myDate) throws AcademyException{
		LocalDate r = null;
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, Locale.ITALIAN);
			r=  LocalDate.parse(myDate, formatter);
			
		} catch (DateTimeParseException e) {
			throw new AcademyException("Formato della data invalido:" + myDate + " formato previsto:" + pattern);
		}
		return r;
	}
	
	public static String buildClassName(String par) {
		return par.substring(0, 1).toUpperCase() + par.substring(1).toLowerCase() + "Manager";
	}

}
