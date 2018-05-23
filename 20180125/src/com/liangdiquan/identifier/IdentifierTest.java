package com.liangdiquan.identifier;

public class IdentifierTest {

	public static void main(String[] args) {
//		int x,y,z = 100;//x,y只是声明，z声明并赋值100
//		int a = 100,b,c;//同上，a赋值100
//		int i = 100,j=100,k=100;//
//		int l=m=n=10;错误
		
//		System.out.println("z"+ z);
//		System.out.println("a"+ a);
//		System.out.println("i,j,k"+ k);
		
		byte byte1= 127;
		int int1 = byte1;
		System.out.println(int1);
		
		int int2= 23;
		byte byte2 = (byte)int2;
		System.out.println(byte2);
		
		String str = "     a c v   ";
		System.out.println("半角空格："+ (int)' ');
		System.out.println("str的长度："+ str.length());
		//去掉首位空格
		System.out.println("去掉首位空格："+ str.trim());
		//替换空格
		System.out.println("替换空格："+ str.replaceAll(" ", ""));
		//比较两个字符串是否相等equals
		System.out.println("acv".equals(str));
		System.out.println(str.equals("acv"));
		System.out.println("acv".equals(str.replace(" ", "")));
		
		
		
//		int a=1,b=2;
//		System.out.println("a+=b =>" + (a+=b));
//		System.out.println("b+=a =>" + (b+=a));
//		System.out.println("a=" + a);
//		System.out.println("b=" + b);
//		
//		System.out.println("a-=b =>" + (a-=b));
//		System.out.println("b-=a =>" + (b-=a));
//		System.out.println("a=" + a);
//		System.out.println("b=" + b);
		
		//用两种方法交换两个数的值
		int a = 99,b=2;
		a=a+b;
		b=a-b;
		a=a-b;
		System.out.println(a);
		System.out.println(b);
		
		int  c= 10,d=20;
		int temp;
		temp = c;
		d = a;
		a = temp;
		System.out.println(c);
		System.out.println(d);
		
//		boolean bool =true;
//		System.out.println(bool.);
		
		
				
	}
}
