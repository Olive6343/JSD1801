package com.entor.authority;

public class SPAccessAuthority extends AccessAuthority{

	public static void main(String[] args) {
		AccessAuthority aa = new AccessAuthority();
		aa.a_private();// ����ͬ����������ʣ�˽�����Բ����̳�
		aa.a_protected();
		aa.a_public();
		aa.test();
		
	}
}
