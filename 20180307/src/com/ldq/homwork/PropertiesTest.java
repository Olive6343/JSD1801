package com.ldq.homwork;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesTest {
	public static void main(String[] args) throws Exception {
		
		File file = new File("saveuser.properties"); // �����ļ�����
		if (!file.exists()) // �жϸ��ļ��Ƿ���ڣ�����������򴴽����ļ�
		{
			file.createNewFile();
		}
		// ����������
		InputStream is = new FileInputStream("saveuser.properties");
		// ����Properties���Զ���
		Properties p = new Properties();
		p.load(is);
		// �������
		System.out.println("���ڶ�ȡ������");
		// ����K��V��ֵ
		p.setProperty("user", "1200");
		p.setProperty("root", "2000");
		p.setProperty("admin", "12355");
		System.out.println("����д�롣����");
		// ������д���µ��ļ�
		p.store(new FileOutputStream("saveuser.properties"),"�˻��ͽ�������б�" );
	}

}
