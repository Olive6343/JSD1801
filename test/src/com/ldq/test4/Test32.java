package com.ldq.test4;

import java.util.Arrays;
import java.util.Scanner;

public class Test32 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("������һ�����֣��ö��Ÿ���ÿ�����֣�");
		String input = sc.nextLine();
		String[] nums = input.split(",");
		
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		int i = 12341;
		int j = i % 100 / 10;
		System.out.println(j); 
	}
}
