package com.ldq.test4;

import java.util.Arrays;
import java.util.Scanner;

public class SortTest {

	public static void main(String[] args) {
		System.out.println("����n�����֣��Զ��ţ��ֿ���");
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		//�ö��ŷָ��ַ����������浽������
		String[] input2 = input.split(",");
		int[] arr = new int[input2.length];
		//�����ַ������飬ͬʱ��ֵ��int����
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(input2[i]);
		}
		System.out.print("����ǰ��");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "  ");
		}
		System.out.println();
		//�������鹤������
		Arrays.sort(arr);
		System.out.print("�����");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "  ");
		}
	}
}
