package com.entor.date;

import java.util.Calendar;
import java.util.Scanner;

public class CalendarTest {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("��������ݣ�");
		int year = sc.nextInt();
		System.out.println("�������·ݣ�");
		int month = sc.nextInt();
		// �ж��·����Ƿ�Ϸ�
		if (month > 12) {
			throw new Exception("�·ݲ��ܳ���12");
		}

		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month - 1);
		c.set(Calendar.DAY_OF_MONTH, 1);
		// ��ȡһ���ڵĵ�һ��
		int fisrtDayOfWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
		// ��ǰ�µ�������
		int dayOfMonth = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println(year + "��" + month + "��1�����ڣ�" + fisrtDayOfWeek);
		System.out.println(year + "��" + month + "�¹���" + dayOfMonth + "��");
		System.out.println();
		// �������
		System.out.println("������\t����һ\t���ڶ�\t������\t������\t������\t������");
		// System.out.println();
		// ��ǰ�µ�1��ǰ��Ŀ�λ
		for (int i = 1; i <= fisrtDayOfWeek; i++) {
			System.out.print("\t");
		}
		for (int j = 1; j <= dayOfMonth; j++) {
			if ((j + fisrtDayOfWeek) % 7 == 0) { // ��1�ſ�ʼ���������������
				System.out.print(j + "\n");
			} else {
				System.out.print(j + "\t");
			}
		}
	}
}
