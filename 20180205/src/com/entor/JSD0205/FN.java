package com.entor.JSD0205;

public class FN {

	/**
	 * �����1+3+5+...�ĵ�n��
	 * 
	 * @param n
	 * @return
	 */
	public int f(int n) {
		if (n == 1) {
			return 1;
		}
		return f(n - 1) + 2;
	}

	public int sum(int n) {
		if (n == 1) {
			return 1;
		}
		return sum(n - 1) + f(n);
	}

	public static void main(String[] args) {
		FN fn = new FN();
		System.out.println(fn.f(100));
		System.out.println(fn.sum(100));
	}
}
