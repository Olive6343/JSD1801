package com.entor.variable;

import com.entor.authority.AccessAuthority;

public class AccessAuthority3 {

	public static void main(String[] args) {
		AccessAuthority aa = new AccessAuthority();
		System.out.println(aa.v_private);// 不被不同包的类访问
		System.out.println(aa.v_default);// 不被不同包的类访问
		System.out.println(aa.v_protected);// 不被不同包的类访问
		System.out.println(aa.v_public);
	}
	
}
