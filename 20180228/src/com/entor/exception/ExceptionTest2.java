package com.entor.exception;

import java.lang.instrument.IllegalClassFormatException;

public class ExceptionTest2 {
	// �׳����쳣�ǽ������Ϣ�������ö˴���
	
	public static void throRuntime(){
		throw new RuntimeException("����ʱ�쳣��");
	}

	public static void throwTryCatch(){
		try {
			throw new IllegalClassFormatException();
		} catch (IllegalClassFormatException e) {
			e.printStackTrace(); // ����쳣��Ϣ
		}
	}
	
	public static void throwIllegal() throws IllegalClassFormatException{
		throw new IllegalClassFormatException("ͨ���ؼ���throw�׳��쳣��Ϣ");
	}
	
	
	public static void main(String[] args)  {
		throwTryCatch();
		System.out.println("��Ļ��������а�!");
//		String
	}
}
