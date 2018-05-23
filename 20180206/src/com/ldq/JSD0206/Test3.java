package com.ldq.JSD0206;

import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入是一个数：");
		double score = scanner.nextDouble();
		String result = score >= 90 ? "A" : (score < 60 ? "C" : "B");
		System.out.println(result);
		int[] a = {1,2,5,'d',6};
		String str = new String();
	}
}
