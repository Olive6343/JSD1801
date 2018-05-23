package com.entor.date;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Date2 {

	public static String getRenew(Date signedDate) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd", new Locale("en"));
		Date d = signedDate;
		// Calendar c = (Calendar)signedDate;
		String date_str = sdf.format(d);
		int year = Integer.parseInt(date_str.substring(0, 4));
		int month = Integer.parseInt(date_str.substring(4, 6));
		int day = Integer.parseInt(date_str.substring(6));
		System.out.println("签约时间是：" + date_str);
		// 年单独 + 3
		d.setYear(signedDate.getYear() + 3);

		// d.setMonth(signedDate.getMonth());
		// d.setDate(signedDate.getDate());
		// d.setHours(signedDate.getHours());
		// d.setMinutes(signedDate.getMinutes());
		// d.setSeconds(signedDate.getSeconds());
		date_str = sdf.format(d);
		return date_str;
	}

	public static String getRenewDate(Date d) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String date_str = sdf.format(d);
		int year = Integer.parseInt(date_str.substring(0, 4));
		int month = Integer.parseInt(date_str.substring(4, 6));
		int day = Integer.parseInt(date_str.substring(6));

		year += 3;
		day += 1;
		if (year % 4 != 0) {
			if (month == 2) {
				if (day > 28) {
					day -= 28;
					month += 1;
				}
			}else if (month == 4 || month == 8 || month == 10 || month == 12) {

			}
		}

		String renewDate_str = "" + year + month(month) + day;
		return renewDate_str;
		// return sdf.parse(renewDate_str);
	}

	private static String month(int month) {
		if (month < 10) {
			return "0" + month;
		}
		return String.valueOf(month);
	}

	public static void main(String[] args) throws Exception {
		System.out.println("签约结束时间是：" + Date2.getRenew(new Date()));
		System.out.println("签约结束时间是：" + Date2.getRenewDate(new Date()));

	}
}
