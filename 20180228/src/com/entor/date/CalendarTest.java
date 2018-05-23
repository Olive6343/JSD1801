package com.entor.date;

import java.util.Calendar;
import java.util.Scanner;

public class CalendarTest {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入年份：");
		int year = sc.nextInt();
		System.out.println("请输入月份：");
		int month = sc.nextInt();
		// 判断月份数是否合法
		if (month > 12) {
			throw new Exception("月份不能超过12");
		}

		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month - 1);
		c.set(Calendar.DAY_OF_MONTH, 1);
		// 获取一星期的第一天
		int fisrtDayOfWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
		// 当前月的总天数
		int dayOfMonth = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println(year + "年" + month + "月1日星期：" + fisrtDayOfWeek);
		System.out.println(year + "年" + month + "月共：" + dayOfMonth + "天");
		System.out.println();
		// 输出日历
		System.out.println("星期日\t星期一\t星期二\t星期三\t星期四\t星期五\t星期六");
		// System.out.println();
		// 当前月的1号前面的空位
		for (int i = 1; i <= fisrtDayOfWeek; i++) {
			System.out.print("\t");
		}
		for (int j = 1; j <= dayOfMonth; j++) {
			if ((j + fisrtDayOfWeek) % 7 == 0) { // 从1号开始，星期六输出后换行
				System.out.print(j + "\n");
			} else {
				System.out.print(j + "\t");
			}
		}
	}
}
