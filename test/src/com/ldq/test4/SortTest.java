package com.ldq.test4;

import java.util.Arrays;
import java.util.Scanner;

public class SortTest {

	public static void main(String[] args) {
		System.out.println("输入n个数字，以逗号，分开：");
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		//用逗号分割字符串，并保存到数组中
		String[] input2 = input.split(",");
		int[] arr = new int[input2.length];
		//遍历字符串数组，同时赋值给int数组
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(input2[i]);
		}
		System.out.print("排序前：");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "  ");
		}
		System.out.println();
		//调用数组工具排序
		Arrays.sort(arr);
		System.out.print("排序后：");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "  ");
		}
	}
}
