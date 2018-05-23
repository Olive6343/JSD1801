package com.ldq.employee;

public class RandomTest {

	public static void main(String[] args) { 
		int[] random = new int[33];
		for (int i = 0; i < 33; i++) {
			random[i] = i + 1;
		}
// 创建一个有10个元素的数组
		int[] a = new int[10];
		System.out.println("10个100以内的不同的随机数是:");
		for(int i=0;i<10;i++){
// 随机取一个100以内的数
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