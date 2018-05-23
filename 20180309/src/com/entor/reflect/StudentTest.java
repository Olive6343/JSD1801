package com.entor.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Date;

public class StudentTest {
    public static String getSQL(Object object) throws  Exception{
        // 通过注解方式获得查询语句
        StringBuilder buffer = new StringBuilder();

        // 1.扫描指定实体
        //Class clazz = com.entor.reflect.Student.class;
        //Object obj = clazz.newInstance();
        // 查询某对象的所有值

        // 2.定位Table注解，获得注解的值
        Class clazz = object.getClass();
        Annotation annotation = clazz.getDeclaredAnnotation(Table.class);
        if (annotation != null) {
            Table table = (Table) annotation;
            String tableName = table.value();// 获得到表明
            buffer.append("select * from ").append(tableName).append(" where 1 = 1 ");

            // 3.定位Column注解，获得注解的值
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
        student.setName("张三");
        student.setSno(123);
        student.setBirth(new Date());
        student.setAdmissionDate(new Date());
        student.setNote("aaaaa");
        System.out.println("Student查询语句：" + getSQL(student));
    }
}
