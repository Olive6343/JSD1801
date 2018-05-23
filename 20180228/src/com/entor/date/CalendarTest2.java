package com.entor.date;

import java.util.Scanner;

public class CalendarTest2 {

	public static void printCalendar() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入年份：");
		int year = sc.nextInt();
		System.out.println("请输入月份：");
		int month = sc.nextInt();
		if(month>12){
			throw new Exception("月份不能超过12");
		}

		// 1900年1月1日到本月1日之间的天数
		int daysFrom1900ToNow = 0;

		// 1900年1月1日是星期一
		// 1900年份1月1日与指定年份上一年总天数
		int daysFrom1900ToPreYear = 0;

		// 判断闰年
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

		// 当前年份到本月之前的天数
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

			// 如果是当前月份，只是记录以下当前月份的天数，并不参与到总天数的计算
			if (m == month) {
				dayOfThisMonth = dayOfMonth;
				continue;
			}
			daysFrom1900ToNow += dayOfMonth;
		}

		// 上述两段计算：假设当前是2018年10月，那么，总天数 = 1900年1月1日到2017年12月31日的天数 +
		// 2018年1月1日到2018年9月30日的天数

		// 1900年1月1日是星期一
		// 本月1号星期几
		int start = daysFrom1900ToNow % 7 + 1;
		System.out.println(year + "年" + month + "月1日星期：" + start);
		System.out.println(year + "年" + month + "月共：" + dayOfThisMonth + "天");
		System.out.println();
		// 输出日历
		System.out.println("星期日\t星期一\t星期二\t星期三\t星期四\t星期五\t星期六");
		System.out.println();
		for (int i = 1; i <= start; i++) {
			System.out.print("\t");
		}
		for (int j = 1; j <= dayOfThisMonth; j++) {
			if ((j + start) % 7 == 1) {// 从1号开始，星期六输出后换行
				System.out.print("\n" + j + "\t");
			} else {
				System.out.print(j + "\t");
			}
		}

	}

	public static void main(String[] args) throws Exception {
		CalendarTest2.printCalendar();
		// Scanner sc = new Scanner(System.in);
		// System.out.println("请输入年份：");
		// int year = sc.nextInt();
		// System.out.println("请输入月份：");
		// int month = sc.nextInt();
		//
		// // 1900年1月1日到本月1日之间的天数
		// int daysFrom1900ToNow = 0;
		//
		// // 1900年1月1日是星期一
		// // 1900年份1月1日与指定年份上一年总天数
		// int daysFrom1900ToPreYear = 0;
		//
		// // 判断闰年
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
		// // 当前年份到本月之前的天数
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
		// // 如果是当前月份，只是记录以下当前月份的天数，并不参与到总天数的计算
		// if (m == month) {
		// dayOfThisMonth = dayOfMonth;
		// continue;
		// }
		// daysFrom1900ToNow += dayOfMonth;
		// }
		//
		// // 上述两段计算：假设当前是2018年10月，那么，总天数 = 1900年1月1日到2017年12月31日的天数 +
		// // 2018年1月1日到2018年9月30日的天数
		//
		// // 1900年1月1日是星期一
		// // 本月1号星期几
		// int start = daysFrom1900ToNow % 7 + 1;
		//
		// // 输出日历
		// System.out.println("星期日\t星期一\t星期二\t星期三\t星期四\t星期五\t星期六");
		// for (int i = 1; i <= start; i++) {
		// System.out.print("\t");
		// }
		// for (int j = 1; j <= dayOfThisMonth; j++) {
		// if ((j + start) % 7 == 1) {// 从1号开始，星期六输出后换行
		// System.out.print("\n" + j + "\t");
		// } else {
		// System.out.print(j + "\t");
		// }
		// }
		// }
	}
}