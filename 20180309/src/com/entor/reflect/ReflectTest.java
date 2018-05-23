package com.entor.reflect;

import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * ���ݼ���¼��ָ����Ҫ�����Ķ������Ҫ���õķ���<br>
 * ���÷������
 * Class��API����������Ļ�����Ϣ���������飬��������
 * Field��API�����������ĳ�����ԵĻ�����Ϣ�����η������ͣ�������������ֵ
 * Method��API�����������ĳ�������������췽���⣩�Ļ�����Ϣ�����η�������ֵ���ͣ��������������б�
 * Constructor��API�����������ĳ�����캯���Ļ�����Ϣ�����η����������������б�
 * Type��API��������һ������
 * Annotation��API��������ע��Ļ�����Ϣ
 */
public class ReflectTest {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        // 1.¼��Ҫ�����Ķ��������
        System.out.println("������Ҫ�����Ķ�������ƣ����Ƽ�ȫ����");
        String className = sc.nextLine();
        // 2.��̬��������
        // ÿһ����ֻ��һ��Class����ÿһ���������������ʵ������
        Class clazz = Class.forName(className);// ͨ��ָ�����ͣ�������Class����
        Object obj = clazz.newInstance();// ͨ��Class����Ϊ�ഴ��һ��ʵ������
        // 3.¼��Ҫ���õĶ��󷽷�
        System.out.println("������Ҫ�����Ķ���ķ������ƣ�");
        String methodName = sc.nextLine();
        // 4.��̬���÷���
        // ͨ��Class����ͷ�������ø���ͬ������
        Method method = clazz.getDeclaredMethod(methodName, null);
        Object result = method.invoke(obj, null);

        System.out.println("������" + className + "��" + methodName + "()�������õ������" + result);
    }
}
