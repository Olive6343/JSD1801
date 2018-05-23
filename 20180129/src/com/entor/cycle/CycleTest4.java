package com.entor.cycle;

/**
 * continue：跳过当前次循环，执行下一次循环<br>
 * 计算1-100的和，其中50不参与计算
 * @author Administrator
 *
 */
public class CycleTest4 {

	public static void main(String[] args) {
		int i= 1;
		int sum = 0;

		while(i <= 100){
			if(i == 50){
				i++;
				continue;
			}
			sum += i;
			i++;
			
		}
		System.out.println("1-100的奇数和" + sum);
	}
}
