package com.ldq.test4;

public class abc implements aa{
	
	public static void main(String[] args) {
		// System.out.println("value="+switchIt(4)); //µÚ3ÐÐ
		int k = 0;
		label: for (int i = 1; i < 3; i++) {
			for (int j = 1; j < 3; j++) {
				k += i + j;// k = k+(i+j) =
							// 0+1+1,=2+1+2,=5+1+3,=8+2+1,=11+3+1,=15+3+2,=20+3+3
				System.out.println(k);
//				if (i == 2)
//					continue label;
				System.out.println("k2:"+k);
			}
		}
		System.out.println(k);
		
		
		int m,n;
		abc t=new abc();
		  m=t.k;
		  n=aa.k;
		  System.out.println(m+","+n);
		  }

}
