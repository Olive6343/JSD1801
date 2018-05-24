package com.entor.springdemo;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.entor.springdemo.book.dao.BookDAO;

@ContextConfiguration(locations = {"classpath:spring-jdbc.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class JdbcTemplateTest {

	@Resource
	private BookDAO bookDAO;
	
	@Test
	public void testGetAll(){
		System.out.println(bookDAO.getAll());
	}
	
	@Test
	public void testBatchDeleteByIds(){
		bookDAO.batchDeleteByIds(new String[]{"5","6"});
	}
	
	@Test
	public void testInsertBook(){
		bookDAO.insertBook(new BookInfo(7,"算法",20,"123.jpg",0));
	}
}
