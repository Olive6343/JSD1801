package com.entor.exception;

import java.lang.instrument.IllegalClassFormatException;

public class ExceptionTest2 {
	// 抛出的异常是将相关信息交给调用端处理
	
	public static void throRuntime(){
		throw new RuntimeException("运行时异常！");
	}

	public static void throwTryCatch(){
		try {
			throw new IllegalClassFormatException();
		} catch (IllegalClassFormatException e) {
			e.printStackTrace(); // 输出异常信息
		}
	}
	
	public static void throwIllegal() throws IllegalClassFormatException{
		throw new IllegalClassFormatException("通过关键字throw抛出异常信息");
	}
	
	
	public static void main(String[] args)  {
		throwTryCatch();
		System.out.println("真的还可以运行啊!");
//		String
	}
}
