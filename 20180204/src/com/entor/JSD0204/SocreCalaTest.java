package com.entor.JSD0204;


/**
 * �ɼ������������
 * 
 * @author Administrator
 *
 */
public class SocreCalaTest {

	public static void main(String[] args) {

		//��������
		
//		ScoreCalc sc = new ScoreCalc(80,95,80);

		ScoreCalc sc = new ScoreCalc();
		sc.setJava(80);
		sc.setC(95);
		sc.setDb(80);
		sc.showAvg();
		sc.showSum();
		
		System.out.println(sc.toString());
	}
}
