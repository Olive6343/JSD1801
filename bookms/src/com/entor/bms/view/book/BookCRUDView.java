package com.entor.bms.view.book;

import com.entor.bms.entity.BookInfo;
import com.entor.bms.entity.UserInfo;
import com.entor.bms.service.BookService;
import com.entor.bms.service.impl.BookServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookCRUDView {
    private Scanner sc = new Scanner(System.in);
    private BookService bookService = new BookServiceImpl();
    private UserInfo userInfo;

    public BookCRUDView(UserInfo userInfo) {
        this.userInfo = userInfo;
        crud();
    }

    /**
     * 书籍管理页面
     */
    private void crud() {
        System.out.println("+++++++++CRUD页面+++++++++");
        System.out.println("+++++1.查询                           +++++");
        System.out.println("+++++2.增加                           +++++");
        System.out.println("+++++3.修改                           +++++");
        System.out.println("+++++4.删除                           +++++");
        System.out.println("+++++5.返回上一层                 +++++");
        while (true) {
            System.out.println("请输入选项：");
            String option = sc.next();
            if ("1".equals(option)) {// 查询
                new QueryBookView(userInfo);
                return;
            }

            if ("2".equals(option)) {// 增加
                bookAdd();
                return;
            }
            if ("3".equals(option)) {// 更新
                bookUpdateView();
                return;
            }
            if ("4".equals(option)) {// 删除
                bookDeleteView();
                return;
            }
            if ("5".equals(option)) {// 返回上一层
                new BookManagerView(userInfo);
                return;
            }
            System.out.println("请输入正确的选项！");
        }
    }

    /**
     * 录入书籍
     */
    private void bookAdd() {
        // 录入书籍信息
        System.out.println("+++++录入书籍+++++");
        System.out.println("请输入书名：");
        String bookName = sc.next();

        // 对录入的书籍名称，去重复操作
        BookInfo info = bookService.queryByBookName(bookName);
        // 根据输入的书名，查询到了书籍信息，重复，重新输入
        if (info != null) {
            System.out.println("书名不可重复，重新录入！");
            bookAdd();// 返回书籍录入页面
            return;
        }

        Integer amount = null;
        while (true) {
            System.out.println("请输入数量：");
            try {
                amount = Integer.parseInt(sc.next());
                break;
            } catch (NumberFormatException nfe) {
                System.out.println("请输入数字！");
                continue;
            }
        }

        // 封装书籍对象
        BookInfo bookInfo = new BookInfo();
        bookInfo.setBookName(bookName);
        bookInfo.setAmount(amount);

        // 保存对象
        bookService.saveBook(bookInfo);
        System.out.println("添加成功！");

        crud();// 回到管理页面
        return;
    }

    /**
     * 书籍更新页面
     */
    private void bookUpdateView() {
        System.out.println("+++++书籍更新页面+++++");
        System.out.println("+++++1.重新录入    +++++");
        System.out.println("+++++2.修改书名    +++++");
        System.out.println("+++++3.修改数量    +++++");
        System.out.println("+++++4.返回上层    +++++");
        while (true) {
            System.out.println("请输入选项：");
            String option = sc.next();
            if ("1".equals(option)) {// 重新录入
                bookUpdate();
                return;
            }

            if ("2".equals(option)) {// 修改旧书名
                updateBookName();
                return;
            }
            if ("3".equals(option)) {// 修改数量
                updateBookAmount();
                return;
            }
            if ("4".equals(option)) {// 返回上层
                crud();
                return;
            }
            System.out.println("请输入正确的选项！");
        }
    }

    /**
     * 修改书籍名称
     */
    private void updateBookName() {
        // 更新书籍信息
        System.out.println("请输入书名：");
        String bookName = sc.next();

        // 对录入的书籍名称，去重复操作
        BookInfo bookInfo = bookService.queryByBookName(bookName);
        // 没找到书籍，无法更新
        if (bookInfo == null) {
            System.out.println("没有指定书籍，请重新输入！");
            bookUpdate();
            return;
        }

        // 通过去重复操作获得新书名
        String newBookName = getNewBookName(bookInfo);

        // 将新的书籍信息封装到对象中
        BookInfo newBook = new BookInfo(bookInfo.getBid(), newBookName, 0);

        // 根据id更新书籍信息
        bookService.updateBookName(newBook);

        System.out.println("更新成功！");
        crud();// 返回书籍管理页面
        return;
    }

    /**
     * 修改书籍数量
     */
    private void updateBookAmount() {
        // 更新书籍信息
        System.out.println("请输入书名：");
        String bookName = sc.next();

        // 对录入的书籍名称，去重复操作
        BookInfo bookInfo = bookService.queryByBookName(bookName);
        // 没找到书籍，无法更新
        if (bookInfo == null) {
            System.out.println("没有指定书籍，请重新输入！");
            bookUpdate();
            return;
        }

        System.out.println("请输入数量：");
        String amount = sc.next();


        // 将新的书籍信息封装到对象中
        BookInfo newBook = new BookInfo(bookInfo.getBid(), null, Integer.parseInt(amount));

        // 根据id更新书籍信息
        bookService.updateBookAmount(newBook);

        System.out.println("更新成功！");
        crud();// 返回书籍管理页面
        return;
    }

    /**
     * 书籍信息更新，重新录入
     */
    private void bookUpdate() {
        // 更新书籍信息
        System.out.println("请输入书名：");
        String bookName = sc.next();

        // 对录入的书籍名称，去重复操作
        BookInfo bookInfo = bookService.queryByBookName(bookName);
        // 没找到书籍，无法更新
        if (bookInfo == null) {
            System.out.println("没有指定书籍，请重新输入！");
            bookUpdate();
            return;
        }

        // 通过去重复获得新书名
        String newBookName = getNewBookName(bookInfo);

        System.out.println("请输入数量：");
        String amount = sc.next();

        // 将新的书籍信息封装到对象中
        BookInfo newBook = new BookInfo(bookInfo.getBid(), newBookName, Integer.parseInt(amount));

        // 根据id更新书籍信息
        bookService.updateBookInfo(newBook);

        System.out.println("更新成功！");
        crud();// 返回书籍管理页面
        return;
    }

    /**
     * 书籍删除
     */
    private void bookDeleteView() {
        System.out.println("+++++++++书籍删除页面+++++++++");
        System.out.println("+++++1.清空书架                    +++++");
        System.out.println("+++++2.根据书名删除             +++++");
        System.out.println("+++++3.根据id批量删除          +++++");
        System.out.println("+++++4.返回上层                    +++++");
        while (true) {
            System.out.println("请输入选项：");
            String option = sc.next();
            if ("1".equals(option)) {// 清空书架
                bookDelete();
                return;
            }
            if ("2".equals(option)) {// 根据书名删除
                bookDeleteByBookName();
                return;
            }
            if ("3".equals(option)) {// 根据id批量删除
                bookBatchDeleteByIds();
                return;
            }
            if ("4".equals(option)) {// 返回上层
                crud();
                return;
            }
            System.out.println("请输入正确的选项！");
        }
    }

    /**
     * 清空书架
     */
    private void bookDelete() {
        System.out.println("确认清空吗？y/n");
        String input = sc.next();
        if ("y".equalsIgnoreCase(input)) {
            // 清空书架
            bookService.clearBooks();
            System.out.println("清理成功！");
            crud();
            return;
        }
        bookDeleteView();
        return;
    }

    /**
     * 根据书名删除书籍记录
     */
    private void bookDeleteByBookName() {
        System.out.println("请输入书名：");
        String bookName = sc.next();

        //  根据书名获得书籍信息
        BookInfo bookInfo = bookService.queryByBookName(bookName);
        // 未查询到，没法删除
        if (bookInfo == null) {
            System.out.println("书籍信息不存在，删除失败！");
            bookDeleteView();// 返回书籍删除页面
            return;
        }
        bookService.deleteBookInfo(bookInfo);
        System.out.println("删除成功！");
        bookDeleteView();// 返回书籍删除页面
        return;
    }

    /**
     * 通过id批量删除书籍记录
     */
    private void bookBatchDeleteByIds() {
        System.out.println("++++++++批量删除++++++++");
        List<Integer> list = new ArrayList<>();
        while (true) {
            System.out.println("请输入id：（输入n退出！）");
            String input = sc.next();
            if ("n".equalsIgnoreCase(input)) {
                break;
            }

            // 保存输入的id
            list.add(Integer.parseInt(input));
        }

        // 根据id批量删除书籍信息
        bookService.batchDeleteByIds(list);

        System.out.println("删除成功！");
        bookDeleteView();
        return;
    }

    /**
     * 通过去重复操作获得新书名
     *
     * @param bookInfo
     * @return
     */
    private String getNewBookName(BookInfo bookInfo) {
        String newBookName = null;
        while (true) {
            System.out.println("请输入新书名：");
            newBookName = sc.next();

            // 新旧书名不可重复
            if (bookInfo.getBookName().equals(newBookName)) {
                System.out.println("新旧书名不可重复，请重新输入！");
                continue;
            }

            // 对录入的新的书籍名称，去重复操作
            BookInfo info = bookService.queryByBookName(newBookName);
            if (info != null) {
                System.out.println("该书名已存在，请重新输入！");
                continue;
            }

            break;
        }
        return newBookName;
    }
}
