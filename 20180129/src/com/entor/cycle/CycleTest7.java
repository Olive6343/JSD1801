package com.entor.cycle;

/**
 * break������ѭ���ṹ ����1-100�ĺͣ����ʹ���1000��ʱ�������������յĽ�������һ�μӺ͵���
 * 
 * @author Administrator
 *
 */
public class CycleTest7 {

	public static void main(String[] args) {
		int i = 1;
		int sum = 0;
		for(;i <= 100; i++){
			if(sum > 1000){
				break;
			}
			
			sum += i;
		}
		System.out.println("���һ�μ��������" + (i-1));
		System.out.println("�������" + sum);
		
		
		
		int j = 1;
		int sum2 = 0;
		for(;j <= 100; j++){
			sum2 += j;
			if(sum2 > 1000){
				break;
			}
			
		}
		System.out.println("���һ�μ��������" + j);
		System.out.println("�������" + sum2);
	}
	
}
