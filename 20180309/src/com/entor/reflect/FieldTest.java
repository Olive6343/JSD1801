package com.entor.reflect;

import java.lang.reflect.Field;

public class FieldTest {
    public static void main(String[] args) throws Exception {
        //Student属性组
        Class clazz = Student.class;
        //  Field[] fields = clazz.getFields();// 只能访问公共字段
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        // 对name属性赋值
        Field name = clazz.getDeclaredField("name");
        Object obj = clazz.newInstance();
        // 压制访问权限
        name.setAccessible(true);
        name.set(obj, "王老五");
        System.out.println(((Student) obj).getName());
    }
}
