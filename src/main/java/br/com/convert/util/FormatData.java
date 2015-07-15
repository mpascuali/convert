package br.com.convert.util;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.log4j.Logger;

import br.com.convert.enums.Constantes;
import br.com.peopleway.util.ExceptionSystem;

@SuppressWarnings("serial")
public class FormatData implements Serializable {
	
	private static final Logger logger = Logger.getLogger(FormatData.class);
	
	public static Date stringToDate(String formato,String newData){
		SimpleDateFormat format = new SimpleDateFormat(formato);
		Date data = null;
		try {
			data = format.parse(newData);
		} catch (ParseException e) {
			e.printStackTrace();
			new ExceptionSystem("ERRO AO FORMATAR DATA");
		}
		return data;
	}
	
	public static String dateFormatedToString(String formato,Date newData){
		SimpleDateFormat formated = new SimpleDateFormat(formato);
		String data = null;
		data = formated.format(newData);
		return data;
	}

	public static java.util.Date stringToDate(Constantes formato, String newData) {
		infoLog("Date stringToDate - START");
		SimpleDateFormat format = new SimpleDateFormat(formato.getDataType());
		Date data = null;
		try {
			data = format.parse(newData);
		} catch (ParseException e) {
			logger.error("Date stringToDate - ERROR: ", e);
		}
		infoLog("Date stringToDate - END");
		return data;
	}

	public static String dateFormatedToString(Constantes formato,Date newData) {
		infoLog("String dateFormatedToString - START");
		SimpleDateFormat formated = new SimpleDateFormat(formato.getDataType());
		String data = null;
		data = formated.format(newData);
		infoLog("String dateFormatedToString - END");
		return data;
	}

	public static String stringToStringDate(Constantes formato, String newData) {
		infoLog("String stringToStringDate - START");
		SimpleDateFormat format = new SimpleDateFormat(formato.getDataType());
		Date data = null;
		try {
			data = format.parse(newData);
		} catch (ParseException e) {
			logger.error("String stringToStringDate - ERROR: ", e);
			e.printStackTrace();
		}
		infoLog("String stringToStringDate - END");
		return data.toString();
	}

	public static Date convertStringToDate(Constantes formato, String data) {
		infoLog("String stringToStringDate - START");
		Date d = null;
		SimpleDateFormat format = new SimpleDateFormat(formato.getDataType());
		try {
			d = new java.sql.Date(format.parse(data).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
			logger.error("String stringToStringDate - ERROR: ", e);
		}
		infoLog("String stringToStringDate - END");
		return d;
	}

	public static String showDateView(Constantes formato) {
		infoLog("static String showDateView() - START");
		Locale loc = new Locale("pt", "BR");
		SimpleDateFormat sdf = new SimpleDateFormat(formato.getDataType(), loc);
		Date d = new Date();
		infoLog("static String showDateView() - END");
		return sdf.format(d);
	}

	private static void infoLog(String msg) {
		if (logger.isDebugEnabled()) {
			logger.debug(msg);
		}
	}

	public static Date convertStringToDate(String formato, String data) {
		infoLog("String stringToStringDate - START");
		Date d = null;
		SimpleDateFormat format = new SimpleDateFormat(formato);
		try {
			d = new java.sql.Date(format.parse(data).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
			logger.error("String stringToStringDate - ERROR: ", e);
		}
		infoLog("String stringToStringDate - END");
		return d;
	}
	
	public static String dateFormToString(String formato, Object newData) {
		SimpleDateFormat formated = new SimpleDateFormat(formato);
		String data = null;
		data = formated.format(newData);
		return data;
	}
	
	public static String dateFormatedToString(String formato, Object newData) {
		SimpleDateFormat formated = new SimpleDateFormat(formato);
		String data = null;
		data = formated.format(newData);
		return data;
	}
}