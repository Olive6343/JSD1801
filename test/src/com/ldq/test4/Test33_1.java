package com.ldq.test4;

public class Test33_1 {
	private static String[] EACH_BIT_CN = { "��", "Ҽ", "��", "��", "��", "��", "½", "��", "��", "��" };
	private static String[] UNIT_CN = { "Բ��", "ʰ", "��", "Ǫ", "��", "ʰ", "��", "Ǫ", "��", "ʰ", "��", "Ǫ", "��" };

	public static String transfer(String cash) {
		long money = Long.valueOf(cash);
		cash = String.valueOf(money);
		StringBuffer rmb = new StringBuffer();
		String rmb_str = "";
		long level = 1;
		for (int i = 1; i <= cash.length(); i++) {
			// ��ǰλ�ϵ�����
			int num = (int) (money / level % 10);
			// �滻����Ϊ���Ľ��д�����Լ����ʵ���ʱ����ϵ�λ
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

		if (rmb_str.equals("��")) {
			return "��Բ��";
		}

		if (rmb_str.contains("��������"))
			rmb_str = rmb_str.replaceAll("��+��", "��");
		else
			rmb_str = rmb_str.replaceAll("��+��", "��");
		if (rmb_str.contains("��������"))
			rmb_str = rmb_str.replaceAll("��+��", "��");
		else
			rmb_str = rmb_str.replaceAll("��+��", "��");
		if (rmb_str.contains("��������"))
			rmb_str = rmb_str.replaceAll("��+��", "��");
		else
			rmb_str = rmb_str.replaceAll("��+��", "��");
		return rmb_str.replaceAll("��+", "��").concat("Բ��").replace("��Բ", "Բ");
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
		// ����������
		// ��λ5��/ 1 % 10���ַ������Ⱦ�����λ����length - i
		// ʮλ4��/ 10 % 10
		// ��λ3��/ 10 / 10 % 10
		// ǧλ2��/ 10 / 10 / 10 % 10
		// ����10��n-1�η�ȡģ10�Ϳ��Եõ���nλ������
	}
}
