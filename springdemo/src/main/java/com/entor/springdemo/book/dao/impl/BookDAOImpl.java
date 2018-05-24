package com.entor.springdemo.book.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import com.entor.springdemo.BookInfo;
import com.entor.springdemo.book.dao.BookDAO;
import com.entor.springdemo.book.dao.BookRowMapper;

public class BookDAOImpl implements BookDAO {

	private static final Logger LOGGER = LogManager.getLogger();

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<BookInfo> getAll() {
		return this.jdbcTemplate.query("select * from book_info", new BookRowMapper());
	}

	@Override
	public Integer count() {
		return this.jdbcTemplate.queryForObject("select count(*) from book_info ", Integer.class);
	}

	@Override
	public Integer getMaxId() {
		return 0;
	}

	@Override
	public void insertBook(BookInfo bookInfo) {
		this.jdbcTemplate.update("insert into book_info(book_name,amount,thumbnail,status) values(?,?,?,?)",
				bookInfo.getBookName(), bookInfo.getAmount(), bookInfo.getThumbnail(), bookInfo.getStatus());
	}

	@Override
	public BookInfo selectByBookId(Integer bookId) {
		return this.jdbcTemplate.queryForObject("select * from book_info where b_id = ?", new Object[] { bookId },
				new BookRowMapper());
	}

	@Override
	public List<BookInfo> selectByBookName(String bookName) {
		String sql="select * from book_info where book_name like ?";
		return null;
	}

	@Override
	public void deleteBook(Integer bid) {

	}

	@Override
	public void updateStatusById(int bid, int status) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateBookInfo(BookInfo newBook) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateThumbnailById(Integer bid, String thumbnail) {
		// TODO Auto-generated method stub

	}

	@Override
	public void batchDeleteByIds(String[] ids) {
		List<Object[]> paramList = new ArrayList<>();
		for (String param : ids) {
			paramList.add(new Object[] { Integer.parseInt(param) });
		}
		this.jdbcTemplate.batchUpdate("delete from book_info where b_id=?", paramList);
	}

	@Override
	public BookInfo selectByIdAndStatus(int bid, int status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void reduceBookAmount(int bid) {
		// TODO Auto-generated method stub

	}

	@Override
	public void increaseBookAmount(int bid) {
		// TODO Auto-generated method stub

	}

}
