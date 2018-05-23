package com.entor.reflect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解与数据库表映射的实体类
 */
@Retention(RetentionPolicy.RUNTIME)// 运行期注解
@Target(ElementType.TYPE)// 只允许声明在类上方
public @interface Table {
    /**
     * 指定映射表的名称
     *
     * @return
     */
    String value();
}
