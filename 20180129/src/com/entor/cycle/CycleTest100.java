package com.entor.cycle;

/**
 * 课堂练习：打印九九表
 *  ☆☆☆☆ 
 * ☆☆☆☆☆☆☆☆☆☆☆
 *  ☆
 *   
 */
public class CycleTest100 {

	public static void main(String[] args) {
//		fenge();
        /*打印正方形*/
        for(int i = 1;i <=5;i++) {
            for(int j = 1; j<=10;j++) {
                System.out.print("*");
            }
            System.out.println("");//换行
        }
//        fenge();
        /*打印平行四边形*/
        for(int i = 1;i <= 5;i++) {
            for(int j = 1;j <=i;j++) {
                System.out.print(" ");
            }
            for(int k = 1;k <=15;k++) {
                System.out.print("*");
            }
            System.out.println();
        }
//        fenge();
        /*打印菱形*/
        for(int i = 5;i >=1;i--){
            for(int j = 1;j <=i;j++) {
                System.out.print(" ");
            }
            for(int k =9;k >=(2*i)-1;k--) {
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i = 1;i <=4;i++){
            for(int j = 1;j <=i+1;j++) {
                System.out.print(" ");
            }
            for(int k =7;k >=(2*i)-1;k--) {
                System.out.print("*");
            }
            System.out.println();
        }
	}
}
