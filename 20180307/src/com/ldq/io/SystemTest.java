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
		System.out.println("�����룺");
//		System.out.println(sc.next());// ���ո���߻س�������Ϊɨ��Ľ������
//		System.out.println(sc.nextLine());// ���س�������Ϊɨ��Ľ������
		
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		System.out.println(br.readLine());
	}
}
