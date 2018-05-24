<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/util/common.jsp"%>
<%@ page import="net.line.model.StoreType" %>

<%
//从list<Goods> 获取goodslist
//List<StoreType> goodsName=(List<StoreType>)request.getAttribute("storeTypeList");

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
			<li>新增仓库类型</li>

		</ul>
	</div>
	<form action="<%=path%>/servlet/StoreTypeServlet?action=1" method="post">
		<div class="formbody">

			<div class="formtitle">
				<span>仓库信息</span>
			</div>
			<ul class="forminfo">
				
				<li><label>仓库类型</label><input name="storeType" type="text"
					class="dfinput" /><i>不能超过30个字符</i>
					
				</li>
				<li><label>&nbsp;</label><input name="bb" type="submit"
					class="btn" value="确认保存" />
					<input name="res" type="reset"
					class="btn" value="重置"/>
				</li>
			</ul>
		</div>
	</form>

</body>

</html>
