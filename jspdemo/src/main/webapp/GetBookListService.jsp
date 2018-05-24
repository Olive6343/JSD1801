<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*,com.entor.jspdemo.entity.*,com.google.gson.*,com.google.gson.reflect.*,java.lang.reflect.*"%>
<%
	Gson gson = new Gson();

	// 将BookInfo的集合转成json字符串
	List<BookInfo> list = new ArrayList<>();
	list.add(new BookInfo(2, "java程序设计", 20));
	list.add(new BookInfo(3, "mybatis实战", 30));
	list.add(new BookInfo(4, "hibernate指南", 10));
	list.add(new BookInfo(5, "struts2用户手册", 22));
	list.add(new BookInfo(5, "struts2用户手册", 22));
	list.add(new BookInfo(6, "struts2用户手册", 22));
	list.add(new BookInfo(7, "struts2用户手册", 22));
	list.add(new BookInfo(8, "struts2用户手册", 22));
	list.add(new BookInfo(9, "struts2用户手册", 22));
	list.add(new BookInfo(10, "struts2用户手册", 22));
	list.add(new BookInfo(11, "struts2用户手册", 22));
	list.add(new BookInfo(12, "struts2用户手册", 22));
	list.add(new BookInfo(13, "struts2用户手册", 22));
	list.add(new BookInfo(14, "struts2用户手册", 22));
	list.add(new BookInfo(15, "struts2用户手册", 22));
	list.add(new BookInfo(16, "struts2用户手册", 22));
	list.add(new BookInfo(17, "struts2用户手册", 22));
	list.add(new BookInfo(18, "struts2用户手册", 22));
	list.add(new BookInfo(19, "struts2用户手册", 22));
	list.add(new BookInfo(20, "struts2用户手册", 22));
	list.add(new BookInfo(21, "struts2用户手册", 22));
	list.add(new BookInfo(22, "struts2用户手册", 22));

	// 通过typetoken获得泛型类型
	Type listType = new TypeToken<List<BookInfo>>() {
	}.getType();
	String listJson = gson.toJson(list, listType);

	out.write("{\"total\":" + list.size() + ", \"rows\":" + listJson + "}");
	System.out.println(listJson);
	//out.write(listJson);
	out.flush();
%>