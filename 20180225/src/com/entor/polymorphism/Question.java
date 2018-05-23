package com.entor.polymorphism;

/**
 * 考题类
 * @author Administrator
 *
 */
public class Question {

	private String text;// 题干
	public Question(){
	}
	
	public Question(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	/**
	 * 检测标准答案
	 */
	public boolean check(char[] answers){
		
		return true;
	}
}
