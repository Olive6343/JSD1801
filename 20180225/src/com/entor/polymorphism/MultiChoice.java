package com.entor.polymorphism;

import java.util.Arrays;

public class MultiChoice extends Question{

	private String[] options; // 选项
	private char[] answers;  // 多选标准答案
	
	public MultiChoice(){
	}
	public MultiChoice(String text, String[] options, char[] answers) {
		super(text);
		this.options = options;
		this.answers = answers;
	}

	public String[] getOptions() {
		return options;
	}

	public void setOptions(String[] options) {
		this.options = options;
	}

	public char[] getAnswers() {
		return answers;
	}

	public void setAnswers(char[] answers) {
		this.answers = answers;
	}
	
	/**
	 * 重写父类的check方法
	 */
	@Override
	public boolean check(char[] answers) {
		return Arrays.equals(this.answers, answers);
	}

	
	
	
}
