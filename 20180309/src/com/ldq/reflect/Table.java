package com.ldq.reflect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ע�������ݿ��ӳ���ʵ����
 * 
 * @author Administrator
 *
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Table {
	/**
	 * ָ��ӳ��������
	 * @return
	 */
	String value();
}
