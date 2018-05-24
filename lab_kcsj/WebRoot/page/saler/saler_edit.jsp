<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="net.line.model.*"%>
<%@ page import="net.line.manager.*"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	SalerManager um = new SalerManager();
	List<Saler> list = um.find(new String(request.getParameter("id")
			.getBytes("ISO-8859-1"), "UTF-8"));

	System.out.println(new String(request.getParameter("id").getBytes(
			"ISO-8859-1"), "UTF-8"));
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>修改销售员信息</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>

	<form action="<%=path%>/servlet/SalerServlet?action=4" method="post"
		id="editform">
		<table>
			<caption>修改销售员信息</caption>

			<%
				for (Saler model : list) {
			%>
			<tr>
				<td>销售员编号：</td>
				<td><input type="text" name="salerNo"
					value="<%=model.getSalerNo()%>" /></td>
			</tr>
			<tr>
				<td>销售员名字：</td>
				<td><input type="text" name="salerName"
					value="<%=model.getSalerName()%>" /></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="text" name="salerPwd"
					value="<%=model.getSalerPwd()%>" />
			</tr>
			<tr>
				<td>性别：</td>
				<td><input type="radio" name="salerSex" value="男" checked="checked"/>男
									  <input type="radio" name="salerSex" value="女"/>女
			</tr>

			<tr>
				<td>电话：</td>
				<td><input type="text" name="salerTel"
					value="<%=model.getSalerTel()%>"/></td>
			</tr>
			<%
				}
			%>
			<tr>
				<td></td>
				<td><input type="submit" name="edit_btn" value="保存" /></td>
				<td><input type="reset" name="reset_btn" value="重置" /></td>
			</tr>

		</table>
	</form>
</body>
</html>

