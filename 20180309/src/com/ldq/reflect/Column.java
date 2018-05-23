package com.ldq.reflect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解成员变量映射到的表的字段
 * @author Administrator
 *
 */
@Retention(RetentionPolicy.RUNTIME)// 运行期注解
@Target(ElementType.FIELD)// 只能用在属性上方
public @interface Column {
	String value(); // 表的字段名称
}
