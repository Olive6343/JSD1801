package com.entor.homework;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesTest {
	public static void main(String[] args) throws Exception {
		// ����������
		InputStream is = new FileInputStream("jdbc.properties");
		// ����Properties���Զ���
		Properties p = new Properties();
		p.load(is);
		// �������
		System.out.println(p.getProperty("account"));
		System.out.println("���ڶ�ȡ������");
		// ����K��V��ֵ
		p.setProperty("user", "123456");
		p.setProperty("root", "root");
		p.setProperty("admin", "admin");
		System.out.println("����д�롣����");
		// ������д���µ��ļ�
		p.store(new FileOutputStream("jdbc2.properties"),"�û���������" );
		// ���ϵͳ����
		p = System.getProperties();
		// ���б���ʽ���
		p.list(System.out);
	}

}
