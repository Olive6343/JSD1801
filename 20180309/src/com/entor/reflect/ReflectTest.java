package com.entor.reflect;

import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * 根据键盘录入指定需要创建的对象和需要调用的方法<br>
 * 利用反射机制
 * Class的API用来描述类的基本信息：方法数组，属性数组
 * Field的API用来描述类的某个属性的基本信息：修饰符，类型，属性名，属性值
 * Method的API用来描述类的某个方法（除构造方法外）的基本信息：修饰符，返回值类型，方法名，参数列表
 * Constructor的API用来描述类的某个构造函数的基本信息：修饰符，函数名，参数列表
 * Type的API用来描述一切类型
 * Annotation的API用来描述注解的基本信息
 */
public class ReflectTest {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        // 1.录入要创建的对象的名称
        System.out.println("请输入要创建的对象的名称：（推荐全名）");
        String className = sc.nextLine();
        // 2.动态创建对象
        // 每一个类只有一个Class对象，每一个类可以有无数个实例对象
        Class clazz = Class.forName(className);// 通过指定类型，获得类的Class对象
        Object obj = clazz.newInstance();// 通过Class对象，为类创建一个实例对象
        // 3.录入要调用的对象方法
        System.out.println("请输入要创建的对象的方法名称：");
        String methodName = sc.nextLine();
        // 4.动态调用方法
        // 通过Class对象和方法名获得该类同名方法
        Method method = clazz.getDeclaredMethod(methodName, null);
        Object result = method.invoke(obj, null);

        System.out.println("调用了" + className + "的" + methodName + "()方法，得到结果：" + result);
    }
}
