package com.entor.test;

import java.util.Scanner;

public class Calculator {

	public  static void mulTwoNumber(double num1,double num2,double num3){
		System.out.println("nu1m" + "*" + "num2" + "*" + "num3"+ "=" + num1*num2*num3);
	}
	
	public static double divTwoNumber(double num1,double num2){
		return num1/num2;
	}
	
	
	
	
	public static double fiveOperateTwoNumber(double num1,double num2,String operator){
		
		Scanner ss =new Scanner(System.in);
		double add;
		double sub;
		double mul;
		double div;
		double mod;
		double s=0;
		
		add = num1 + num2;
		sub = num1 - num2;
		mul = num1 * num2;
		div = divTwoNumber(num1, num2);
		mod = num1 % num2;
		
	/*	if(operator == "+"){
			return add;
		}else if(operator == "-"){
			return sub;
		}else if(operator == "*"){
			return mul;
		}else if(operator == "/"){
			return div;
		}else if(operator == "%"){
			return mod;
		}else 
			return add;*/
		
//		operator = "+";
		switch (operator) {
		case "+":
			s=add;
			break;
		case "-":
			s=add;
			break;
		case "*":
			s=add;
			break;
		case "/":
			s=add;
			break;
		case "%":
			s=add;
			break;

		default:
			break;
		}
		return s;
	
	}
	
	
	public static void main(String[] args) {
		mulTwoNumber(1, 2,5);
		double d1= divTwoNumber(2, 4);
		System.out.println(d1);
		double d2= fiveOperateTwoNumber(3, 5,"8");
		System.out.println(d2);
	}
	
	
	
}
