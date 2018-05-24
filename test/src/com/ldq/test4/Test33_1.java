package com.ldq.test4;

public class Test33_1 {
	private static String[] EACH_BIT_CN = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
	private static String[] UNIT_CN = { "圆整", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾", "佰", "仟", "兆" };

	public static String transfer(String cash) {
		long money = Long.valueOf(cash);
		cash = String.valueOf(money);
		StringBuffer rmb = new StringBuffer();
		String rmb_str = "";
		long level = 1;
		for (int i = 1; i <= cash.length(); i++) {
			// 当前位上的数字
			int num = (int) (money / level % 10);
			// 替换数字为中文金额写法，以及在适当的时候加上单位
			if (num == 0) {
				rmb.insert(0, EACH_BIT_CN[num]);
				switch (i) {
				case 5:
				case 9:
				case 13:
					rmb.insert(0, UNIT_CN[i - 1]);
					break;
				default:
					break;
				}
			} else {
				if (i == 1) {
					rmb.insert(0, EACH_BIT_CN[num]);
				} else {
					rmb.insert(0, UNIT_CN[i - 1]).insert(0, EACH_BIT_CN[num]);
				}
			}
			rmb_str = rmb.toString();
			level *= 10;
		}

		if (rmb_str.equals("零")) {
			return "零圆整";
		}

		if (rmb_str.contains("零零零兆"))
			rmb_str = rmb_str.replaceAll("零+兆", "零");
		else
			rmb_str = rmb_str.replaceAll("零+兆", "兆");
		if (rmb_str.contains("零零零亿"))
			rmb_str = rmb_str.replaceAll("零+亿", "零");
		else
			rmb_str = rmb_str.replaceAll("零+亿", "亿");
		if (rmb_str.contains("零零零万"))
			rmb_str = rmb_str.replaceAll("零+万", "零");
		else
			rmb_str = rmb_str.replaceAll("零+万", "万");
		return rmb_str.replaceAll("零+", "零").concat("圆整").replace("零圆", "圆");
	}

	public static void main(String[] args) {
		System.out.println(transfer("0"));
		System.out.println(transfer("1"));
		System.out.println(transfer("10"));
		System.out.println(transfer("11"));
		System.out.println(transfer("100"));
		System.out.println(transfer("101"));
		System.out.println(transfer("110"));
		System.out.println(transfer("111"));
		System.out.println(transfer("1000"));
		System.out.println(transfer("1001"));
		System.out.println(transfer("1010"));
		System.out.println(transfer("1110"));
		System.out.println(transfer("1111"));
		System.out.println(transfer("10000"));
		System.out.println(transfer("10001"));
		System.out.println(transfer("10010"));
		System.out.println(transfer("10100"));
		System.out.println(transfer("10101"));
		System.out.println(transfer("10110"));
		System.out.println(transfer("10111"));
		System.out.println(transfer("10111"));
		System.out.println(transfer("11000"));
		System.out.println(transfer("11001"));
		System.out.println(transfer("11010"));
		System.out.println(transfer("11011"));
		System.out.println(transfer("11011"));
		System.out.println(transfer("11100"));
		System.out.println(transfer("11101"));
		System.out.println(transfer("11110"));
		System.out.println(transfer("11111"));
		System.out.println(transfer("00000"));
		System.out.println(transfer("0000"));
		System.out.println(transfer("000"));
		System.out.println(transfer("00"));
		// 从右往左考虑
		// 个位5：/ 1 % 10，字符串长度就是总位数，length - i
		// 十位4：/ 10 % 10
		// 百位3：/ 10 / 10 % 10
		// 千位2：/ 10 / 10 / 10 % 10
		// 除以10的n-1次方取模10就可以得到第n位的数字
	}
}
