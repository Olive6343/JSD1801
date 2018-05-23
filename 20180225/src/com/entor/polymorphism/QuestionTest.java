package com.entor.polymorphism;

public class QuestionTest {

	public static void main(String[] args) {
		Question[] q = new Question[2];
		q[0] = new MultiChoice("下列哪些是电子产品？",new String[]{"A.电脑","B.电子手表","C.篮球","D.计算器"},new char[]{'A','B','D'});
		q[1] = new SingleChoice("小明的血型是？", new String[] { "A.A型", "B.B型","C.AB型","D.O型"},new char[]{'A'});
		
		
		
	}
}
