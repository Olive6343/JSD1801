package com.liangdiquan.identifier;

public class IdentifierTest {

	public static void main(String[] args) {
//		int x,y,z = 100;//x,yֻ��������z��������ֵ100
//		int a = 100,b,c;//ͬ�ϣ�a��ֵ100
//		int i = 100,j=100,k=100;//
//		int l=m=n=10;����
		
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
		System.out.println("��ǿո�"+ (int)' ');
		System.out.println("str�ĳ��ȣ�"+ str.length());
		//ȥ����λ�ո�
		System.out.println("ȥ����λ�ո�"+ str.trim());
		//�滻�ո�
		System.out.println("�滻�ո�"+ str.replaceAll(" ", ""));
		//�Ƚ������ַ����Ƿ����equals
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
		
		//�����ַ���������������ֵ
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
