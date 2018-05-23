package com.entor.cycle;

/**
 * 课堂练习：计算1-100的奇数和
 * 
 * @author Administrator
 *
 */
public class CycleTest3 {

	public static void main(String[] args) {
		int i= 1;
		int sum = 0;
		while(i<=100){
			if(i % 2 == 1){
				sum += i;
			}
			i++;
		}
		System.out.println("1-100的奇数和" + sum);
	}
}
