package com.entor.date;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class SignedDate {

	public static Date getRenewDate(Date signedDate){
		Calendar signed_c = Calendar.getInstance();
		signed_c.setTime(signedDate);
		System.out.println("��ͬǩ��ʱ�䣺" + signed_c.getTime());
		signed_c.add(Calendar.YEAR, 3);
		signed_c.add(Calendar.DATE, 1);
		return signed_c.getTime();
	}
	public static void main(String[] args) {
		System.out.println("��ͬ��Լʱ�䣺" +SignedDate.getRenewDate(new Date()));
	}
}