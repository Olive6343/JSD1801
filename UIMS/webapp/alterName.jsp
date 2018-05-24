<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<h1>修改姓名</h1>
	<form action="altername" method="post">
		<input type="hidden" name="userid" value="${userid}"> 旧姓名:<input
			type="text" name="oldname" id="oldname"> <br> 新姓名:<input
			type="text" name="realname" id="realname"> <br> 确认输入:<input
			type="text" name="rename" id="rename"> <br> <input
			type="submit" value="提交" onclick="return alter();">
	</form>
</body>
<script type="text/javascript">
	function alter() {
		var oldname = document.getElementById('oldname').value;
		var realname = document.getElementById('realname').value;
		var rename = document.getElementById('rename').value;

		if (oldname == null || oldname == undefined || oldname == '') {
			alert('请输入旧姓名！');
			return false;
		}

		if (realname == null || realname == undefined || realname == '') {
			alert('请输入新姓名！');
			return false;
		}

		if (realname != rename) {
			alert('两次输入的新姓名不一致！');
			return false;
		}
	}
</script>
</html>