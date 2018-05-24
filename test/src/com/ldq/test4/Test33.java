package com.ldq.test4;

public class Test33 {
	private static String[] BT_CN = { "Ҽ", "��", "��", "��", "��", "½", "��", "��", "��" };
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
						case "��":
							rmb += "��";
							break;
						case "��":
							rmb += "��";
							break;
						case "��":
							rmb += "��";
							break;
						default:
							rmb += "��";
							break;
						}
					} else {
						switch (bit_cn(bit)) {
						case "��":
							rmb += "��";
							break;
						case "��":
							if (!rmb.contains("��"))
								rmb += "��";
							break;
						case "��":
							if (!rmb.contains("��") && !rmb.contains("��"))
								rmb += "��";
							break;
						default:
							break;
						}
					}
				} else {
					rmb += "Բ��";
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
			bit_cn += "Բ��";
			break;
		case 2:
		case 6:
		case 10:
		case 14:
			bit_cn += "ʰ";
			break;
		case 3:
		case 7:
		case 11:
		case 15:
			bit_cn += "��";
			break;
		case 4:
		case 8:
		case 12:
		case 16:
			bit_cn += "Ǫ";
			break;
		case 5:
			bit_cn += "��";
			break;
		case 9:
			bit_cn += "��";
			break;
		case 13:
			bit_cn += "��";
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