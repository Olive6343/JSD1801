package com.entor.exception;

import java.lang.instrument.IllegalClassFormatException;

public class ExceptionTest {

	public static void main(String[] args)  {
		//运行时异常：
//		throw new RuntimeException("运行时异常");// 运行时异常不强制要求处理
		try {
			throw new IllegalClassFormatException("参数异常");
		} catch (IllegalClassFormatException e) {
			e.printStackTrace();
		}// 非运行时异常强制使用者必须做出采取措施
		System.out.println("哎哟，还可以运行！");
	}
}
