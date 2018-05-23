package com.entor.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class UserSerializeTest2 {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		User user = new User();
		System.out.println(user);

		// ·´ÐòÁÐ»¯
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("¹íÆü.txt"));
		user.readObject(ois);
		System.out.println(user);
	}
}
