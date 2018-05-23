package com.entor.date;

import java.util.Calendar;
import java.util.Scanner;

/**
 * 输入指定的年月，输出该月对应的日历图（日期和周）
 * 
 * @author Administrator
 *
 */
public class CalendarTest3 {
	public static void main(String[] args) {
		// 关于week的API
		Calendar c = Calendar.getInstance();
		System.out.println(c.get(Calendar.WEEK_OF_MONTH));// 当前日期在当前月份中的周的数字
		System.out.println(c.getFirstDayOfWeek());// 星期的第一天
		System.out.println(c.getMinimalDaysInFirstWeek());
		System.out.println(c.get(Calendar.MONDAY));
		System.out.println(c.get(Calendar.DAY_OF_WEEK));

		// 输入年份和月份
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入年份：");
		int year = sc.nextInt();
		System.out.println("请输入月份：");
		int month = sc.nextInt();
		// 根据输入的年月创建Calendar对象
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month-1);
		calendar.set(Calendar.DATE, 1);
		// 计算出当前月份的第一天星期？
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		dayOfWeek = dayOfWeek == 0 ? 7 :dayOfWeek;
		// 获得当前月份的天数
		int maxDaysOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		// 根据一周7天和当前月份的总天数，排列日历图
		System.out.println("一\t二\t三\t四\t五\t六\t日\t");
		for(int each = 1; each <= maxDaysOfMonth; each++){
			if(each == 1){
				for(int i = 1; i <= dayOfWeek - 1; i++){
					System.out.print("\t");
				}
			}
			System.out.print(each + "\t");
			if((dayOfWeek + each - 1) % 7 == 0){
				System.out.println();
			}
		}
	}
}
