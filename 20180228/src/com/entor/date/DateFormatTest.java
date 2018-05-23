package com.entor.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatTest {

	public static void main(String[] args) throws Exception {
		// 转换对象
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
		// 当前时间
		Date d1 = new Date();
		// 把时间转换成String
		String date_str = sdf1.format(d1);
		System.out.println(date_str);

		SimpleDateFormat sdf2 = new SimpleDateFormat("EEE, MMM d, ''yy", new Locale("en"));
		// 当前时间
		Date d2 = new Date();
		// 把时间转换成String
		date_str = sdf2.format(d2);
		System.out.println(date_str);

		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyy.MMMMM.dd GGG hh:mm aaa", new Locale("en"));
		// 当前时间
		Date d3 = new Date();
		// 把时间转换成String
		date_str = sdf3.format(d3);
		System.out.println(date_str);

		SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", new Locale("en"));
		// 当前时间
		Date d4 = new Date();
		// 把时间转换成String
		date_str = sdf4.format(d4);
		System.out.println(date_str);

		SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy/MM/dd E HH:mm:ss", new Locale("en"));
		// 当前时间
		Date d5 = new Date();
		// 把时间转换成String
		date_str = sdf5.format(d5);
		System.out.println(date_str);
		
		SimpleDateFormat sdf6 = new SimpleDateFormat("dd/MM/yyyy E HH:mm:ss a", new Locale("en"));
		// 当前时间
		Date d6 = new Date();
		// 把时间转换成String
		date_str = sdf6.format(d6);
		System.out.println(date_str);
		
		SimpleDateFormat sdf7 = new SimpleDateFormat("yyyy/MM/dd E h:m:s SSS");
		Date d7 =sdf7.parse("2018/02/28 11:21:20 123");
		System.out.println(d7);
		
	}
}
