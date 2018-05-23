package com.entor.polymorphism;

/**
 * Chrome浏览器
 * 
 * @author Administrator
 *
 */
public class Chrome extends Environment {
	public Chrome() {
	}

	public Chrome(String name) {
		super(name);
	}

	/**
	 * 点击F1按键后
	 */
	public void afterClickF1() {
		System.out.println(getName() + "中，点击F1弹出新网页https://support.google.com/chrome/?p=help&ctx=keyboard");
	}
}
