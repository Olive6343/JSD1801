package com.entor.polymorphism;

/**
 * Eclipse环境
 * 
 * @author Administrator
 *
 */
public class Eclipse extends Environment {
	public Eclipse() {
	}

	public Eclipse(String name) {
		super(name);
	}

	/**
	 * 点击F1按键后
	 */
	public void afterClickF1() {
		System.out.println(getName() + "中，点击F1弹出Help帮助窗口");
	}
}
