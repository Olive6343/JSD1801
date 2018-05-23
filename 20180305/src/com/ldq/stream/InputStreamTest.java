package com.ldq.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class InputStreamTest {
	public static void main(String[] args) throws IOException {
		//字节流超类：InputStream，OutputStream
		//文件流操作：子类：FileInputStream(读文件),FileOutputStream(取文件)
		
		//读文件
		File file = new File("src/com/ldq/file/FileTest.java");
		FileInputStream fis = new FileInputStream(file);
		
		int buff;
		while((buff= fis.read()) != -1){
			System.out.print((char)buff);
		}
		fis.close();//关闭流
		// 创建项目文件的对象
		File file2 = new File("src/com/ldq/file/out.txt");
		// 将文件对象和文件字节输出流关联起来
		FileOutputStream fos = new FileOutputStream(file2);
		for (int i = 0; i <=100; i++) {
			fos.write(i);
		}
		fos.flush();// 刷新输出流
		fos.close();// 关闭流
	}
}
