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
<script type="text/javascript" src="${basePath}js/book/updateBook.js"></script>
<style>
.form-control {
	margin-bottom: 10px;
}
</style>
</head>
<body>
	<!-- 请求方式: get/post，默认get -->
	<form id="bookForm" action="BookServlet" method="post"
		style="width: 400px; margin: 0 auto;">
		<div class="form-control">
			<input id="bid" name="bid" value="${BookInfo.bid }" readonly />
		</div>
		<div class="form-control">
			<input id="bookName" name="bookName" value="${BookInfo.bookName }" readonly />
		</div>
		<div class="form-control">
			<input id="amount" name="amount" value="${BookInfo.amount }" readonly />
		</div>
		<div class="form-control">
			<input id="thumbnail" name="thumbnail" value="${BookInfo.thumbnail }"
				readonly />
		</div>
		<div class="form-control">
			<select id="status" name="status">
				<option value="0">下架</option>
				<option value="1">上架</option>
			</select>
		</div>
	</form>
	<script type="text/javascript">
		$(function() {
			$('#status').combobox('setValue', '${bookInfo.status }');
		});
	</script>
</body>
</html>