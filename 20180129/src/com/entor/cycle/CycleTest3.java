package com.entor.cycle;

/**
 * ������ϰ������1-100��������
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
		System.out.println("1-100��������" + sum);
	}
}
