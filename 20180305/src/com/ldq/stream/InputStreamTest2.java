package com.ldq.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class InputStreamTest2 {
	/**
	 * ���ļ�src/com/ldq/file/FileTest.java�����ݿ�����src/com/ldq/file/FileTest_copy.txt
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		//���ļ�
		File file = new File("src/com/ldq/file/FileTest.java");
		FileInputStream fis = new FileInputStream(file);
		int buff;
		int outbu;
		char cha;
		cha = (char) fis.read();
//		while((buff= fis.read()) != -1){
////			System.out.print(buff);
//		}
//		fis.close();//�ر���
		// ������Ŀ�ļ��Ķ���
		File file2 = new File("src/com/ldq/file/FileTest_copy.txt");
		// ���ļ�������ļ��ֽ��������������
		
		FileOutputStream fos = new FileOutputStream(file2);
		
		FileInputStream fis2 = new FileInputStream(file2);

		// д�ļ�
		while((buff= fis.read()) != -1){

			for (String string : args) {
	
}
			while((outbu = fis2.read()) != -1){
				fos.write(fis.read());
			}
		}
		fos.flush();// ˢ�������
		fos.close();// �ر���
	}
}
