package com.entor.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DoubleColorBall2 {

	private List<Integer> redNumList = new ArrayList();
	private List<Integer> blueNumList = new ArrayList();
	private List redBallsList = new ArrayList();
	private List blueBallsList = new ArrayList();
	

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
				redNumList.add(i - 1, num);
			} else {
				System.out.println("请输入红球号码：");
				num = sc.nextInt();
				blueNumList.add(0, num);
			}
			
		}
		Object[] obj = redNumList.toArray();
		Arrays.sort(obj);
		System.out.println("购买的双色球：");
		for(int i=0; i<6;i++){
			System.out.print(obj[i]+" ");
		}
		System.out.print("- " + blueNumList.get(0));
		
		System.out.println();
	}

	/**
	 * 获取随机七个数作为开奖号码
	 */
	public void getRandom() {

		for(int i=1;i<=33;i++){
			redBallsList.add(i);
		}
		
	}

	// 双色球
	public static void main(String[] args) {

		DoubleColorBall2 dcb = new DoubleColorBall2();
		dcb.getBuyNumList();
		dcb.getRandom();
	}
}
