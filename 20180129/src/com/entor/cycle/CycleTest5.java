package com.entor.cycle;

/**
 * do-whileѭ������whileѭ��������ͬ����do-while������ִ���״��߼�
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
			
			i++;  //������©
		}while(i <=100);
		System.out.println("1-100��������" + sum);
	}
}
