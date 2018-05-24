<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="net.line.model.*"%>
<%@ page import="net.line.manager.*"%>
<%@ include file="/util/common.jsp"%>
<%@ page import="net.line.manager.InStoreManager" %>
<%
//从list<Goods> 获取goodslist
InStoreManager im=new InStoreManager();
List<InStore> list=im.findStoreType();
//List<InStore> splist=im.findSupplier();
//request.setAttribute("list", (List<Goods>)gm.findGoodsName());
//List<Goods> goodsName=(List<Goods>)request.getAttribute("list");

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
			<li>新增入库单</li>
		</ul>
	</div>

	<form action="<%=path%>/servlet/InStoreServlet?action=1" method="post">
		<div class="formbody">

			<div class="formtitle">
				<span>入库信息列表</span>
			</div>
			<ul class="forminfo">
				
				<li><label>仓库类型</label>
						<select name="storetype" class="dfselect">
						<option value="" checked="checked">--请选择仓库类型--</option>
						<%
							for(InStore inStore:list){
						 %>
								<option value="<%=inStore.getStoretype() %>"><%=inStore.getStoretype() %></option>
						<%
						} %>		
						</select>
						
					<i>不能超过30个字符</i>
				</li>
				<li><label>仓库管理员</label><input name="storemgr" type="text"
					class="dfinput" /><i>多个关键字用,隔开</i></li>
				<li><label>商品编号</label><input name="goodsid" type="text"
					class="dfinput" /><i>最多11位数字</i></li>
				<li><label>商品名</label><input name="goodsname" type="text"
					class="dfinput" /><i>最多11位数字</i></li>
				<li><label>价     &nbsp;格</label><input name="goodsprice" type="text"
					class="dfinput" /><i>最多11位数字</i></li>
				<li><label>数     &nbsp;量</label><input name="goodsamount" type="text"
					class="dfinput" /><i>最多11位数字</i></li>
				<li><label>供应商</label><input name="supplier" type="text" class="dfinput" />
				<i>最多11位数字</i></li>	
				<li><label>备     &nbsp;注</label><input name="description" type="text"
					class="dfinput" /><i>最多11位数字</i></li>

				<li><label>&nbsp;</label><input name="bb" type="submit"
					class="btn" value="确认保存" />
					<input name="res" type="reset"
					class="btn" value="重置" /></li>
				
			</ul>
		</div>
	</form>



</body>
</html>
