package com.entor.authority;

public class AccessAuthority {

	private String v_private = "私有";
	String v_default = "默认";
	protected String v_protected = "被保护";
	public String v_public = "共有";
	
	
	public static void main(String[] args) {
		AccessAuthority aa = new AccessAuthority();
		System.out.println(aa.v_private);
		System.out.println(aa.v_default);
		System.out.println(aa.v_protected);
		System.out.println(aa.v_public);
		
	}
	
	public void a_public(){
		System.out.println(v_default);
		String variavle2 = v_default;
		System.out.println("public 被访问了");
	}
	
	private void a_private(){
		System.out.println("private 被访问了");
	}
	protected void a_protected(){
		System.out.println("protected 被访问了");
	}
	
	public void test(){
		a_protected();
	}
}
