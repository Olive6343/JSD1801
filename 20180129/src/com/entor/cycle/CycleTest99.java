package com.entor.cycle;

/**
 * øŒÃ√¡∑œ∞£∫¥Ú”°æ≈æ≈±Ì
 * 
 * @author Administrator
 *
 */
public class CycleTest99 {

	public static void main(String[] args) {
		int i = 1;
		//int j = 1;
		for(;i<10;i++){
			for(int j=1;j<=i;j++){
				System.out.print(i + "*" + j + "=" + i*j + "\t") ;
			}
			System.out.println();
		}
	}
}
