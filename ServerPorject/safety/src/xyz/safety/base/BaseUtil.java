package xyz.safety.base;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;

public class BaseUtil {
	
	private static final String DATE_FORMAT = "yyyy-MM-dd hh:mm:ss";
	
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
	
	public static String getFormatDate(Date date){
		DateFormat format1 = new SimpleDateFormat(DATE_FORMAT);
        return format1.format(date);
	}
}
