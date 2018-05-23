package com.entor.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Date;

public class StudentTest {
    public static String getSQL(Object object) throws  Exception{
        // ͨ��ע�ⷽʽ��ò�ѯ���
        StringBuilder buffer = new StringBuilder();

        // 1.ɨ��ָ��ʵ��
        //Class clazz = com.entor.reflect.Student.class;
        //Object obj = clazz.newInstance();
        // ��ѯĳ���������ֵ

        // 2.��λTableע�⣬���ע���ֵ
        Class clazz = object.getClass();
        Annotation annotation = clazz.getDeclaredAnnotation(Table.class);
        if (annotation != null) {
            Table table = (Table) annotation;
            String tableName = table.value();// ��õ�����
            buffer.append("select * from ").append(tableName).append(" where 1 = 1 ");

            // 3.��λColumnע�⣬���ע���ֵ
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.getAnnotation(Column.class) != null) {
                    Object fieldValue = field.get(object);
                    if (fieldValue instanceof java.lang.String) {
                        buffer.append(" and ").append(field.getAnnotation(Column.class).value())
                                .append(" = '").append(fieldValue).append("'");
                    } else {
                        buffer.append(" and ").append(field.getAnnotation(Column.class).value()).append(" = ").append(fieldValue);
                    }
                }
            }
        }
        return buffer.toString();
    }

    public static void main(String[] args) throws Exception {
        Student student = new Student();
        student.setName("����");
        student.setSno(123);
        student.setBirth(new Date());
        student.setAdmissionDate(new Date());
        student.setNote("aaaaa");
        System.out.println("Student��ѯ��䣺" + getSQL(student));
    }
}
