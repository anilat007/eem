package com.kbit.eem.utils;

import org.apache.log4j.Logger;

public class Convert {
	static Logger logger = Logger.getLogger(Convert.class);

	public static boolean CanConverToInt(String s){
		try{
			Integer.parseInt(s);
			return true;
		}
		catch(NumberFormatException ex){
			return false;
		}
	}
}
