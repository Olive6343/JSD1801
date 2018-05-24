<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="net.line.model.*"%>
<%@ page import="net.line.manager.*"%>
<%@ include file="/util/common.jsp"%>
<%@ page import="net.line.model.SaleOut"%>

<%
	//SaleOutManager saleOutManager=new SaleOutManager();
	//List<SaleOut> goodsName = (List<SaleOut>) request.getAttribute("saleOutList");
	SaleOutManager sm=new SaleOutManager();
	List<SaleOut> list=sm.findGoodsName();


%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<base href="<%=basePath%>" />
<title>新增销售单</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<div class="place">
		<span>位置</span>
		<ul class="placeul">
			<li><a href="<%=path%>/index_1.jsp">首页</a>
			</li>
			<li>新增销售单</li>
		</ul>
	</div>

	<form action="<%=path%>/servlet/SaleOutServlet?action=1" method="post">
		<div class="formbody">

			<div class="formtitle">
				<span>销售登记</span>
			</div>
			<ul class="forminfo">


				<li><label>销售员</label><input name="saleName" type="text"
					value="${LoginName}" class="dfinput" /><i>最多11位数字</i>
				</li>
				<li><label>商品编号</label><input name="goodsNo" type="text"
					class="dfinput" /><i>最多11位数字</i>
				</li>
				<li><label>商品名</label><select name="goodsName" style="width:150px; height:32px; line-height:32px; ">
						<option value="" checked="checked">--请选择商品名称--</option>
						<%
				for(SaleOut goods:list){
				 %>
				<option value="<%=goods.getGoodsName() %>"><%=goods.getGoodsName() %></option>
				<%
				}
				 %>
				</select><i>最多11位数字</i>
				</li>
				<li><label>价 &nbsp;格</label><input name="Price" type="text"
					class="dfinput" /><i>只能输入数字</i>
				</li>
				<li><label>数 &nbsp;量</label><input name="Amount" type="text"
					class="dfinput" /><i>只能输入数字</i>
				</li>


				<li><label>&nbsp;</label><input name="bb" type="submit"
					class="btn" value="确认保存" /> <input name="res" type="reset"
					class="btn" value="重置" />
				</li>

			</ul>
		</div>
	</form>



</body>
</html>
