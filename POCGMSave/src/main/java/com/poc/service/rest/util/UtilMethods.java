package com.poc.service.rest.util;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class UtilMethods {

	public static String readTextFile(String fileName) throws IOException {
	    String content = new String(Files.readAllBytes(Paths.get(fileName)));
	    return content;
	}
	
	public static List<String> readTextFileByLines(String fileName) throws IOException {
	    List<String> lines = Files.readAllLines(Paths.get(fileName), Charset.defaultCharset());
	    System.out.println("Cantidad de lineas : "+lines.size());
	    return lines;
	}
	
	public static String getFileName(String fileName){
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH)+1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int year = cal.get(Calendar.YEAR);
		String fileNewName=fileName+"_"+month+day+year+CommonConstants.GenericValues.TXT_EXTENSION;
		System.out.println("fileNewName : "+fileNewName);
		return fileNewName;
	}
	
	public static String getCurrentTimeStamp() {
	    SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//dd/MM/yyyy
	    Date now = new Date();
	    String strDate = sdfDate.format(now);
	    return strDate;
	}
	
}
