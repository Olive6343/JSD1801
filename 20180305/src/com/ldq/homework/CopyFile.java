package com.ldq.homework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyFile {

	public static void  copyFileByByteStream(String src,String dest) throws Exception{
		// 1.����������
		InputStream is = new FileInputStream(src);
		// 2.���������
		OutputStream os = new FileOutputStream(dest);
		// 3.���ļ�
		byte[] buff = new byte[1024];// ������
		int length;
		while((length = is.read(buff)) != -1){
			// 4.д�ļ�
			os.write(buff, 0, length);
		}
		// 5.ˢ����
		os.flush();
		// 6.�ر������
		os.close();
		// 7.�ر�������
		is.close();
	}
	
	public static void main(String[] args) throws Exception {
		copyFileByByteStream("D:\\JSD1801\\day07\\lesson-note.txt", "lesson-note.txt");
	}
}
