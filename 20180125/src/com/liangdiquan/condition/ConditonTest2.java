package com.liangdiquan.condition;

public class ConditonTest2 {

	public static void main(String[] args) {
		//12,1,2����   3,4,5����   6,7,8�ļ�   9,10,11�＾
		int month = 1;
		
		
		if(month>=3 && month <=5){
			System.out.println("����");
		}else if(month>=3 && month <=5){
			System.out.println("�ļ�");
		}else if(month>=3 && month <=5){
			System.out.println("�＾");
		}else if(month==12 || month ==1 || month ==2){
			System.out.println("����");
		}else{
			System.out.println("�·ݱ�����1--12֮�䣡");
		}
		
		switch (month) {
		case 12:
		case 1:
		case 2:
			System.out.println("����");
			break;
		case 3:
		case 4:
		case 5:
			System.out.println("����");
			break;
		case 6:
		case 7:
		case 8:
			System.out.println("�ļ�");
			break;
		case 9:
		case 10:
		case 11:
			System.out.println("�＾");
			break;

		default:
			System.out.println("�·ݱ�����1--12֮�䣡");
			break;
		}
	}
	
}
