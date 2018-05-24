<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
</head>
<body>
	<p>${message }</p>
	<form action="editUser" method="post">
		<input type="hidden" name="userid" value="${user.id }">
		<select name="authority">
			<option value="1">普通用户</option>
			<option value="2">管理员</option>
		</select><br>
		&emsp;&emsp;帐号：<input type="text" name="loginname" value="${user.loginName }"><br>
		&emsp;&emsp;密码：<input type="text" name="password" value="${user.password }"><br>
		&emsp;&emsp;姓名：<input type="text" name="realname" value="${user.realName }"><br>
		<input type="submit" value="更新">
	</form>
</body>

<script type="text/javascript">
	document.getElementsByTagName('select')[0].value ='${user.authority}';
</script>
</html>