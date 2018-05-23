package com.entor.date;

import java.util.Scanner;

public class CalendarTest2 {

	public static void printCalendar() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("��������ݣ�");
		int year = sc.nextInt();
		System.out.println("�������·ݣ�");
		int month = sc.nextInt();
		if(month>12){
			throw new Exception("�·ݲ��ܳ���12");
		}

		// 1900��1��1�յ�����1��֮�������
		int daysFrom1900ToNow = 0;

		// 1900��1��1��������һ
		// 1900���1��1����ָ�������һ��������
		int daysFrom1900ToPreYear = 0;

		// �ж�����
		boolean isLeapYaer = false;
		if (year % 400 == 0 || (year % 100 != 0 && year % 4 == 0)) {
			isLeapYaer = true;
		}
		for (int i = year - 1; i >= 1; i--) {
			if (isLeapYaer) {
				daysFrom1900ToPreYear += 366;
			} else {
				daysFrom1900ToPreYear += 365;
			}
		}
		daysFrom1900ToNow += daysFrom1900ToPreYear;

		// ��ǰ��ݵ�����֮ǰ������
		int dayOfThisMonth = 0;
		for (int m = month; m >= 1; m--) {
			int dayOfMonth = 0;
			switch (m) {
			case 2:
				if (isLeapYaer) {
					dayOfMonth = 29;
				} else {
					dayOfMonth = 28;
				}
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				dayOfMonth = 30;
				break;
			default:
				dayOfMonth = 31;
				break;
			}

			// ����ǵ�ǰ�·ݣ�ֻ�Ǽ�¼���µ�ǰ�·ݵ��������������뵽�������ļ���
			if (m == month) {
				dayOfThisMonth = dayOfMonth;
				continue;
			}
			daysFrom1900ToNow += dayOfMonth;
		}

		// �������μ��㣺���赱ǰ��2018��10�£���ô�������� = 1900��1��1�յ�2017��12��31�յ����� +
		// 2018��1��1�յ�2018��9��30�յ�����

		// 1900��1��1��������һ
		// ����1�����ڼ�
		int start = daysFrom1900ToNow % 7 + 1;
		System.out.println(year + "��" + month + "��1�����ڣ�" + start);
		System.out.println(year + "��" + month + "�¹���" + dayOfThisMonth + "��");
		System.out.println();
		// �������
		System.out.println("������\t����һ\t���ڶ�\t������\t������\t������\t������");
		System.out.println();
		for (int i = 1; i <= start; i++) {
			System.out.print("\t");
		}
		for (int j = 1; j <= dayOfThisMonth; j++) {
			if ((j + start) % 7 == 1) {// ��1�ſ�ʼ���������������
				System.out.print("\n" + j + "\t");
			} else {
				System.out.print(j + "\t");
			}
		}

	}

	public static void main(String[] args) throws Exception {
		CalendarTest2.printCalendar();
		// Scanner sc = new Scanner(System.in);
		// System.out.println("��������ݣ�");
		// int year = sc.nextInt();
		// System.out.println("�������·ݣ�");
		// int month = sc.nextInt();
		//
		// // 1900��1��1�յ�����1��֮�������
		// int daysFrom1900ToNow = 0;
		//
		// // 1900��1��1��������һ
		// // 1900���1��1����ָ�������һ��������
		// int daysFrom1900ToPreYear = 0;
		//
		// // �ж�����
		// boolean isLeapYaer = false;
		// if (year % 400 == 0 || (year % 100 != 0 && year % 4 == 0)) {
		// isLeapYaer = true;
		//
		// for (int i = year - 1; i >= 1990; i--) {
		// if (isLeapYaer) {
		// daysFrom1900ToPreYear += 366;
		// } else {
		// daysFrom1900ToPreYear += 365;
		// }
		// }
		// daysFrom1900ToNow += daysFrom1900ToPreYear;
		//
		// // ��ǰ��ݵ�����֮ǰ������
		// int dayOfThisMonth = 0;
		// for (int m = month; m >= 1; m--) {
		// int dayOfMonth = 0;
		// switch (m) {
		// case 2:
		// if (isLeapYaer) {
		// dayOfMonth = 29;
		// } else {
		// dayOfMonth = 28;
		// }
		// break;
		// case 4:
		// case 6:
		// case 9:
		// case 11:
		// dayOfMonth = 30;
		// break;
		// default:
		// dayOfMonth = 31;
		// break;
		// }
		//
		// // ����ǵ�ǰ�·ݣ�ֻ�Ǽ�¼���µ�ǰ�·ݵ��������������뵽�������ļ���
		// if (m == month) {
		// dayOfThisMonth = dayOfMonth;
		// continue;
		// }
		// daysFrom1900ToNow += dayOfMonth;
		// }
		//
		// // �������μ��㣺���赱ǰ��2018��10�£���ô�������� = 1900��1��1�յ�2017��12��31�յ����� +
		// // 2018��1��1�յ�2018��9��30�յ�����
		//
		// // 1900��1��1��������һ
		// // ����1�����ڼ�
		// int start = daysFrom1900ToNow % 7 + 1;
		//
		// // �������
		// System.out.println("������\t����һ\t���ڶ�\t������\t������\t������\t������");
		// for (int i = 1; i <= start; i++) {
		// System.out.print("\t");
		// }
		// for (int j = 1; j <= dayOfThisMonth; j++) {
		// if ((j + start) % 7 == 1) {// ��1�ſ�ʼ���������������
		// System.out.print("\n" + j + "\t");
		// } else {
		// System.out.print(j + "\t");
		// }
		// }
		// }
	}
}