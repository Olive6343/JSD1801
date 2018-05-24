<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="net.line.model.*"%>
<%@ page import="net.line.manager.*"%>
<%@ include file="/util/common.jsp"%>

<%
	StoreTypeManager sm = new StoreTypeManager();
	List<StoreType> list = sm.find(new String(request.getParameter("id")
			.getBytes("ISO-8859-1"), "UTF-8"));

	System.out.println(new String(request.getParameter("id").getBytes(
			"ISO-8859-1"), "UTF-8"));
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
			<li>修改仓库类型</li>
		</ul>
	</div>

	<form action="<%=path%>/servlet/StoreTypeServlet?action=4" method="post">
		<div class="formbody">

			<div class="formtitle">
				<span>仓库信息列表</span>
			</div>
			<ul class="forminfo">
				<%
				for (StoreType model : list) {
				%>
				
				<li><label>仓库类型:</label><input name="storeType" type="text"
					class="dfinput" value="<%=model.getStoreType()%>" />
					<input name="stNo" type="hidden"
					 value="<%=model.getStNo()%>"/><i>多个关键字用,隔开</i></li>
				
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
