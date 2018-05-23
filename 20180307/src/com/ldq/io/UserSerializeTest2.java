package com.ldq.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.entor.io.User;

public class UserSerializeTest2 {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		User user = new User();
		user.setName("����1");
		user.setLevel(28);
		user.setLife("500");
		user.setProp(new String[] { "����", "����", "�������2" });
		System.out.println(user);
		// ���л�
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("����.txt"));
		user.writeObject(oos);
		oos.flush();
		oos.close();
	}
}
