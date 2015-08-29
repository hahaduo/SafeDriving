package xyz.safety.base;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;

public class BaseUtil {
	
	private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	private static final int[] calendarFields = {Calendar.MINUTE,Calendar.HOUR,Calendar.DATE,Calendar.MONTH,Calendar.YEAR};
	
	public static String fixNull(String str){
		if(str == null)
			return "";
		else
			return str;
	}
	
	public static int getCurrentYear(){
		Calendar calendar = new GregorianCalendar();
		return calendar.get(Calendar.YEAR);
	}
	
	/**
	 * parameter:condition
	 * 格式为标志位[分,时,日,月,年]的数组，根据数组值删除范围内记录
	 * 例如：[30,1,0,0,0] 删除1小时30分内的数据
	 */
	public static String getBeforeDate(int[] condition){
		Calendar calendar = new GregorianCalendar();
		for(int i=0;i<condition.length;i++){
			calendar.add(calendarFields[i], 0-condition[i]);
		}
		return getFormatDate(calendar.getTime());
	}
	
	public static String getUUID(){
		return UUID.randomUUID().toString();
	}
	
	public static String getFormatDate(Date date){
		DateFormat format1 = new SimpleDateFormat(DATE_FORMAT);
        return format1.format(date);
	}
}
