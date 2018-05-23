package com.entor.reflect;

import java.lang.reflect.Constructor;
import java.util.Arrays;

public class ConstructorTest {
    public static void main(String[] args) throws Exception {
        // String�Ĺ�����
        Class clazz = new String().getClass();
        Constructor[] constructors = clazz.getConstructors();
        /*for (Constructor constructor : constructors) {
            System.out.println((constructor.getModifiers() == 1 ? "public" : "") + "  "
                    + constructor.getName() + "  " + Arrays.toString(constructor.getParameters()));
        }*/
        // ���String(String str)����
        Constructor constructor = clazz.getConstructor(new Class[]{java.lang.String.class});
        System.out.println(constructor);
    }
}
