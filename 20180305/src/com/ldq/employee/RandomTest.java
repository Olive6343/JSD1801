package com.ldq.employee;

public class RandomTest {

	public static void main(String[] args) { 
		int[] random = new int[33];
		for (int i = 0; i < 33; i++) {
			random[i] = i + 1;
		}
// ����һ����10��Ԫ�ص�����
		int[] a = new int[10];
		System.out.println("10��100���ڵĲ�ͬ���������:");
		for(int i=0;i<10;i++){
// ���ȡһ��100���ڵ���
			a[i] = (int) (Math.random()*100+1);
			for(int j=i;j>=0;j--){
				if(a[i]==a[j]){
					a[i] = (int) (Math.random()*100+1);
				}
			}
			System.out.print(a[i]+" ");
		}
	}
}