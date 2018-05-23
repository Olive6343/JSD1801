package com.entor.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * System 类包含一些有用的类字段和方法。
 * 
 * @author Administrator
 *
 */
public class SystemTest {
	public static void main(String[] args) throws IOException {
		// System.in表示一个字节流，通常就是键盘的输入流
		InputStream is = System.in;
		// 将键盘输入流封装到Scanner中，提供更优越的读取操作
		Scanner sc = new Scanner(is);
		System.out.println("请输入:");
		// System.out.println(sc.next());// 将空格作为扫描的结束标记
		// System.out.println(sc.nextLine());// 将回车换行作为扫描的结束标记

		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		System.out.println(br.readLine());// 将回车换行作为扫描的结束标记
	}
}
