package com.ldq.homwork;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesTest {
	public static void main(String[] args) throws Exception {
		
		File file = new File("saveuser.properties"); // 创建文件对象
		if (!file.exists()) // 判断该文件是否存在，如果不存在则创建新文件
		{
			file.createNewFile();
		}
		// 创建输入流
		InputStream is = new FileInputStream("saveuser.properties");
		// 创建Properties属性对象
		Properties p = new Properties();
		p.load(is);
		// 获得属性
		System.out.println("正在读取。。。");
		// 设置K和V的值
		p.setProperty("user", "1200");
		p.setProperty("root", "2000");
		p.setProperty("admin", "12355");
		System.out.println("正在写入。。。");
		// 将属性写到新的文件
		p.store(new FileOutputStream("saveuser.properties"),"账户和金额属性列表" );
	}

}
