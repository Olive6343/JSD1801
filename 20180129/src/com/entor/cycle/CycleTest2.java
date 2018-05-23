package com.entor.cycle;

/**
 * 课堂练习：计算1-100的偶数和
 * 
 * @author Administrator
 *
 */
public class CycleTest2 {

	public static void main(String[] args) {
		//1.定义循环变量
		int i = 1;
		//2.循环条件和递增
		
		int sum = 0;//保存结果
		
		for(;i<=100;i++){
			if(i % 2 == 0){
				sum += i;
			}
		}
		System.out.println("1-100的偶数和" + sum);
		
	}
}
