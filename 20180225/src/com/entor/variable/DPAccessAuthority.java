package com.entor.variable;

import com.entor.authority.AccessAuthority;

public class DPAccessAuthority extends AccessAuthority{

	public static void main(String[] args) {
		AccessAuthority aa = new AccessAuthority();
		aa.a_private();// 不被不同包的子类访问，私有属性不被继承
		aa.a_protected();// 不被不同包的子类访问，私有属性不被继承
		aa.a_public();
		aa.test();
		
	}
}
