package com.entor.polymorphism;

/**
 * 编辑器环境
 * 
 * @author Administrator
 *
 */
public class Environment {
	private String name;// 编辑器名称

	public Environment() {
	}

	public Environment(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 点击F1按键后
	 */
	public void afterClickF1() {
	}
}
