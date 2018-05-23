package com.entor.bms.role.service;

import java.util.List;

import com.entor.bms.user.entity.BookInfo;

public interface BookService {
    /**
     * 根据指定的书籍名称，查询书籍记录
     *
     * @param bookName 指定书籍的全名，如果没有提供全名，很可能查找不到相关书籍
     * @return 指定书籍对象，如果没有对象，返回null
     */
    BookInfo queryByBookName(String bookName);

    /**
     * 根据指定的书籍编号，查询书籍记录
     *
     * @param bookId 指定书籍的编号，这个编号唯一指定一本数
     * @return 指定书籍对象，如果没有对象，返回null
     */
    BookInfo queryByBookId(Integer bookId);

    /**
     * 根据书名关键字查询相关书籍记录
     *
     * @param bookName 书名关键字，这个关键字不是书籍的全名
     * @return 相关书籍的对象集合，如果没有对象，返回没有元素的集合（size=0）
     */
    List<BookInfo> search(String bookName);

    /**
     * 查询所有的书籍信息
     *
     * @return 所有书籍的对象集合，如果没有对象，返回没有元素的集合（size=0）
     */
    List<BookInfo> getAllBooks();

    /**
     * 保存书籍对象
     *
     * @param bookInfo 书籍信息封装对象
     */
    void saveBook(BookInfo bookInfo);

    /**
     * 更新书籍信息，根据id定位旧的信息，替换成新的信息
     *
     * @param newBook 新的书籍对象
     */
    void updateBookInfo(BookInfo newBook);

    /**
     * 删除指定的书籍记录
     *
     * @param bookInfo 待删除的书籍对象
     */
    void deleteBookInfo(BookInfo bookInfo);

    /**
     * 更新书籍名称，根据id定位旧书名，替换成新书名
     *
     * @param newBook
     */
    void updateBookName(BookInfo newBook);

    /**
     * 更新书籍数量，根据id定位旧书，替换成新数量
     *
     * @param newBook
     */
    void updateBookAmount(BookInfo newBook);

    /**
     * 根据id删除书籍信息
     *
     * @param id 删除的书籍的id
     */
    void deleteById(Integer id);

    /**
     * 根据id集合批量删除书籍信息
     *
     * @param ids id集合
     */
    void batchDeleteByIds(List<Integer> ids);

    /**
     * 无差别删除所有书籍信息
     */
    void clearBooks();

    /**
     * 根据id归还书籍
     *
     * @param ids id集合
     */
    void returnBooks(List<Integer> ids);
}
