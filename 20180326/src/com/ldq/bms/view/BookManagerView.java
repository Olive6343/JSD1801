package com.ldq.bms.view;

import java.util.List;
import java.util.Scanner;

import com.ldq.bms.entity.BookInfo;
import com.ldq.bms.entity.UserInfo;
import com.ldq.bms.service.BookService;
import com.ldq.bms.service.UserService;
import com.ldq.bms.service.impl.BookServiceImpl;
import com.ldq.bms.service.impl.UserServiceImpl;

public class BookManagerView {
    private UserService userService = new UserServiceImpl();
    private BookService bookService = new BookServiceImpl();
    private Scanner sc = new Scanner(System.in);
    private UserInfo userInfo;

    public BookManagerView() {
    }

    public BookManagerView(String idCard) {
        // 通过idCard查询到当前用户信息
        userInfo = userService.getUserInfoByIdCard(idCard);
        if (userInfo == null) {
            System.out.println("请先登录...");
            new UserView();
            return;
        }
        // 根据status显示指定的页面
        if (userInfo.getStatus() == 1) {
            general();// 普通用户界面
            return;
        }
        admin();// 管理员用户界面
    }

    /**
     * 普通用户可查询书籍信息
     */
    private void general() {
        System.out.println("+++++欢迎" + userInfo.getName() + "使用图书管理系统+++++");
        System.out.println("+++++1.查询                         +++++");
        System.out.println("+++++2.返回上一层              +++++");
        while (true) {
            System.out.println("请输入选项：");
            String option = sc.next();
            if ("1".equals(option)) {// 查询页面
                query();
                return;
            }

            if ("2".equals(option)) {// 返回上一层
                new UserView();
                return;
            }
            System.out.println("请输入正确的选项！");
        }
    }

    /**
     * 管理员界面
     */
    private void admin() {
        System.out.println("+++++欢迎" + userInfo.getName() + "使用图书管理系统+++++");
        System.out.println("+++++1.书籍管理                  +++++");
        System.out.println("+++++2.借书                         +++++");
        System.out.println("+++++3.还书                         +++++");
        System.out.println("+++++4.返回上一层              +++++");
        while (true) {
            System.out.println("请输入选项：");
            String option = sc.next();
            if ("1".equals(option)) {// 书籍管理
                bookManager();
                return;
            }

            if ("2".equals(option)) {// 租赁
                rentBook();
                return;
            }
            if ("3".equals(option)) {// 还书
                returnBook();
                return;
            }
            if ("4".equals(option)) {// 返回上一层
                new UserView();
                return;
            }
            System.out.println("请输入正确的选项！");
        }
    }

    /**
     * 查询界面
     */
    private void query() {
        System.out.println("+++++++++查询页面+++++++++");
        System.out.println("+++++1.通过书名查询      +++++");
        System.out.println("+++++2.通过id查询          +++++");
        System.out.println("+++++3.通过书名搜索      +++++");
        System.out.println("+++++4.查询所有书籍      +++++");
        System.out.println("+++++5.返回上一层          +++++");
        while (true) {
            System.out.println("请输入选项：");
            String option = sc.next();
            if ("1".equals(option)) {// 通过书名查询（需要提供书籍的全名）
                System.out.println("请输入书名：");
                BookInfo bookInfo = bookService.queryByBookName(sc.next());
                // 如果查询到书籍，输出书籍信息；如果没有查询到，输出相关提示
                if (bookInfo != null)
                    System.out.println(bookInfo);
                else
                    System.out.println("没有查询到相关书籍！");
                // 回到查询页面
                query();
                return;
            }

            if ("2".equals(option)) {// 通过id查询，id唯一标识一本书
                System.out.println("请输入书籍编号：");
                BookInfo bookInfo = bookService.queryByBookId(sc.next());
                // 如果查询到书籍，输出书籍信息；如果没有查询到，输出相关提示
                if (bookInfo != null)
                    System.out.println(bookInfo);
                else
                    System.out.println("没有查询到相关书籍！");
                // 回到查询页面
                query();
                return;
            }
            if ("3".equals(option)) {// 通过书名搜索，书名是关键字，这个关键字可能对应多个书籍信息
                System.out.println("请输入书名：");
                List<BookInfo> list = bookService.search(sc.next());
                // 如果集合不为空，遍历集合并输出所有的书籍信息；如果为空，输出提示
                if (list != null && list.size() > 0) {
                    list.forEach(bookInfo -> {
                        System.out.println(bookInfo);
                    });
                } else
                    System.out.println("没有查询到相关书籍！");
                // 返回查询页面
                query();
                return;
            }
            if ("4".equals(option)) {// 查询所有书籍信息
                List<BookInfo> list = bookService.getAllBooks();
                // 如果集合不为空，遍历集合并输出所有的书籍信息；如果为空，输出提示
                if (list != null && list.size() > 0) {
                    list.forEach(bookInfo -> {
                        System.out.println(bookInfo);
                    });
                } else
                    System.out.println("没有查询到相关书籍！");
                query();
                return;
            }
            if ("5".equals(option)) {
                if (userInfo.getStatus() == 1) {
                    general();
                    return;
                }
                admin();
                return;
            }
            System.out.println("请输入正确的选项！");
        }
    }

    /**
     * 书籍管理页面
     */
    private void bookManager() {
        System.out.println("+++++++++书籍管理页面+++++++++");
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
                return;
            }
            if ("3".equals(option)) {// 更新
                return;
            }
            if ("4".equals(option)) {// 删除
                return;
            }
            if ("5".equals(option)) {// 返回上一层
                admin();
                return;
            }
            System.out.println("请输入正确的选项！");
        }
    }

    /**
     * 书籍租赁
     */
    private void rentBook() {

    }

    /**
     * 还书
     */
    private void returnBook() {

    }
}
