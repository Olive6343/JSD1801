package com.entor.variable;

import com.entor.authority.AccessAuthority;

public class DPAccessAuthority extends AccessAuthority{

	public static void main(String[] args) {
		AccessAuthority aa = new AccessAuthority();
		aa.a_private();// ������ͬ����������ʣ�˽�����Բ����̳�
		aa.a_protected();// ������ͬ����������ʣ�˽�����Բ����̳�
		aa.a_public();
		aa.test();
		
	}
}
