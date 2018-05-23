package com.ldq.bms.service.impl;

import java.util.LinkedList;
import java.util.List;

import com.ldq.bms.dao.BookDAO;
import com.ldq.bms.dao.impl.BookDAOImpl;
import com.ldq.bms.entity.BookInfo;
import com.ldq.bms.service.BookService;

public class BookServiceImpl implements BookService {
    private BookDAO bookDAO = new BookDAOImpl();

    @Override
    public List<BookInfo> getAllBooks() {
        return bookDAO.getAll();
    }

    @Override
    public BookInfo queryByBookName(String bookName) {
        // 查找所有的书籍
        List<BookInfo> list = getAllBooks();
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
    public BookInfo queryByBookId(String bookId) {
        // 查找所有的书籍
        List<BookInfo> list = getAllBooks();
        // 遍历书籍的记录
        for (BookInfo bookInfo : list) {
            // 如果查询的id与某书籍id匹配，返回当前书籍对象
            if (bookInfo != null && bookInfo.getBid().equals(Integer.parseInt(bookId))) {
                return bookInfo;
            }
        }
        // 没有在书籍记录中查找到指定书籍
        return null;
    }

    @Override
    public List<BookInfo> search(String bookName) {
        // 创建搜索结果的集合，没有元素
        List<BookInfo> searchResult = new LinkedList<>();
        // 查找所有的书籍
        List<BookInfo> list = getAllBooks();
        // 遍历书籍的记录
        for (BookInfo bookInfo : list) {
            // 如果书名关键字被某个书籍名称包含，当前书籍对象就是搜索的结果之一
            // 模糊查询
            if (bookInfo != null && bookInfo.getBookName().contains(bookName)) {
                // 将查询到的有效信息添加到结果集中
                searchResult.add(bookInfo);
            }
        }
        // 始终返回查询的结果集，通过结果集的元素的个数（size属性）来判断是否查询到有效信息
        return searchResult;
    }
}
