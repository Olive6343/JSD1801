package com.ldq.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class InputStreamTest {
	public static void main(String[] args) throws IOException {
		//�ֽ������ࣺInputStream��OutputStream
		//�ļ������������ࣺFileInputStream(���ļ�),FileOutputStream(ȡ�ļ�)
		
		//���ļ�
		File file = new File("src/com/ldq/file/FileTest.java");
		FileInputStream fis = new FileInputStream(file);
		
		int buff;
		while((buff= fis.read()) != -1){
			System.out.print((char)buff);
		}
		fis.close();//�ر���
		// ������Ŀ�ļ��Ķ���
		File file2 = new File("src/com/ldq/file/out.txt");
		// ���ļ�������ļ��ֽ��������������
		FileOutputStream fos = new FileOutputStream(file2);
		for (int i = 0; i <=100; i++) {
			fos.write(i);
		}
		fos.flush();// ˢ�������
		fos.close();// �ر���
	}
}
