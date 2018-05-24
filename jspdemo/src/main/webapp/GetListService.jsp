<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*,com.entor.jspdemo.entity.*,com.google.gson.*,com.google.gson.reflect.*,java.lang.reflect.*"%>
<%
	Gson gson = new Gson();
	BookInfo bookInfo = new BookInfo();
	bookInfo.setBid(1);
	bookInfo.setBookName("java编程思想");
	bookInfo.setAmount(75);

	// 将bookInfo对象转换成json字符串
	String bookInfoJson = gson.toJson(bookInfo);

	// 将json字符串转成bookInfo2对象
	BookInfo bookInfo2 = gson.fromJson(bookInfoJson, BookInfo.class);
	System.out.println(bookInfo2);

	// 将BookInfo的集合转成json字符串
	List<BookInfo> list = new ArrayList<>();
	list.add(bookInfo);
	list.add(new BookInfo(2, "java程序设计", 20));
	list.add(new BookInfo(3, "mybatis实战", 30));
	list.add(new BookInfo(4, "hibernate指南", 10));
	list.add(new BookInfo(5, "struts2用户手册", 22));

	// 通过typetoken获得泛型类型
	Type listType = new TypeToken<List<BookInfo>>() {
	}.getType();
	String listJson = gson.toJson(list, listType);
	
	// 将listJson转成集合
	List<BookInfo> list2 = gson.fromJson(listJson, listType);
	System.out.println("list2: " + list2);
	
	out.write(bookInfoJson + "<br>");
	out.write(listJson);
	out.flush();
%>