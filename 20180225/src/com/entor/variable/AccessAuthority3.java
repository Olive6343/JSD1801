package com.entor.variable;

import com.entor.authority.AccessAuthority;

public class AccessAuthority3 {

	public static void main(String[] args) {
		AccessAuthority aa = new AccessAuthority();
		System.out.println(aa.v_private);// ������ͬ���������
		System.out.println(aa.v_default);// ������ͬ���������
		System.out.println(aa.v_protected);// ������ͬ���������
		System.out.println(aa.v_public);
	}
	
}
