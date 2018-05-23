package com.ldq.bms.utils;

public class StringUtils {
	
	/**
	 * 判断字符序列是否包含指定的字符序列，忽略英文字母大小写
	 * @param str1  包含的序列
	 * @param str2 被包含的系列
	 * @return 是否包含
	 */
	public static boolean containsIgnoreCase(String str1, String str2){
		// 大小写一致
		if(str1.contains(str2))
			return true;
		// 大小写不一致
		// 把待处理的两个字符串转为大写
		String temp1 = str1.toUpperCase();
		String temp2 = str2.toUpperCase();
		if(temp1.contains(temp2))
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(containsIgnoreCase("abc","Abcs"));
	}
}
