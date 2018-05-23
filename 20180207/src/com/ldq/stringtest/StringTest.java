package com.ldq.stringtest;

import java.util.Arrays;

public class StringTest {

	public static void main(String[] args) {
		String s = new String();
		
		
		// 从身份证号码中找出生日并输出
		String s2 = "450883199501221255";
		System.out.println(s2.substring(6, s2.length()));
		
		
		
//		s3= {"4","5","0","8","8","3","1","9","9","5","0","1","2","2","1","2","5","5","l"};
		String[] s3 = new String[18] ;
		String[] s4 = {"4","5","0","8","8","3","1","9","9","5","0","1","2","2","1","2","5","5"};
//		String[] ss
		System.out.println(Arrays.deepToString(s4));
//		System.out.println(Arrays.toString(s2));
		
	}
	
}
