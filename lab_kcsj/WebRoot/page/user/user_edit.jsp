<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="net.line.manager.UserManager"%>
<%@ page import="net.line.model.User"%>
<%@ include file="/util/common.jsp"%>

<%
	UserManager um = new UserManager();
	List<User> list = um.findAll(new String(request.getParameter("id")
			.getBytes("ISO-8859-1"), "UTF-8"));
	
	System.out.println(new String(request.getParameter("id").getBytes(
			"ISO-8859-1"), "UTF-8"));
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<base href="<%=basePath%>" />
<title>用户新增</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="/task/index_1.jsp">首页</a>
			</li>
			<li>修改新增</li>
		</ul>
	</div>
	
	<form action="<%=path%>/servlet/UserServlet?action=5" method="post">
		
		<div class="formbody">
			
			<div class="formtitle">
				<span>修改用户信息</span>
			</div>
			
			<ul class="forminfo">
			
				<%
					for (User model : list) {
				%>
				<li><label>用户名：</label><input type="text" name="userid" style="height: 40px;width: 300px;"
					value="<%=model.getUserid()%>" class="dfinput" /></li>
				<li><label>密 码：</label><input type="password" name="pwd" style="height: 40px;width: 300px;"
					value="<%=model.getPwd()%>" class="dfinput"/></li>
				<li><label>职 位：</label><select  name="job" class="dfselect">
					<option value="<%=model.getJob()%>" checked="checked"><%=model.getJob()%></option>
					<option value="超级管理员">超级管理员</option>
					<option value="管理员">管理员</option>
					<option value="销售员">销售员</option>	
					</select>
				</li>
				<%
					}
				%>
				<li><input name="bb" type="submit"
					class="btn" value="确认修改" />
				</li>
			
			</ul>
			
		</div>
		
	</form>


</body>

</html>
