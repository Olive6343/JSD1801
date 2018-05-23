package com.entor.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest2 {

	// 签约时间是当前时间，签约3年后的时间
	@SuppressWarnings("deprecation")
	public static Date getRenewDate(Date signedDate){
		Date date = new Date();
		signedDate = date;
		System.out.println("签约时间是："+signedDate);
		
		// 签约结束的时间
		Date endDate = new Date();
		endDate.setYear(signedDate.getYear()+3);
		endDate.setMonth(signedDate.getMonth());
		endDate.setDate(signedDate.getDate());
		String end_str = endDate.toString();
		System.out.println(end_str);
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d = new Date();
		String date_str = sdf.format(d);
		
		return endDate;
	}
	
	public static void main(String[] args) {
		System.out.println("签约结束时间是：" + DateTest2.getRenewDate(new Date()));
		
	}
}
