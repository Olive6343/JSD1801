package com.ldq.bms.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.List;

import com.ldq.bms.entity.BookInfo;
import com.ldq.bms.entity.UserInfo;

public class ReadAndWriteUtils {
    private static final String USER_FILE_PATH = "user";
    private static final String BOOK_FILE_PATH = "book";

    /**
     * 追加一个用户
     *
     * @param userInfo
     */
    public static void singleWrite(String userInfo) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(USER_FILE_PATH, true));
            bw.write(userInfo);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 读文件，取得所有的userinfo记录
     *
     * @return
     */
    public static List<UserInfo> readAllUserRecords() {
        List<UserInfo> list = new LinkedList<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(USER_FILE_PATH));
            String line;
            while ((line = br.readLine()) != null) {
                UserInfo userInfo = EditUtils.stringToUserInfo(line);
                list.add(userInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;


    }

    /**
     * 读文件，取得所有的bookinfo记录
     *
     * @return 记录的集合，通过判断集合的元素个数，确定是否正确返回
     */
    public static List<BookInfo> readAllBookRecords() {
        List<BookInfo> list = new LinkedList<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(BOOK_FILE_PATH));
            String line;
            while ((line = br.readLine()) != null) {
                BookInfo bookInfo = EditUtils.stringToBookInfo(line);
                list.add(bookInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
