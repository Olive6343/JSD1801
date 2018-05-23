package com.entor.bms.view.user;

import com.entor.bms.entity.UserInfo;
import com.entor.bms.service.UserService;
import com.entor.bms.service.impl.UserServiceImpl;
import com.entor.bms.utils.UserStatusEnum;

import java.util.List;
import java.util.Scanner;

public class UserManagerView {
    private Scanner sc = new Scanner(System.in);
    private UserService userService = new UserServiceImpl();
    private UserInfo userInfo;

    public UserManagerView(UserInfo userInfo) {
        this.userInfo = userInfo;

        // 初始化用户管理页面
        init();
    }

    /**
     * 用户管理初始页面
     */
    private void init() {
        System.out.println("+++++++++用户管理页面+++++++++");
        System.out.println("+++++1.查询                           +++++");
        System.out.println("+++++2.增加                           +++++");
        System.out.println("+++++3.修改                           +++++");
        System.out.println("+++++4.删除                           +++++");
        System.out.println("+++++5.返回上一层                 +++++");
        while (true) {
            System.out.println("请输入选项：");
            String option = sc.next();
            if ("1".equals(option)) {// 查询
                query();
                return;
            }

            if ("2".equals(option)) {// 增加
                userAdd();
                return;
            }
            if ("3".equals(option)) {// 更新
                userUpdate();
                return;
            }
            if ("4".equals(option)) {// 删除
                userDeleteView();
                return;
            }
            if ("5".equals(option)) {// 返回上一层
                new AdminView(userInfo);
                return;
            }
            System.out.println("请输入正确的选项！");
        }
    }


    /**
     * 用户查询页面
     */
    private void query() {
        System.out.println("+++++++++查询页面+++++++++");
        System.out.println("+++++1.通过证件查询      +++++");
        System.out.println("+++++2.通过状态查询      +++++");
        System.out.println("+++++3.查询全部用户      +++++");
        System.out.println("+++++4.姓名搜索用户      +++++");
        System.out.println("+++++5.返回上一层          +++++");
        while (true) {
            System.out.println("请输入选项：");
            String option = sc.next();
            if ("1".equals(option)) {// 证件查询
                System.out.println("请输入证件号：");
                UserInfo userInfo = userService.getUserInfoByIdCard(sc.next());
                if (userInfo == null) {
                    System.out.println("没有相关的用户信息！");
                } else {
                    System.out.println(userInfo);
                }
                query();
                return;
            }

            if ("2".equals(option)) {// 状态查询
                UserStatusEnum userStatusEnum = UserStatusEnum.FROZEN;
                System.out.println("请输入状态：");
                switch (sc.next()) {
                    case "冻结":
                        userStatusEnum = UserStatusEnum.FROZEN;
                        break;
                    case "普通用户":
                        userStatusEnum = UserStatusEnum.COMMON;
                        break;
                    case "管理员":
                        userStatusEnum = UserStatusEnum.ADMIN;
                        break;
                }
                List<UserInfo> list = userService.getUserInfoByStatus(userStatusEnum);
                if (list != null && list.size() > 0) {
                    list.forEach(userInfo -> {
                        System.out.println(userInfo);
                    });
                } else {
                    System.out.println("没有相关用户信息！");
                }
                query();
                return;
            }
            if ("3".equals(option)) {//  全部用户
                List<UserInfo> list = userService.getAllUsers();
                if (list != null && list.size() > 0) {
                    list.forEach(userInfo -> {
                        System.out.println(userInfo);
                    });
                } else {
                    System.out.println("没有相关用户信息！ ");
                }
                query();
                return;
            }
            if ("4".equals(option)) {//  姓名搜索
                System.out.println("请输入姓名：");
                List<UserInfo> list = userService.searchUserInfoByName(sc.next());
                if (list != null && list.size() > 0) {
                    list.forEach(userInfo -> {
                        System.out.println(userInfo);
                    });
                } else {
                    System.out.println("没有相关用户信息！");
                }
                query();
                return;
            }
            if ("5".equals(option)) {//  返回上一层
                new AdminView(userInfo);
                return;
            }
            System.out.println("请输入正确的选项！");
        }
    }

    /**
     * 添加用户
     */
    private void userAdd() {
        System.out.println("请输入姓名：");
        String name = sc.next();
        String idCard = null;
        for (; ; ) {
            System.out.println("请输入证件号：");
            idCard = sc.next();

            // 验证证件号唯一
            if (!userService.isIdCardOnlyOne(idCard))
                break;
            else
                System.out.println("该证件号已被使用，请重新输入！");
        }

        // 创建UserInfo对象
        UserInfo userInfo = new UserInfo();
        userInfo.setName(name);
        userInfo.setIdCard(idCard);

        userService.addUser(userInfo);

        System.out.println("添加成功！");
        init();
    }

    /**
     * 更新用户信息
     */
    private void userUpdate() {
        System.out.println("+++++用户更新页面+++++");
        System.out.println("请输入有效证件：");
        String idCard = sc.next();
        UserInfo userInfo;
        if ((userInfo = userService.getUserInfoByIdCard(idCard)) == null) {
            System.out.println("没有该用户！");
            init();
            return;
        }

        UserInfo u = new UserInfo();
        u.setIdCard(userInfo.getIdCard());
        System.out.println("请输入姓名：（j跳过）");
        String name;
        if (!"j".equalsIgnoreCase((name = sc.next()))) {
            u.setName(name);
        }
        System.out.println("请输入密码：（j跳过）");
        String password;
        if (!"j".equalsIgnoreCase((password = sc.next()))) {
            u.setPassword(password);
        }
        System.out.println("请输入状态：（j跳过）");

        String status = sc.next();
        while (true) {
            if (!"j".equalsIgnoreCase((status))) {
                if (!"0".equals(status) && !"1".equals(status) && !"2".equals(status)) {
                    break;
                }
                u.setStatus(Integer.parseInt(status));
            }
        }
        userService.updateUserInfoByIdCard(u);

        System.out.println("更新成功！");
        init();
    }

    private void userDeleteView() {
    }
}
