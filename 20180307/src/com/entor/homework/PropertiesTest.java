package com.entor.homework;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesTest {
	public static void main(String[] args) throws Exception {
		// 创建输入流
		InputStream is = new FileInputStream("jdbc.properties");
		// 创建Properties属性对象
		Properties p = new Properties();
		p.load(is);
		// 获得属性
		System.out.println(p.getProperty("account"));
		System.out.println("正在读取。。。");
		// 设置K和V的值
		p.setProperty("user", "123456");
		p.setProperty("root", "root");
		p.setProperty("admin", "admin");
		System.out.println("正在写入。。。");
		// 将属性写到新的文件
		p.store(new FileOutputStream("jdbc2.properties"),"用户名和密码" );
		// 获得系统属性
		p = System.getProperties();
		// 以列表形式输出
		p.list(System.out);
	}

}
