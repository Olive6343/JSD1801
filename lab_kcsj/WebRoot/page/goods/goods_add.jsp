<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/util/common.jsp"%>
<%@ page import="net.line.model.Goods" %>
<%@ page import="net.line.manager.GoodsManager" %>

<%
//从list<Goods> 获取goodslist
GoodsManager gm=new GoodsManager();
List<Goods> list=gm.findSupplierName();
//request.setAttribute("list", (List<Goods>)gm.findSupplierName());
//List<Goods> splist=(List<Goods>)request.getAttribute("goodsList");

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

	<div class="place" style="background-color: #F0FFFF;">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="/task/index_1.jsp">首页</a>
			</li>
			<li>商品新增</li>
		</ul>
	</div>
	<form action="<%=path%>/servlet/GoodsServlet?action=1" method="post">
		<div class="formbody">

			<div class="formtitle">
				<span>商品信息</span>
			</div>
			<ul class="forminfo">
				<li><label>商品编号</label><input name="goodsid" type="text"
					class="dfinput" /><i>不能超过30个字符</i>
				</li>
				<li><label>商品名称</label><input name="goodsname" type="text"
					class="dfinput" /><i>多个关键字用,隔开</i>
				</li>
				<li><label>供应商</label><select name="suppliername" class="dfselect">
				<option value="" checked="checked">--请选择供应商--</option>
				<% for(Goods goods:list){
				 %>
					<option value="<%=goods.getSuppliername()%>" ><%=goods.getSuppliername()%></option>
				<%
					}
				 %>
				</select>
					<i>多个关键字用,隔开</i>
				</li>
				<li><label>规  格</label><input name="standard" type="text"
					class="dfinput" /><i>多个关键字用,隔开</i>
				</li>
				<li><label>单  位</label><input name="units" type="text"
					class="dfinput" /><i>多个关键字用,隔开</i>
				</li>
				<li><label>价格</label><input name="price" type="text"
					class="dfinput" /><i>多个关键字用,隔开</i>
				</li>
				<li><label>描  述</label><textarea name="description" cols="60" rows="4" >
				</textarea><i>不超过50字</i>
				</li>
				<li><label>&nbsp;</label><input name="bb" type="submit"
					class="btn" value="确认保存" />
				</li>
			</ul>
		</div>
	</form>


</body>

</html>
