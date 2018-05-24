<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="net.line.model.*"%>
<%@ page import="net.line.manager.*"%>
<%@ include file="/util/common.jsp"%>
<%
	GoodsManager gm = new GoodsManager();
	List<Goods> list = gm.find(new String(request.getParameter("id")
			.getBytes("ISO-8859-1"), "UTF-8"));

	System.out.println(new String(request.getParameter("id").getBytes(
			"ISO-8859-1"), "UTF-8"));
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<base href="<%=basePath%>" />
<title>修改售单</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<div class="place" style="background-color: #F0FFFF;">
		<span>位置</span>
		<ul class="placeul">
			<li><a href="<%=path%>/task/index_1.jsp">首页</a></li>
			<li>修改商品信息</li>
		</ul>
	</div>

	<form action="<%=path%>/servlet/GoodsServlet?action=4" method="post">
		<div class="formbody">

			<div class="formtitle">
				<span>修改销售信息</span>
			</div>
			<ul class="forminfo">
				<%
					for(Goods model : list){
				 %>
				<li><label>物料编号</label><input name="goodsid" type="text" value="<%=model.getGoodsid()%>"
					class="dfinput" /><i>最多11位数字</i>
					</li>
				<li><label>物料名称</label><input name="goodsname" type="text" value="<%=model.getGoodsname() %>"
					class="dfinput" /><i>最多11位数字</i></li>
				<li><label>供应商</label><input name="suppliername" type="text"
					class="dfinput" value="<%=model.getSuppliername()%>"/><i>最多11位数字</i></li>
				<li><label>规   &nbsp;格</label><input name="standard" type="text"
					class="dfinput" value="<%=model.getStandard()%>"/><i>最多11位数字</i></li>
				<li><label>单   &nbsp;位</label><input name="units" type="text"
					class="dfinput" value="<%=model.getUnits()%>"/><i>最多11位数字</i></li>
				<li><label>价     &nbsp;格</label><input name="Price" type="text"
					class="dfinput" value="<%=model.getPrice()%>"/><i>只能输入数字</i></li>
				<li><label>描     &nbsp;述</label><textarea name="description" cols="60" rows="6" value="<%=model.getDescription() %>">
				</textarea><i>不超过50字</i></li>
				<%
				}
				 %>
			
				<li><label>&nbsp;</label><input name="bb" type="submit"
					class="btn" value="确认保存" />
					<input name="res" type="reset"
					class="btn" value="重置" /></li>
				
			</ul>
		</div>
	</form>



</body>
</html>
