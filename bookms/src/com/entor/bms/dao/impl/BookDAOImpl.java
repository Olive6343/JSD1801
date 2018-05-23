package com.entor.bms.dao.impl;

import com.entor.bms.dao.BookDAO;
import com.entor.bms.entity.BookInfo;
import com.entor.bms.utils.EditUtils;
import com.entor.bms.utils.ReadAndWriteUtils;
import com.entor.bms.utils.StringUtils;

import java.util.LinkedList;
import java.util.List;

public class BookDAOImpl implements BookDAO {
    @Override
    public List<BookInfo> getAll() {
        return ReadAndWriteUtils.readAllBookRecords();
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
        // 创建搜索结果的集合，没有元素
        List<BookInfo> searchResult = new LinkedList<>();
        // 查找所有的书籍
        List<BookInfo> list = getAll();
        // 遍历书籍的记录
        for (BookInfo bookInfo : list) {
            // 如果书名关键字被某个书籍名称包含，当前书籍对象就是搜索的结果之一
            // 模糊查询
            if (bookInfo != null && StringUtils.containsIgnoreCase(bookInfo.getBookName(), bookName)) {
                // 将查询到的有效信息添加到结果集中
                searchResult.add(bookInfo);
            }
        }
        // 始终返回查询的结果集，通过结果集的元素的个数（size属性）来判断是否查询到有效信息
        return searchResult;
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
        // 指定插入的文件路径和插入的记录
        ReadAndWriteUtils.singleWrite(EditUtils.bookInfoToString(bookInfo), ReadAndWriteUtils.BOOK_FILE_PATH);
    }

    @Override
    public void updateBookInfo(List<BookInfo> list) {
        //  将书籍集合写入到文件
        ReadAndWriteUtils.multiBooksWrite(list, ReadAndWriteUtils.BOOK_FILE_PATH);
    }

    @Override
    public void deleteAllBooks() {
        // 删除book文件
        ReadAndWriteUtils.delete(ReadAndWriteUtils.BOOK_FILE_PATH);
    }
}
