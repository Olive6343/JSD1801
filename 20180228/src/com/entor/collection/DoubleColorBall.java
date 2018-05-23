package com.entor.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DoubleColorBall {

	private List<Integer> BuyNumList = new ArrayList();

	/**
	 * 获取客户输入的六个红球和一个蓝球
	 */
	public void getBuyNumList() {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		for (int i = 1; i <= 7; i++) {
			if (i <= 6) {
				System.out.println("请输入第" + i + "个红球号码：");
				num = sc.nextInt();
			} else {
				System.out.println("请输入红球号码：");
				num = sc.nextInt();
			}
			BuyNumList.add(i - 1, num);
		}
		int[] arr = new int[6];
		for(int i=0; i<6;i++){
			arr[i] = BuyNumList.get(i);
		}
		Object[] obj = BuyNumList.toArray();
		Arrays.sort(obj);
		for(int i=0; i<6;i++){
			System.out.print(obj[i]+" ");
		}
		// 排序arr
		Arrays.sort(arr);
		System.out.println("购买的双色球：");
		for(int i=0; i<6;i++){
			System.out.print(arr[i] + " ");
		}
		
		System.out.print("- " + BuyNumList.get(6));
		System.out.println();
	}

	/**
	 * 获取随机七个数作为开奖号码
	 */
	public void getRandom() {

		int[] balls = new int[33];
		for (int i = 0; i < 33; i++) {
			balls[i] = i + 1;
		}
		int[] random = new int[7]; // 存放随机号码的数组
		int j = 0;
		boolean[] flags = new boolean[33];
		int index;
		for (int i = 0; i < 6; i++) {
			do {
				index = (int) (Math.random() * 33 + 1);
				if (flags[index] == false) {
					random[j++] = balls[index];
					flags[index] = true;
					break;
				}
			} while (flags[index]);

		}
		random[6] = (int) (Math.random() * 16 + 1); // 蓝球

		System.out.println("开奖号码为： ");
		// 创建新的数组对象
		int arr[] = new int[6];
		// 红球放进新的数组arr
		for (int i = 0; i < 6; i++) {
			arr[i] = random[i];
		}
		// 对红球进行排序
		Arrays.sort(arr);

		// 输出双色球
		for (int i = 0; i < 6; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.print("- " + random[6]);
	}

	// 双色球
	public static void main(String[] args) {

		DoubleColorBall dcb = new DoubleColorBall();
		dcb.getBuyNumList();
		dcb.getRandom();
	}
}
