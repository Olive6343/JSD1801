package com.entor.authority;

public class AccessAuthority {

	private String v_private = "˽��";
	String v_default = "Ĭ��";
	protected String v_protected = "������";
	public String v_public = "����";
	
	
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
		System.out.println("public ��������");
	}
	
	private void a_private(){
		System.out.println("private ��������");
	}
	protected void a_protected(){
		System.out.println("protected ��������");
	}
	
	public void test(){
		a_protected();
	}
}
