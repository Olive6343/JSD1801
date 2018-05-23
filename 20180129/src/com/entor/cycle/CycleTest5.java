package com.entor.cycle;

/**
 * do-while循环：与while循环基本相同，但do-while无条件执行首次逻辑
 * 
 * @author Administrator
 *
 */
public class CycleTest5 {

	public static void main(String[] args) {
		int i= 1;
		int sum = 0;

		do{
			if(i % 2 == 1){
				sum += i;
			}
			
			i++;  //容易遗漏
		}while(i <=100);
		System.out.println("1-100的奇数和" + sum);
	}
}
