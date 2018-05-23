package com.ldq.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SystemTest {
	public static void main(String[] args) throws Exception {
		//
		InputStream is  = System.in;
		Scanner sc = new Scanner(is);
		System.out.println("请输入：");
//		System.out.println(sc.next());// 将空格或者回车换行作为扫描的结束标记
//		System.out.println(sc.nextLine());// 将回车换行作为扫描的结束标记
		
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		System.out.println(br.readLine());
	}
}
