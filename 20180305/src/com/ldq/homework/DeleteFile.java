package com.ldq.homework;

import java.io.File;

public class DeleteFile {
	public static void main(String[] args) {
		File file1 = new File("D:\\test");
		File file2 = new File("D:\\test\\a");
		File file3 = new File("D:\\test\\a\\b");
		File file4 = new File("D:\\test\\a\\c.txt");
		String []str = file1.list();
		for (String string : str) {
			System.out.println(string);
		}
		System.out.println(file4.delete());
		System.out.println(file3.delete());
		System.out.println(file2.delete());
		System.out.println(file1.delete());
	}
}
