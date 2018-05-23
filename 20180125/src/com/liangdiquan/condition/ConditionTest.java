package com.liangdiquan.condition;

public class ConditionTest {

	public static void main(String[] args) {
		
		double scroe = -20;
		if(scroe>=0 && scroe<=59.5){
			System.out.println("不及格！");
		}else if(scroe>=60 && scroe<=79.5){
			System.out.println("及格！");
		}else if(scroe>=80 && scroe<=89.5){
			System.out.println("良好！");
		}else if(scroe>=90 && scroe<=100){
			System.out.println("优秀！");
		}else{
			System.out.println("成绩不合理！");
		}
		
	}
}
