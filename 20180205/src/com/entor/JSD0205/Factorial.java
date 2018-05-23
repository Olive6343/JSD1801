package com.entor.JSD0205;

public class Factorial {

	// 1*2*3*4...*N
	
	/**
	 * 1,2,3,...,n 的第n个数
	 * 
	 * @param n
	 * @return
	 */
/*	public int f(int n ){
		if(n == 1){
			return 1;
		}
		
		return f(n-1)+1;
	}*/
	
	/**
	 * 计算 n! = 1*2*3*4...*n 
	 * 
	 * @param n
	 * @return
	 */
	public int factorial(int n){
		if(n == 1){
			return 1;
		}
		return factorial(n-1)*n;
	}
	
	
	/**
	 * 计算 1+2+3+...+n 的和
	 * 
	 * @param n
	 * @return
	 */
	public int sum(int n ){
		if(n == 1){
			return 1;
		}
		return sum(n-1)+n;
	}
	
	/**
	 * 斐波那契数列 1、1、2、3、5、8、13、21、34、……在数学上，斐波纳契数列以如下被以递归的方法定义：
	 * F(0)=0，F(1)=1, F(n)=F(n-1)+F(n-2)（n>=2，n∈N*）
	 * 
	 * @param n
	 * @return
	 */
	public int fibonacci(int n){
		if(n <= 0){
			throw new RuntimeException("fibonacci 必须从第一项开始。");
		}
		if(n == 1){
			return 1;
		}
		if(n == 2){
			return 1;
		}
		return fibonacci(n-1)+fibonacci(n-2);
	}
	
	public static void main(String[] args) {
		Factorial ft = new Factorial();
		System.out.println("4! = " + ft.factorial(4));
		System.out.println("1+2+3+...+100 = " + ft.sum(100));
		System.out.println(ft.fibonacci(0));
	}
}
