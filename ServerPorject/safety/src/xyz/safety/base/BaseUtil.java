package xyz.safety.base;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.UUID;

public class BaseUtil {
	public static String fixNull(String str){
		if(str == null)
			return "";
		else
			return str;
	}
	
	public static int getCurrentYear(){
		Calendar calendar = new GregorianCalendar();
		return calendar.get(calendar.YEAR);
	}
	
	public static String getUUID(){
		return UUID.randomUUID().toString();
	}
}
