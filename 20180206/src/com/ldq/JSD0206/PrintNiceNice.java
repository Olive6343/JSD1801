package com.ldq.JSD0206;

public class PrintNiceNice {
	public static int f(int n) {
		if (n <= 0) {
			throw new RuntimeException("输入的数必须正整数!");
		}
		if (n == 1) {
			return 1;
		}
		return f(n - 1) * n;
	}

	public static int sum(int n) {
		
//		score >= 90 ?? "A" : (score < 60 ? "C" : "B")
		if (n <= 0) {
			throw new RuntimeException("输入的数必须正整数!");
		}
		if (n == 1) {
			return f(1);
		}
		return sum(n - 1) + f(n);
	}

	 public static void main(String[] args) {
		 System.out.println("1+2!+3!+...+5!的和是：" + sum(5));
	 }

//	public static void main(String[] args) {
//		for (int i = 1; i <= 9; i++) {
//			for (int j = 1; j <= i; j++) {
//				System.out.print(i + "*" + j + "=" + i * j + "\t");
//			}
//			System.out.println();
//		}
//	}

}
