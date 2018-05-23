package com.entor.polymorphism;

public class SingleChoice extends Question{


	private String[] options; // ѡ��
	private char[] answer;  // ��ѡ��׼��
	
	public SingleChoice(){
	}
	public SingleChoice(String text, String[] options, char[] answer) {
		super(text);
		this.options = options;
		this.answer = answer;
	}

	public String[] getOptions() {
		return options;
	}

	public void setOptions(String[] options) {
		this.options = options;
	}

	public char[] getanswer() {
		return answer;
	}

	public void setanswer(char[] answer) {
		this.answer = answer;
	}
	
	/**
	 * 重写父类的check方法，判断单选题用户答案正确与否
	 */
	@Override
	public boolean check(char[] answers) {
		if(answers.equals(null) || answers.length != 1)
			return false;
		return true;
	}

	
}
