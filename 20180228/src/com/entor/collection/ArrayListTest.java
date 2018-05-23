package com.entor.collection;

import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
		ArrayList al = new ArrayList();

		al.add(1);
		al.add('d');
		al.add("123");
		al.add(new Exception("hsh"));
		al.add(new int[] { 1, 3, 4, 4 });
		System.out.println(al);

		Object obj = al.get(1);
		System.out.println(obj);

		al.ensureCapacity(20);// �����ϵ������޸ĳ�20�� ԭ��Ԫ�ذ�˳������������У�ʣ��Ŀռ���ȱʡֵ��ֵ
		al.ensureCapacity(1);// ��ǰ��������1 �� �޸�ʧ��
		System.out.println(al);

		al.add(1, 2.2);// ������������
		System.out.println(al.get(1));
		for (int i = 0; i < al.size(); i++) {
			System.out.println(al.get(i));
		}
		
		al.remove(new Integer(1)); // ����Ԫ�ر���ɾ��
		System.out.println(al);

		int index = al.indexOf("123");// ����Ԫ���ҳ�������
		System.out.println(index);
		
		Object[] objs = al.toArray();// ���ײ��������ЧԪ�ظ��Ƶ��µ�����
		for (Object object : objs) {
			System.out.println(object);
		}
		
		System.out.println(al.isEmpty());
		al.clear();// �Ƴ����б��е�����Ԫ��: ��Ԫ����ȱʡֵ�滻�����ٰ�size��0
		System.out.println(al);
		
		int[] a = {1,4,5,7,0};
		for (int i : a) {
			System.out.println(i);
		}
		
		
	}
}
