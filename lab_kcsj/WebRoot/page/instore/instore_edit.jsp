<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="net.line.model.*"%>
<%@ page import="net.line.manager.*"%>
<%@ include file="/util/common.jsp"%>

<%
	InStoreManager im = new InStoreManager();
	List<InStore> list = im.find(new String(request.getParameter("id")
			.getBytes("ISO-8859-1"), "UTF-8"));

	System.out.println(new String(request.getParameter("id").getBytes(
			"ISO-8859-1"), "UTF-8"));
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<base href="<%=basePath%>" />
<title>用户新增</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<div class="place">
		<span>位置</span>
		<ul class="placeul">
			<li><a href="/task/index_1.jsp">首页</a></li>
			<li>新增采购单</li>
		</ul>
	</div>

	<form action="<%=path%>/servlet/InStoreServlet?action=4" method="post">
		<div class="formbody">

			<div class="formtitle">
				<span>入库信息列表</span>
			</div>
			<ul class="forminfo">
				<%
				for (InStore model : list) {
				%>
				<li><label>入库类型</label>
						<select name="storetype" >
								<option>服装</option>
								<option>饮食</option>
								<option>电子产品</option>
								<option>家具</option>
								<option>其他</option>
						</select>
					<input name="storeno" type="hidden"
					 value="<%=model.getStoreno()%>" />	
					<i>不能超过30个字符</i>
				</li>
				<li><label>仓库管理员</label><input name="storemgr" type="text"
					class="dfinput" value="<%=model.getStoremgr()%>" /><i>多个关键字用,隔开</i></li>
				<li><label>商品编号</label><input name="goodsid" type="text"
					class="dfinput" value="<%=model.getGoodsid()%>"/><i>最多11位数字</i></li>
				<li><label>商品名</label><input name="goodsname" type="text"
					class="dfinput" value="<%=model.getGoodsname()%>"/><i>最多11位数字</i></li>
				<li><label>价     &nbsp;格</label><input name="goodsprice" type="text"
					class="dfinput" value="<%=model.getGoodsprice()%>"/><i>最多11位数字</i></li>
				<li><label>数     &nbsp;量</label><input name="goodsamount" type="text"
					class="dfinput" value="<%=model.getGoodsamount()%>"/><i>最多11位数字</i></li>
					
				<li><label>备     &nbsp;注</label><input name="description" type="text"
					class="dfinput" value="<%=model.getDescription()%>"/><i>最多11位数字</i></li>
			<%
				}
			%>
				<li><label>&nbsp;</label><input name="bb" type="submit"
					class="btn" value="确认修改" />
					<input name="res" type="reset"
					class="btn" value="重置" /></li>
				
			</ul>
		</div>
	</form>



</body>
</html>
