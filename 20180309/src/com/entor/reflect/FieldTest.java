package com.entor.reflect;

import java.lang.reflect.Field;

public class FieldTest {
    public static void main(String[] args) throws Exception {
        //Student������
        Class clazz = Student.class;
        //  Field[] fields = clazz.getFields();// ֻ�ܷ��ʹ����ֶ�
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        // ��name���Ը�ֵ
        Field name = clazz.getDeclaredField("name");
        Object obj = clazz.newInstance();
        // ѹ�Ʒ���Ȩ��
        name.setAccessible(true);
        name.set(obj, "������");
        System.out.println(((Student) obj).getName());
    }
}
