package com.entor.cycle;

/**
 * ������ϰ������1-100��ż����
 * 
 * @author Administrator
 *
 */
public class CycleTest2 {

	public static void main(String[] args) {
		//1.����ѭ������
		int i = 1;
		//2.ѭ�������͵���
		
		int sum = 0;//������
		
		for(;i<=100;i++){
			if(i % 2 == 0){
				sum += i;
			}
		}
		System.out.println("1-100��ż����" + sum);
		
	}
}
