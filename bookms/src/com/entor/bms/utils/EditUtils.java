package com.entor.bms.utils;

import com.entor.bms.entity.BookInfo;
import com.entor.bms.entity.UserInfo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class EditUtils {
    /**
     * 将用户对象的信息拼接成字符串
     *
     * @param userInfo 待处理的用户对象
     * @return 处理后的字符串
     */
    public static String userInfoToString(UserInfo userInfo) {
        // 编号  姓名  证件号 租赁书籍    状态
        StringBuilder buffer = new StringBuilder();
        buffer.append(userInfo.getUid()).append("\t")
                .append(userInfo.getName()).append("\t")
                .append(userInfo.getPassword()).append("\t")
                .append(userInfo.getIdCard()).append("\t")
                .append(rentBooksIdToString(userInfo.getRentBooks())).append("\t")
                .append(userInfo.getStatus()).append("\r\n");
        return buffer.toString();
    }

    /**
     * 租赁的书籍编号转换成字符串
     *
     * @param rentBooks 待处理的书籍对象集合
     * @return 处理后的字符串
     */
    private static String rentBooksIdToString(List<Integer> rentBooks) {
        if (rentBooks.size() == 0) {
            return "";
        }
        StringBuilder buffer = new StringBuilder();
        for (int index = 0; index < rentBooks.size(); index++) {
            if (index == rentBooks.size() - 1) {
                buffer.append(rentBooks.get(index));
            } else {
                buffer.append(rentBooks.get(index)).append(",");
            }
        }
        return buffer.toString();
    }

    /**
     * 读取的字符串转换成UserInfo对象
     *
     * @param line 读取文件中的每一行记录
     * @return 转换后的UserInfo对象
     */
    public static UserInfo stringToUserInfo(String line) {
        String[] arr = line.split("\t");
        UserInfo userInfo = new UserInfo();
        userInfo.setUid(Integer.parseInt(arr[0]));
        userInfo.setName(arr[1]);
        userInfo.setPassword(arr[2]);
        userInfo.setIdCard(arr[3]);
        if (arr[4] != null && !"".equals(arr[4].trim()))
            userInfo.setRentBooks(stringToBooksId(arr[4]));
        userInfo.setStatus(Integer.parseInt(arr[5]));
        return userInfo;
    }

    /**
     * 将读取的租赁书籍的id记录转换成集合
     *
     * @param ids 读取每行的书籍id的记录，它是类似于1,2,3,4这种形式
     * @return 书籍id集合
     */
    private static List<Integer> stringToBooksId(String ids) {
        String[] arr = ids.split(",");
        List<Integer> list = new LinkedList<>();
        for (String str : arr) {
            list.add(Integer.parseInt(str));
        }
        return list;
    }

    /**
     * 读取的字符串转换成BookInfo对象
     *
     * @param line 读取每行书籍信息，读取的是book文件
     * @return 每行记录对应的BookInfo对象
     */
    public static BookInfo stringToBookInfo(String line) {
        String[] arr = line.split("\t");
        BookInfo bookInfo = new BookInfo();
        bookInfo.setBid(Integer.parseInt(arr[0]));
        bookInfo.setBookName(arr[1]);
        bookInfo.setAmount(Integer.parseInt(arr[2]));
        return bookInfo;
    }

    /**
     * 将bookInfo对象转换成字符串
     *
     * @param bookInfo 待处理书籍对象
     * @return 转换后的字符串
     */
    public static String bookInfoToString(BookInfo bookInfo) {
        // 编号  书名   数量
        StringBuilder buffer = new StringBuilder();
        buffer.append(bookInfo.getBid()).append("\t")
                .append(bookInfo.getBookName()).append("\t")
                .append(bookInfo.getAmount()).append("\r\n");
        return buffer.toString();
    }
}
