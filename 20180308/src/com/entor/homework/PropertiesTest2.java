package com.entor.homework;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropertiesTest2 {
    public static void main(String[] args) throws Exception {
        // 1.键盘录入帐号
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入帐号：");
        String username = br.readLine();

        // 2.读取properties文件，生成属性列表对象
        Properties properties = new Properties();
        properties.load(new FileInputStream("user.properties"));

        // 3.判断输入帐号是否存在
        if (properties.getProperty(username) == null) {// 帐号不存在
            System.out.println("请输入金额：");
            String money = br.readLine();
            properties.setProperty(username, money);

            properties.store(new FileOutputStream("user.properties"), "写新的属性列表");

        } else {
            System.out.println(username + "账户余额：" + properties.getProperty(username));
        }
    }
}
