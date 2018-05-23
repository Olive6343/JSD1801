package com.entor.bms.view;

import com.entor.bms.entity.UserInfo;
import com.entor.bms.service.UserService;
import com.entor.bms.service.impl.UserServiceImpl;
import com.entor.bms.utils.LoginStatusEnum;
import com.entor.bms.view.book.QueryBookView;
import com.entor.bms.view.user.AdminView;

import java.util.Scanner;

public class IndexView {
    private Scanner sc = new Scanner(System.in);
    private UserService userService = new UserServiceImpl();
    private UserInfo userInfo;

    public IndexView() {
        // 欢迎页面
        welcome();
    }

    /**
     * 欢迎页
     */
    private void welcome() {
        System.out.println("+++++欢迎使用图书馆里系统+++++");
        System.out.println("+++++1.用户注册                  +++++");
        System.out.println("+++++2.登录系统                  +++++");
        System.out.println("+++++3.退出系统                  +++++");

        while (true) {
            System.out.println("请输入选项：");
            String option = sc.next();
            if ("1".equals(option)) {// 跳转注册页
                register();
                return;
            }

            if ("2".equals(option)) {// 跳转登录页
                login();
                return;
            }

            if ("3".equals(option)) {// 退出系统
                System.exit(0);
            }

            System.out.println("请输入正确的选项！");
        }
    }

    /**
     * 登录界面
     */
    private void login() {
        System.out.println("+++++登录页面+++++");
        int count = 0;// 计数器
        while (true) {
            System.out.println("请输入证件号：");
            String idCard = sc.next();
            System.out.println("请输入密码：");
            String password = sc.next();

            // 验证用户的证件和密码
            // 考虑到用户状态，返回的结果除了证件或密码不匹配、登录成功
            // 还至少应该有一个对于冻结状态的提示
            if (LoginStatusEnum.OK == userService.loginValidate(idCard, password)) {
                turnWithUserInfo(idCard);
                return;
            } else if (LoginStatusEnum.FAILURE == userService.loginValidate(idCard, password)) {
                System.out.println("证件/密码不匹配，请重新输入！");
                count++;
            } else {
                System.out.println("该用户已被冻结，不可使用！");
                welcome();
                return;
            }

            if (count == 3) {
                welcome();
                return;
            }
        }

    }

    /**
     * 注册
     */
    private void register() {
        System.out.println("+++++注册页面+++++");
        System.out.println("请输入姓名：");
        String name = sc.next();
        System.out.println("请输入密码：");
        String password = sc.next();
        String idCard = "";
        while (true) {
            System.out.println("请输入证件号：");
            idCard = sc.next();

            // 验证证件号唯一
            if (!userService.isIdCardOnlyOne(idCard))
                break;
            else
                System.out.println("该证件号已被使用，请重新输入！");
        }

        // 数据封装到对象
        UserInfo userInfo = new UserInfo();
        userInfo.setIdCard(idCard);
        userInfo.setName(name);
        userInfo.setPassword(password);

        // 保存数据对象
        userService.saveUser(userInfo);
        System.out.println("注册成功！");

        welcome();// 回到主页
        return;
    }

    /**
     * 根据用户的状态，决定跳转方向
     *
     * @param idCard
     */
    private void turnWithUserInfo(String idCard) {
        // 通过idCard查询到当前用户信息
        userInfo = userService.getUserInfoByIdCard(idCard);
        if (userInfo == null) {
            System.out.println("请先登录...");
            welcome();
            return;
        }

        System.out.println("+++++欢迎" + userInfo.getName() + "使用图书管理系统+++++");
        // 根据status显示指定的页面
        if (userInfo.getStatus() == 1) {
            new QueryBookView(userInfo);// 普通用户界面
            return;
        }
        new AdminView(userInfo);// 管理员用户界面
    }
}
