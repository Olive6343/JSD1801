package com.ldq.reflect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ע���Ա����ӳ�䵽�ı���ֶ�
 * @author Administrator
 *
 */
@Retention(RetentionPolicy.RUNTIME)// ������ע��
@Target(ElementType.FIELD)// ֻ�����������Ϸ�
public @interface Column {
	String value(); // ����ֶ�����
}
