package com.entor.cycle;

/**
 * continue��������ǰ��ѭ����ִ����һ��ѭ��<br>
 * ����1-100�ĺͣ�����50���������
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
		System.out.println("1-100��������" + sum);
	}
}
