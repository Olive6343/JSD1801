package com.ldq.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class InputStreamTest2 {
	/**
	 * 将文件src/com/ldq/file/FileTest.java的内容拷贝到src/com/ldq/file/FileTest_copy.txt
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		//读文件
		File file = new File("src/com/ldq/file/FileTest.java");
		FileInputStream fis = new FileInputStream(file);
		int buff;
		int outbu;
		char cha;
		cha = (char) fis.read();
//		while((buff= fis.read()) != -1){
////			System.out.print(buff);
//		}
//		fis.close();//关闭流
		// 创建项目文件的对象
		File file2 = new File("src/com/ldq/file/FileTest_copy.txt");
		// 将文件对象和文件字节输出流关联起来
		
		FileOutputStream fos = new FileOutputStream(file2);
		
		FileInputStream fis2 = new FileInputStream(file2);

		// 写文件
		while((buff= fis.read()) != -1){

			for (String string : args) {
	
}
			while((outbu = fis2.read()) != -1){
				fos.write(fis.read());
			}
		}
		fos.flush();// 刷新输出流
		fos.close();// 关闭流
	}
}
