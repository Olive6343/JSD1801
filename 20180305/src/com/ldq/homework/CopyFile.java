package com.ldq.homework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyFile {

	public static void  copyFileByByteStream(String src,String dest) throws Exception{
		// 1.创建输入流
		InputStream is = new FileInputStream(src);
		// 2.创建输出流
		OutputStream os = new FileOutputStream(dest);
		// 3.读文件
		byte[] buff = new byte[1024];// 缓冲区
		int length;
		while((length = is.read(buff)) != -1){
			// 4.写文件
			os.write(buff, 0, length);
		}
		// 5.刷新流
		os.flush();
		// 6.关闭输出流
		os.close();
		// 7.关闭输入流
		is.close();
	}
	
	public static void main(String[] args) throws Exception {
		copyFileByByteStream("D:\\JSD1801\\day07\\lesson-note.txt", "lesson-note.txt");
	}
}
