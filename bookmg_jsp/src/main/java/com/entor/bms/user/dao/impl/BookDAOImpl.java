package com.entor.bms.user.dao.impl;

import java.util.List;

import com.entor.bms.user.dao.BookDAO;
import com.entor.bms.user.entity.BookInfo;

public class BookDAOImpl implements BookDAO {
    @Override
    public List<BookInfo> getAll() {
        return null;
    }

    @Override
    public BookInfo selectByBookId(Integer bookId) {
        // 查找所有的书籍
        List<BookInfo> list = getAll();
        // 遍历书籍的记录
        for (BookInfo bookInfo : list) {
            // 如果查询的id与某书籍id匹配，返回当前书籍对象
            if (bookInfo != null && bookInfo.getBid().equals(bookId)) {
                return bookInfo;
            }
        }
        // 没有在书籍记录中查找到指定书籍
        return null;
    }

    @Override
    public BookInfo selectByBookName(String bookName) {
        // 查找所有的书籍
        List<BookInfo> list = getAll();
        // 遍历书籍的记录
        for (BookInfo bookInfo : list) {
            // 如果查询的全名与某书籍名称匹配，返回当前书籍对象
            if (bookInfo != null && bookInfo.getBookName().equals(bookName)) {
                return bookInfo;
            }
        }
        // 没有在书籍记录中查找到指定书籍
        return null;
    }

    @Override
    public List<BookInfo> searchByBookName(String bookName) {
    	 return null;
    }

    @Override
    public Integer getMaxId() {
        // 获得所有的书籍对象
        List<BookInfo> list = getAll();
        // 查找书籍对象的最大Id
        Integer maxId = 0;
        for (BookInfo bookInfo : list) {
            if (bookInfo != null && bookInfo.getBid() > maxId) {
                maxId = bookInfo.getBid();
            }
        }
        return maxId;
    }

    @Override
    public void insertBook(BookInfo bookInfo) {
    }

    @Override
    public void updateBookInfo(List<BookInfo> list) {
    }

    @Override
    public void deleteAllBooks() {
    }
}
