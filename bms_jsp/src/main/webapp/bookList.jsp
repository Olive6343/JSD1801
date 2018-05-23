<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

	request.setAttribute("basePath", basePath);
%>
<!DOCTYPE html>
<html>
<head>
<!-- 基本 -->
<link rel="shortcut icon" href="img/bitbug_favicon.ico">
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
<script type="text/javascript" src="${basePath}js/datagrid-filter.js"></script>
<script type="text/javascript" src="${basePath}js/easyui-lang-zh_CN.js"></script>
<!-- 自定义 -->
<script type="text/javascript" src="js/book/book.js"></script>
</head>
<body style="padding: 0;">
	<table id="dg_book">
	</table>
	<div id="book_toolbar" style="padding: 10px; height: auto">
		<div style="margin-bottom: 5px">
			<a href="javascript:void(0);" class="easyui-linkbutton"
				iconCls="icon-add" plain="true" onclick="addBook();">增加</a> <a
				href="javascript:void(0);" class="easyui-linkbutton"
				iconCls="icon-remove" plain="true" onclick="batchDel();">批量删除</a>
				书名：<input class="easyui-textbox" id="name" name="name">
				状态：<select class="easyui-combobox" id="status" name="status" style="width:150px;">
					<option value="">--请选择状态--</option>
					<option value="0">下架</option>
					<option value="1">上架</option>
				</select>
				 <a
				href="javascript:void(0);" class="easyui-linkbutton"
				iconCls="icon-search" onclick="searchBook();">Search</a>
		</div>
	</div>
	<div id="update_book_dialog"></div>
</body>
</html>