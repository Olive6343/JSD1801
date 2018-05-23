package com.ldq.bms.book.service.impl;

import java.util.List;

import com.ldq.bms.book.dao.BookDAO;
import com.ldq.bms.book.dao.impl.BookDAOImpl;
import com.ldq.bms.book.entity.BookInfo;
import com.ldq.bms.book.service.BookService;

public class BookServiceImpl implements BookService {
	private BookDAO bookDAO = new BookDAOImpl();

	@Override
	public List<BookInfo> getAllBooks() {
		return bookDAO.getAll();
	}

	@Override
	public BookInfo queryByBookId(Integer bookId) {
		return bookDAO.selectByBookId(bookId);
	}

	@Override
	public void saveBook(BookInfo bookInfo) {
		bookInfo.setStatus(0);
		bookDAO.insertBook(bookInfo);
	}

	@Override
	public void updateBookInfo(BookInfo newBook) {
		bookDAO.updateBookInfo(newBook);
	}

	@Override
	public void updateBookName(BookInfo newBook) {
	}

	@Override
	public void updateBookAmount(BookInfo newBook) {
	}

	@Override
	public void batchDeleteByIds(String[] ids) {
		bookDAO.batchDeleteByIds(ids);
	}

	@Override
	public void clearBooks() {
	}

	@Override
	public void returnBooks(List<Integer> ids) {
	}

	@Override
	public List<BookInfo> searchBooksByName(String bookName) {
		return bookDAO.selectByBookName(bookName);
	}

	@Override
	public void updateStatusById(int bid, int status) {
		bookDAO.updateStatusById(bid, status);
	}

	@Override
	public void removeUserById(int bid) {
		bookDAO.deleteBook(bid);
	}

	@Override
	public BookInfo getBookInfoById(int bid) {
		return bookDAO.selectByBookId(bid);
	}

	@Override
	public void updateThumbnailById(Integer bid, String thumbnail) {
		bookDAO.updateThumbnailById(bid,thumbnail);		
	}

	@Override
	public List<BookInfo> searchBooksByNameOrStatus(String bname, String status) {
		return bookDAO.searchBooksByNameOrStatus(bname, status);
	}

	@Override
	public BookInfo getBookByIdAndStatus(int parseInt, int i) {
		// TODO Auto-generated method stub
		return null;
	}
}