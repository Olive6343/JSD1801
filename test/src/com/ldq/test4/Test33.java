package com.ldq.test4;

public class Test33 {
	private static String[] BT_CN = { "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
	public static String transfer(String cash) {
		char[] chars = cash.toCharArray();
		String rmb = "";
		for (int i = 0; i < chars.length; i++) {
			int bit = chars.length - i;
			int bit_num = chars[i] - 49;
			if (chars[i] == 48) {
				if (chars.length - 1 != i) {
					if (chars[i + 1] != 48) {
						switch (bit_cn(bit)) {
						case "兆":
							rmb += "兆";
							break;
						case "亿":
							rmb += "亿";
							break;
						case "万":
							rmb += "万";
							break;
						default:
							rmb += "零";
							break;
						}
					} else {
						switch (bit_cn(bit)) {
						case "兆":
							rmb += "兆";
							break;
						case "亿":
							if (!rmb.contains("兆"))
								rmb += "亿";
							break;
						case "万":
							if (!rmb.contains("兆") && !rmb.contains("亿"))
								rmb += "万";
							break;
						default:
							break;
						}
					}
				} else {
					rmb += "圆整";
				}
			} else {
				rmb += BT_CN[bit_num] + bit_cn(bit);
			}
		}
		return rmb;

	}

	private static String bit_cn(int bit) {
		String bit_cn = "";
		switch (bit) {
		case 1:
			bit_cn += "圆整";
			break;
		case 2:
		case 6:
		case 10:
		case 14:
			bit_cn += "拾";
			break;
		case 3:
		case 7:
		case 11:
		case 15:
			bit_cn += "佰";
			break;
		case 4:
		case 8:
		case 12:
		case 16:
			bit_cn += "仟";
			break;
		case 5:
			bit_cn += "万";
			break;
		case 9:
			bit_cn += "亿";
			break;
		case 13:
			bit_cn += "兆";
			break;
		default:
			break;
		}
		return bit_cn;
	}

	public static void main(String[] args) {
		System.out.println(transfer("0"));
	}
}