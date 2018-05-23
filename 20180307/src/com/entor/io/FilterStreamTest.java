package com.entor.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 读写文件字节流，读写文件字符流：节点流 <br>
 * 缓冲流，相当于在节点流或者其它流的基础上，提供额外的封装，称为过滤流<br>
 * 过滤流之间是可以互相进行封装
 * 
 * @author Administrator
 *
 */
public class FilterStreamTest {
	public static void main(String[] args) throws IOException {
		// 创建过滤流，封装了文件节点流：提供额外的缓冲操作
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("abc.txt"));
		// 创建过滤流，封装了另外一个过滤流：提供额外字节写操作
		DataOutputStream dos = new DataOutputStream(bos);
		dos.writeInt(123);
		dos.writeLong(123123123123L);
		dos.writeChar('天');
		dos.flush();
		dos.close();

		// 创建过滤流，封装了文件节点流：提供额外的缓冲操作
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("abc.txt"));
		// 创建过滤流，封装了另外一个过滤流：提供额外字节写操作
		DataInputStream dis = new DataInputStream(bis);
		System.out.println(dis.readInt());
		System.out.println(dis.readLong());
		System.out.println(dis.readChar());
		dis.close();
	}
}
