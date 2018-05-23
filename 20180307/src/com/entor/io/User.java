package com.entor.io;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private int level;
	private String life;
	private String[] prop;
	private transient String name;

	public User() {
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getLife() {
		return life;
	}

	public void setLife(String life) {
		this.life = life;
	}

	public String[] getProp() {
		return prop;
	}

	public void setProp(String[] prop) {
		this.prop = prop;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	@Override
	public String toString() {
		return "User [level=" + level + ", life=" + life + ", prop=" + Arrays.toString(prop) + ", name=" + name + "]";
	}

	/**
	 * 序列化
	 * 
	 * @param oos
	 * @throws IOException
	 */
	public void writeObject(ObjectOutputStream oos) throws IOException {
		oos.writeInt(level);
		oos.writeObject(life);
		oos.writeObject(prop);
		oos.writeObject(name);
		oos.flush();
		oos.close();
	}

	/**
	 * 反序列化
	 * 
	 * @param ois
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
		level = ois.readInt();
		life = (String) ois.readObject();
		prop = (String[]) ois.readObject();
		name = (String) ois.readObject();
		ois.close();
	}
}
