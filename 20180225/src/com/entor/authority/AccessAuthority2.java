package com.entor.authority;

public class AccessAuthority2 {

	public static void main(String[] args) {
		AccessAuthority aa = new AccessAuthority();
		aa.a_private();// 不被同包的类访问
		aa.a_protected();
		aa.a_public();
		aa.test();
		
	}
}
