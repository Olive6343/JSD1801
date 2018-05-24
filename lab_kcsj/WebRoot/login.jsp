<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/util/common.jsp"%>
<%
	
	//HttpSession session=request.getSession();
		//   session = (HttpSession) session.getAttribute("rand");
		//   rand = request.getParameter("rand");
	//if(session.getAttribute("userid")==null ||session.getAttribute("pwd")==null){
	//	response.sendRedirect("login.jsp");
	//}


 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>欢迎登录后台管理系统</title>
<base href="<%=basePath%>" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>
<script src="js/cloud.js" type="text/javascript"></script>

<script type="text/javascript" language="javascript">


	$(function() {
		$('.loginbox').css({
			'position' : 'absolute',
			'left' : ($(window).width() - 692) / 2
		});
		$(window).resize(function() {
			$('.loginbox').css({
				'position' : 'absolute',
				'left' : ($(window).width() - 692) / 2
			});

		});

	});
	function login() {
	if(randomString.toLowerCase().equals(inputCode.toLowerCase())){
	if (loginForm.username.value == "") {
			loginForm("请输入用户名！");
			loginForm.name.focus();
			return;
		} else if (loginForm.pwd.value == "") {
			alert("请输入密码！");
			loginForm.pwd.focus();
			return;
		} else if (loginForm.rand.value == "") {
			alert("请输入验证码！");
			loginForm.rand.focus();
			return;
		} else {
			loginForm.submit();
		}
		$("#loginForm").submit();

	}
}
	function reloadImage() {
		//document.getElementById('btn').disabled = true;
		document.getElementById('identity').src = '<%=path%>/common/IdentityServlet? ts='
				+ new Date().getTime();
	}
	
	 
 	function changeCode()  
  {  
   document.getElementById("rc").src="<%=path%>/servlet/RandomCodeServlet?t="+new Date().getTime();;  
  }  
 
</script>

</head>

<body
	style="background-color:#1c77ac; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">



	<div id="mainBody">
		<div id="cloud1" class="cloud"></div>
		<div id="cloud2" class="cloud"></div>
	</div>


	<div class="logintop">
		<span>欢迎登录后台管理界面平台</span>
		<ul>
			<li><a href="#">回首页</a></li>
			<li><a href="#">帮助</a></li>
			<li><a href="#">关于</a></li>
		</ul>
	</div>
	<form id="loginForm" action="<%=path%>/servlet/UserServlet?action=0"
		method="post">

		<div class="loginbody">
			<div class="loginbox loginbox2">

				<ul>
					<li><input name="userid" type="text" class="loginuser"
						value="admin" onclick="JavaScript:this.value=''" /></li>
					<li><input name="pwd" type="password" class="loginpwd" value="密码"
						onclick="JavaScript:this.value=''" /></li>
					<li style="margin-left:15%;">
						<input type="radio" name="job" value="超级管理员"  checked="checked"/>超级管理员
						<input type="radio" name="job" value="管理员" style="margin-left:20px"/>管理员
						<input type="radio" name="job" value="销售员" style="margin-left:20px"/>销售员
					</li>
					<li>
						<input type="text" id="code" name="code" style="width:85px; height:40px;" class="loginpwd" />
						<img src="<%=path%>/common/IdentityServlet" id="identity" align="middle"  />
						<input type="button" value="看不清，换一张"  onclick="reloadImage()" id="btn"/> 
					</li>

					<li><input name="" type="submit" class="loginbtn"
						id="loginbtn" value="登录" onclick="login();" />
							<label></label><label></label>
							<label><a href="#">记住密码</a></label>
							<label><a href="#">忘记密码？</a> </label></li>
				</ul>


			</div>

		</div>
	</form>

	<div class="loginbm">
		版权所有 2016 <a href="#">14计算机科学与技术</a>

	</div>


</body>

</html>
