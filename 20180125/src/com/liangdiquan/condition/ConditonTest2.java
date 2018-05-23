package com.liangdiquan.condition;

public class ConditonTest2 {

	public static void main(String[] args) {
		//12,1,2¶¬¼¾   3,4,5´º¼¾   6,7,8ÏÄ¼¾   9,10,11Çï¼¾
		int month = 1;
		
		
		if(month>=3 && month <=5){
			System.out.println("´º¼¾");
		}else if(month>=3 && month <=5){
			System.out.println("ÏÄ¼¾");
		}else if(month>=3 && month <=5){
			System.out.println("Çï¼¾");
		}else if(month==12 || month ==1 || month ==2){
			System.out.println("¶¬¼¾");
		}else{
			System.out.println("ÔÂ·Ý±ØÐëÔÚ1--12Ö®¼ä£¡");
		}
		
		switch (month) {
		case 12:
		case 1:
		case 2:
			System.out.println("¶¬¼¾");
			break;
		case 3:
		case 4:
		case 5:
			System.out.println("´º¼¾");
			break;
		case 6:
		case 7:
		case 8:
			System.out.println("ÏÄ¼¾");
			break;
		case 9:
		case 10:
		case 11:
			System.out.println("Çï¼¾");
			break;

		default:
			System.out.println("ÔÂ·Ý±ØÐëÔÚ1--12Ö®¼ä£¡");
			break;
		}
	}
	
}
