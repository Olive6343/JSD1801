package com.ldq.bms.dao;

import java.util.List;

import com.ldq.bms.entity.BookInfo;

public interface BookDAO {
	/**
	 * 获得所有书籍信息
	 * 
	 * @return 书籍对象集合
	 */
    List<BookInfo> getAll();

    /**
     * 获得最大的书籍编号
     * @return 书籍编号对应的整数
     */
	int getMaxId();

	/**
	 * 插入书籍对象
	 * @param bookInfo 从服务层传递过来需要保存的书籍对象
	 */
	void insertBook(BookInfo bookInfo);

	/**
	 * 删除书籍
	 * @param name 从服务层传递过来需要删除的书籍书名
	 */
	void deleteBook(String name);

	/**
	 * 更新书籍记录，使用新的书籍记录覆盖旧的书籍记录
	 * 
	 * @param list 新的书籍记录对象
	 */
	void updateBookInfo(List<BookInfo> list);

	/**
	 * 根据书名查找书籍信息
	 * 
	 * @param bookName
	 * @return
	 */
	BookInfo selectByBookName(String bookName);

	/**
	 * 根据书籍编号查找书籍信息
	 * 
	 * @param bookId 待查找书籍的编号
	 * @return 用户对象
	 */
	BookInfo selectByBookId(Integer bookId);

	/**
	 * 根据书名搜索书籍信息
	 * 
	 * @param bookName 书名关键字
	 * @return 符合条件用户信息集合
	 */
	List<BookInfo> searchByBookName(String bookName);

	/**
	 * 清空所有书籍信息
	 */
	void deleteAllBooks();
}
