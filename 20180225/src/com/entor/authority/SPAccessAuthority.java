package com.entor.authority;

public class SPAccessAuthority extends AccessAuthority{

	public static void main(String[] args) {
		AccessAuthority aa = new AccessAuthority();
		aa.a_private();// 不被同包的子类访问，私有属性不被继承
		aa.a_protected();
		aa.a_public();
		aa.test();
		
	}
}
