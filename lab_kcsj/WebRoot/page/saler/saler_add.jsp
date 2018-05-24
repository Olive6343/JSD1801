<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/util/common.jsp"%>

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
			<li>用户新增
			</li>
		</ul>
	</div>
	<form action="<%=path%>/servlet/SalerServlet?action=1" method="post">
		<div class="formbody">

			<div class="formtitle">
				<span>用户基本信息</span>
			</div>
			<ul class="forminfo">
				<li><label>销售员编号</label><input name="salerNo" type="text"
					class="dfinput" /><i>不能超过30个字符</i>
				</li>
				<li><label>销售员名字</label><input name="salerName" type="text"
					class="dfinput" /><i>不能超过30个字符</i>
				</li>
				<li><label>密码</label><input name="salerPwd" type="text"
					class="dfinput" /><i>多个关键字用,隔开</i>
				</li>
				<li><label>性别</label><input type="radio" name="salerSex" value="男" checked="checked"/>男
									  <input type="radio" name="salerSex" value="女"/>女
				  <i>人妖吗</i>
				</li>
				<li><label>电话</label><input name="salerTel" type="text"
					class="dfinput" /><i>最多11位数字</i>
				</li>
				<li><label>&nbsp;</label><input name="bb" type="submit"
					class="btn" value="确认保存" />
				</li>
			</ul>
		</div>
	</form>


</body>

</html>
