package com.entor.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest2 {

	// ǩԼʱ���ǵ�ǰʱ�䣬ǩԼ3����ʱ��
	@SuppressWarnings("deprecation")
	public static Date getRenewDate(Date signedDate){
		Date date = new Date();
		signedDate = date;
		System.out.println("ǩԼʱ���ǣ�"+signedDate);
		
		// ǩԼ������ʱ��
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
		System.out.println("ǩԼ����ʱ���ǣ�" + DateTest2.getRenewDate(new Date()));
		
	}
}
