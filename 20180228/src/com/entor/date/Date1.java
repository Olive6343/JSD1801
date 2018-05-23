package com.entor.date;
import java.util.Date;

public class Date1 {

	public static void main(String[] args) {
		Date d1 = new Date();
		System.out.println(d1);
		Date d2 = new Date(System.currentTimeMillis());
		System.out.println(d2);
		
		System.out.println(d1.getTime());
		System.out.println(d2.getTime());
		System.out.println(d1.before(d2));
		System.out.println(d1.after(d2));
		System.out.println(d1.compareTo(d2));
		System.out.println(d1.equals(d2));
		d1.setDate(1);
		System.out.println(d1);
		String d4 = "2018/02/28";
	}
}
