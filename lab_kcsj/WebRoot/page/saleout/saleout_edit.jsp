<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="net.line.model.*"%>
<%@ page import="net.line.manager.*"%>
<%@ include file="/util/common.jsp"%>
<%
	SaleOutManager sm = new SaleOutManager();
	List<SaleOut> list = sm.find(new String(request.getParameter("id")
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
	<div class="place">
		<span>位置</span>
		<ul class="placeul">
			<li>首页</li>
			<li>修改销售单</li>
		</ul>
	</div>

	<form action="<%=path%>/servlet/SaleOutServlet?action=4" method="post">
		<div class="formbody">

			<div class="formtitle">
				<span>修改销售信息</span>
			</div>
			<ul class="forminfo">
				<%
					for(SaleOut model : list){
				 %>
				<li><label>销售单号</label><input name="saleNo" type="text" value="<%=model.getSaleNo()%>"
					class="dfinput" /><i>最多11位数字</i>
					</li>
				<li><label>销售员</label><input name="saleName" type="text" value="${LoginName}"
					class="dfinput" /><i>最多11位数字</i></li>
				<li><label>商品编号</label><input name="goodsNo" type="text"
					class="dfinput" value="<%=model.getGoodsNo()%>"/><i>最多11位数字</i></li>
				<li><label>商品名</label><input name="goodsName" type="text"
					class="dfinput" value="<%=model.getGoodsName()%>"/><i>最多11位数字</i></li>
				<li><label>价     &nbsp;格</label><input name="Price" type="text"
					class="dfinput" value="<%=model.getPrice()%>"/><i>只能输入数字</i></li>
				<li><label>数     &nbsp;量</label><input name="Amount" type="text"
					class="dfinput" value="<%=model.getAmount()%>"/><i>只能输入数字</i></li>
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
