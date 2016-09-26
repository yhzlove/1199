package com.y.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class T {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 设置时间格式  
		Date parse = sdf.parse("2016-09-19");
		Calendar cal = Calendar.getInstance();
        System.out.println(cal.getTime());
        cal.add(Calendar.DAY_OF_MONTH, -1);
        System.out.println(cal.getTime());
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        System.out.println(cal.getTime());
        
        Calendar cal2 = Calendar.getInstance();    
        cal2.setTime(parse); 
        cal2.add(Calendar.DAY_OF_MONTH, -1);
        cal2.add(Calendar.WEEK_OF_YEAR, -0);// 一周    
        cal2.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);    
        System.out.println(cal2.getTime());   
       
	}

}
