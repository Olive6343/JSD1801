package com.ldq.JSD0206;

import java.util.Arrays;

public class Tested {

	public static void main(String[] args) {
		String str = new String();//创建一个"", 相当于new char[0];
		//构造器
		String str1 = "123";
		String str1_2 = "123";
		String str2 = new String("123"); // 创建一个"123",相当于底层new
		String str2_2 = new String("456");// 内存中没有"456",先创建"456"，然后再创建一个新的String对象
		String str3 = new String(new char[]{'1','2','3'});
		
		System.out.println(str1==str2);
		System.out.println(str2 == str3);
		System.out.println(str1.equals(str2));
		System.out.println(str2.equals(str3));
		
		int[] a = {1,2,3};
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(Arrays.copyOf(a, 10)));
		char[] b = {'1', '2', '3'};
		System.out.println(Arrays.toString(Arrays.copyOf(b, 10)));

		
	}
}
