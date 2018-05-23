package com.entor.bms.role.service.impl;

import java.util.List;

import com.entor.bms.user.dao.BookDAO;
import com.entor.bms.user.dao.impl.BookDAOImpl;
import com.entor.bms.user.entity.BookInfo;
import com.entor.bms.user.service.BookService;

public class BookServiceImpl implements BookService {
    private BookDAO bookDAO = new BookDAOImpl();

    @Override
    public List<BookInfo> getAllBooks() {
        return bookDAO.getAll();
    }

    @Override
    public BookInfo queryByBookName(String bookName) {
        return bookDAO.selectByBookName(bookName);
    }

    @Override
    public BookInfo queryByBookId(Integer bookId) {
        return bookDAO.selectByBookId(bookId);
    }

    @Override
    public List<BookInfo> search(String bookName) {
        return bookDAO.searchByBookName(bookName);
    }

    @Override
    public void saveBook(BookInfo bookInfo) {
        // 设置书籍id，书籍id是maxId + 1
        bookInfo.setBid(bookDAO.getMaxId() + 1);
        // 调用dao插入书籍的操作
        bookDAO.insertBook(bookInfo);
    }

    @Override
    public void updateBookInfo(BookInfo newBook) {
        // 查找所有的书籍
        List<BookInfo> list = getAllBooks();
        // 遍历书籍的记录
        for (BookInfo bookInfo : list) {
            // 根据id查询到旧的书籍信息
            if (bookInfo != null && bookInfo.getBid().equals(newBook.getBid())) {
                bookInfo.setBookName(newBook.getBookName());
                bookInfo.setAmount(newBook.getAmount());
            }
        }
        // 将新的书籍记录写到文件中，并覆盖原有文件
        bookDAO.updateBookInfo(list);
    }

    @Override
    public void deleteBookInfo(BookInfo bookInfo) {
        // 查找所有的书籍
        List<BookInfo> list = getAllBooks();
        // 删除bookInfo
        list.remove(bookInfo);
        // 将新的书籍记录写到文件中，并覆盖原有文件
        bookDAO.updateBookInfo(list);
    }

    @Override
    public void updateBookName(BookInfo newBook) {
        // 查找所有的书籍
        List<BookInfo> list = getAllBooks();
        // 遍历书籍的记录
        for (BookInfo bookInfo : list) {
            // 根据id查询到旧的书籍信息
            if (bookInfo != null && bookInfo.getBid().equals(newBook.getBid())) {
                bookInfo.setBookName(newBook.getBookName());
            }
        }
        // 将新的书籍记录写到文件中，并覆盖原有文件
        bookDAO.updateBookInfo(list);
    }

    @Override
    public void updateBookAmount(BookInfo newBook) {
        // 查找所有的书籍
        List<BookInfo> list = getAllBooks();
        // 遍历书籍的记录
        for (BookInfo bookInfo : list) {
            // 根据id查询到旧的书籍信息
            if (bookInfo != null && bookInfo.getBid().equals(newBook.getBid())) {
                bookInfo.setAmount(newBook.getAmount());
            }
        }
        // 将新的书籍记录写到文件中，并覆盖原有文件
        bookDAO.updateBookInfo(list);
    }

    @Override
    public void deleteById(Integer id) {
        // 查找所有的书籍
        List<BookInfo> list = getAllBooks();
        // 从list中移除指定id的书籍信息
        removeFromListById(list, id);
        // 将新的书籍记录写到文件中，并覆盖原有文件
        bookDAO.updateBookInfo(list);
    }

    @Override
    public void batchDeleteByIds(List<Integer> ids) {
        // 查找所有的书籍
        List<BookInfo> list = getAllBooks();
        // 遍历ids，从list中移除每个id的书籍信息
        for (Integer id : ids) {
            removeFromListById(list, id);
        }
        // 将新的书籍记录写到文件中，并覆盖原有文件
        bookDAO.updateBookInfo(list);
    }

    @Override
    public void clearBooks() {
        bookDAO.deleteAllBooks();
    }

    @Override
    public void returnBooks(List<Integer> ids) {
        // 取得所有的对象
        List<BookInfo> list = getAllBooks();
        for (Integer id : ids) {
            // 查找到书籍
            BookInfo bookInfo = queryByBookId(id);
            // 将书籍的信息更新并覆盖原来的信息
            if (bookInfo != null) {
                // 在原有的数量上+1
                bookInfo.setAmount(bookInfo.getAmount() + 1);
            }

            // 用新的对象替换就的对象
            list.set(list.indexOf(bookInfo), bookInfo);
        }

        // 更新书籍列表
        bookDAO.updateBookInfo(list);
    }

    /**
     * 从list中移除指定id的书籍信息
     *
     * @param list
     * @param id
     */
    private void removeFromListById(List<BookInfo> list, Integer id) {
        // 通过id查询到书籍信息
        BookInfo bookInfo = queryByBookId(id);
        //  从集合中移除书籍信息
        list.remove(bookInfo);
    }
}