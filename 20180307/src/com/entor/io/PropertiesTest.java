package com.entor.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesTest {
	public static void main(String[] args) throws IOException {
		// 读取jdbc.properties文件到输入流中
		InputStream is = new FileInputStream("jdbc.properties");
		// 创建一个属性对象
		Properties p = new Properties();
		p.load(is);
		// 获取属性
		System.out.println(p.getProperty("jdbc.driverClass"));
		// 设置新属性
		p.setProperty("jdbc.url", "jdbc:mysql://localhost:3306/test");
		p.setProperty("jdbc.username", "root");
		p.setProperty("jdbc.password", "root");
		// 将属性列表写到文件中
		// p.list(System.out);
		p.store(new FileOutputStream("jdbc2.properties"), "jdbc驱动等属性列表");

		// 系统属性
		p = System.getProperties();
		p.list(System.out);
	}
}
