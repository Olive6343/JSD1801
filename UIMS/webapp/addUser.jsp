<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
</head>
<body>
	<p>${message }</p>
	<form action="addUser" method="post">
		<select name="authority">
			<option value="1">普通用户</option>
			<option value="2">管理员</option>
		</select><br>
		&emsp;&emsp;帐号：<input type="text" name="loginname"><br>
		&emsp;&emsp;密码：<input type="text" name="password"><br>
		&emsp;&emsp;姓名：<input type="text" name="realname"><br>
		<input type="submit" value="添加">
	</form>
</body>

<script type="text/javascript">
	function addUser(){
		var loginname = document.getElementsByName('intput')[0].value;
		if(loginname == null || loginname == undefined || loginname == ''){
			alter('用户已存在！');
			return false;
		}
	}
</script>
</html>