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
		user.setName("鬼泣1");
		user.setLevel(28);
		user.setLife("500");
		user.setProp(new String[] { "武器", "护符", "任务道具2" });
		System.out.println(user);
		// 序列化
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("鬼泣.txt"));
		user.writeObject(oos);
		oos.flush();
		oos.close();
	}
}
