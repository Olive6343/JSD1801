	<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
	<%@ page import="net.line.model.*"%>
	<%@ page import="net.line.manager.*"%>
	<%@ include file="/util/common.jsp"%>
	
	<%
		SupplierManager sm = new SupplierManager();
		List<Supplier> list = sm.find(new String(request.getParameter("id")
				.getBytes("ISO-8859-1"), "UTF-8"));
	
		//System.out.println(new String(request.getParameter("id").getBytes("ISO-8859-1"), "UTF-8"));
	%>
	
	<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
	<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<base href="<%=basePath%>" />
	<title>用户新增</title>
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	</head>
	
	<body>
		<div class="place">
			<span>位置</span>
			<ul class="placeul">
				<li><a href="/task/index_1.jsp">首页</a></li>
				<li>修改新增供应商</li>
			</ul>
		</div>
	
		<form action="<%=path%>/servlet/SupplierServlet?action=4" method="post">
			<div class="formbody">
	
				<div class="formtitle">
					<span>供应商信息列表</span>
				</div>
				<ul class="forminfo">
					<%
					for (Supplier model : list) {
					%>	
					<li><label>供应商编号</label><input name="spId" type="text"
						class="dfinput" value="<%=model.getSpId()%>"/><i>最好以字母开头，后加数字</i></li>
					<li><label>供应商名称</label><input name="spName" type="text"
						class="dfinput" value="<%=model.getSpName()%>"/><i>最多不能超过20字</i></li>		
				<%
					}
				%>
					<li><label>&nbsp;</label><input name="bb" type="submit"
						class="btn" value="确认修改" />
						<input name="res" type="reset"
						class="btn" value="重置" /></li>
				</ul>
			</div>
		</form>
	
	
	
	</body>
	</html>
