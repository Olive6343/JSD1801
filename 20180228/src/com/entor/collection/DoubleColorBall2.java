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
	 * ��ȡ�ͻ���������������һ������
	 */
	public void getBuyNumList() {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		for (int i = 1; i <= 7; i++) {
			if (i <= 6) {
				System.out.println("�������" + i + "��������룺");
				num = sc.nextInt();
				redNumList.add(i - 1, num);
			} else {
				System.out.println("�����������룺");
				num = sc.nextInt();
				blueNumList.add(0, num);
			}
			
		}
		Object[] obj = redNumList.toArray();
		Arrays.sort(obj);
		System.out.println("�����˫ɫ��");
		for(int i=0; i<6;i++){
			System.out.print(obj[i]+" ");
		}
		System.out.print("- " + blueNumList.get(0));
		
		System.out.println();
	}

	/**
	 * ��ȡ����߸�����Ϊ��������
	 */
	public void getRandom() {

		for(int i=1;i<=33;i++){
			redBallsList.add(i);
		}
		
	}

	// ˫ɫ��
	public static void main(String[] args) {

		DoubleColorBall2 dcb = new DoubleColorBall2();
		dcb.getBuyNumList();
		dcb.getRandom();
	}
}
