package com.entor.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DoubleColorBall {

	private List<Integer> BuyNumList = new ArrayList();

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
			} else {
				System.out.println("�����������룺");
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
		// ����arr
		Arrays.sort(arr);
		System.out.println("�����˫ɫ��");
		for(int i=0; i<6;i++){
			System.out.print(arr[i] + " ");
		}
		
		System.out.print("- " + BuyNumList.get(6));
		System.out.println();
	}

	/**
	 * ��ȡ����߸�����Ϊ��������
	 */
	public void getRandom() {

		int[] balls = new int[33];
		for (int i = 0; i < 33; i++) {
			balls[i] = i + 1;
		}
		int[] random = new int[7]; // ���������������
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
		random[6] = (int) (Math.random() * 16 + 1); // ����

		System.out.println("��������Ϊ�� ");
		// �����µ��������
		int arr[] = new int[6];
		// ����Ž��µ�����arr
		for (int i = 0; i < 6; i++) {
			arr[i] = random[i];
		}
		// �Ժ����������
		Arrays.sort(arr);

		// ���˫ɫ��
		for (int i = 0; i < 6; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.print("- " + random[6]);
	}

	// ˫ɫ��
	public static void main(String[] args) {

		DoubleColorBall dcb = new DoubleColorBall();
		dcb.getBuyNumList();
		dcb.getRandom();
	}
}
