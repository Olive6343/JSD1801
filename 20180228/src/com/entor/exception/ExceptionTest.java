package com.entor.exception;

import java.lang.instrument.IllegalClassFormatException;

public class ExceptionTest {

	public static void main(String[] args)  {
		//����ʱ�쳣��
//		throw new RuntimeException("����ʱ�쳣");// ����ʱ�쳣��ǿ��Ҫ����
		try {
			throw new IllegalClassFormatException("�����쳣");
		} catch (IllegalClassFormatException e) {
			e.printStackTrace();
		}// ������ʱ�쳣ǿ��ʹ���߱���������ȡ��ʩ
		System.out.println("��Ӵ�����������У�");
	}
}
