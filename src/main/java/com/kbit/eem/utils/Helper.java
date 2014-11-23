package com.kbit.eem.utils;

import org.apache.log4j.Logger;

public class Helper {	
	public static void logError(Logger logger, Exception e){		
		logError(logger, e, 3);
	}
	
	public static void logError(Logger logger, Exception e, int depth){		
		logger.error(String.format("\r\n[Exception in Method: %s]\r\n", getMethodName(depth)));
		logger.error(e);
	}
	
	public static String arrayToCsv(int[] array){
		StringBuilder csv = new StringBuilder();
		
		for (int i = 0; i < array.length; i++) {
			csv.append("," + array[i]);
		}		
		csv.deleteCharAt(0);		
		return csv.toString();
	}
	
	public static String arrayToCsv(String[] array){
		StringBuilder csv = new StringBuilder();
		
		for (int i = 0; i < array.length; i++) {
			csv.append("," + array[i]);
		}
		csv.deleteCharAt(0);		
		return csv.toString();
	}
	
	public static String getMethodName(int depth){
		return Thread.currentThread().getStackTrace()[depth].getMethodName();
	}
	
	public static String getMethodName(){
		return getMethodName(2);
	}
}
