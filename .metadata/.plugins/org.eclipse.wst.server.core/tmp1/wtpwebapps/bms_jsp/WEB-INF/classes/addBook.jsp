<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	request.setAttribute("basePath", basePath);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 基本 -->
<link rel="stylesheet" type="text/css"
	href="${basePath}css/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${basePath}css/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="${basePath}css/themes/color.css">
<link rel="stylesheet" type="text/css"
	href="${basePath}css/demo/demo.css">
<script type="text/javascript" src="${basePath}js/jquery.min.js"></script>
<script type="text/javascript" src="${basePath}js/jquery.easyui.min.js"></script>
<!-- 自定义 -->
<script type="text/javascript" src="js/json2.js"></script>
<script type="text/javascript" src="${basePath}js/book/addBook.js"></script>
<style>
.form-control {
	margin-bottom: 10px;
}
</style>
</head>
<body>
	<!-- 请求方式: get/post，默认get -->
	<form id="bookForm" action="bookServlet" method="post"
		style="width: 400px; margin: 0 auto;">
		<div class="form-control">
			<input id="bookName" name="bookName" value="${bookInfo.bookName }" />*必须
		</div>
		<div class="form-control">
			<input id="amount" name=amount value="${bookInfo.amount }" />*必须
		</div>
		<div class="form-control">
			<select id="status" name="status">
				<option value="0">下架</option>
				<option value="1">上架</option>
			</select>*必须
		</div>
		<div class="form-control ">
			<a href="javascript:void(0);" class="easyui-linkbutton"
				style="width: 300px; text-align: center;" onclick="addBook();">添&emsp;加</a>
		</div>
	</form>

	<form id="uploadForm" enctype="multipart/form-data">
		<input type="hidden" id="bid" value="${bookInfo.bid }" />
		<div class="form-control" style="text-align:center;">
			<img id="pic" width="200" height="100"
				style="border: 1px solid gray;"
				src="BookServlet?tp=pic&bid=${bookInfo.bid}"
				onerror="defaultImg(this,'${basePath }/img/noting.jpg')">
		</div>
		<div class="form-control">
			<input id="uploadFile" name="uploadFile" /> <a
				href="javascript:void(0);" class="easyui-linkbutton"
				style="width: 100px; text-align: center;" onclick="uploadSubmit();">上&emsp;传</a>
		</div>
	</form>

</body>
</html>