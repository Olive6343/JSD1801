package com.entor.date;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class SignedDate {

	public static Date getRenewDate(Date signedDate){
		Calendar signed_c = Calendar.getInstance();
		signed_c.setTime(signedDate);
		System.out.println("合同签订时间：" + signed_c.getTime());
		signed_c.add(Calendar.YEAR, 3);
		signed_c.add(Calendar.DATE, 1);
		return signed_c.getTime();
	}
	public static void main(String[] args) {
		System.out.println("合同续约时间：" +SignedDate.getRenewDate(new Date()));
	}
}