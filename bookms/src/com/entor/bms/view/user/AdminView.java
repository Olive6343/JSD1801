package com.entor.bms.view.user;

import com.entor.bms.entity.UserInfo;
import com.entor.bms.view.IndexView;
import com.entor.bms.view.book.BookManagerView;

import java.util.Scanner;

public class AdminView {
    private Scanner sc = new Scanner(System.in);
    private UserInfo userInfo;

    public AdminView(UserInfo userInfo) {
        this.userInfo = userInfo;
        admin();
    }

    /**
     * 管理员界面
     */
    private void admin() {
        System.out.println("++++++++管理员界面++++++++");
        System.out.println("+++++1.用户管理             +++++");
        System.out.println("+++++2.书籍管理             +++++");
        System.out.println("+++++3.返回上层             +++++");
        while (true) {
            System.out.println("请输入选项：");
            String option = sc.next();
            if ("1".equals(option)) {// 用户管理
                new UserManagerView(userInfo);
                return;
            }

            if ("2".equals(option)) {// 书籍管理
                new BookManagerView(userInfo);
                return;
            }
            if ("3".equals(option)) {// 返回上一层
                new IndexView();
                return;
            }
            System.out.println("请输入正确的选项！");
        }
    }
}
