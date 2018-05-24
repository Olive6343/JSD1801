<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="net.line.model.*"%>
<%@ page import="net.line.manager.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<base href="<%=basePath %>" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="js/select-ui.min.js"></script>
<script type="text/javascript" src="editor/kindeditor.js"></script>
<script type="text/javascript">
    KE.show({
        id : 'content7',
        cssPath : './index.css'
    });
  </script>
  
<script type="text/javascript">
$(document).ready(function(e) {

	$(".select3").uedSelect({
		width : 152
	});
});
function  openAdd(){
	
window.location.href="<%=path%>/servlet/GoodsServlet?action=5";	
}

</script>
</head>

<body>

	<div class="place" style="background-color: #F0FFFF;">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="/task/index_1.jsp">首页</a></li>
    <li>商品管理</li>
    </ul>
    </div>
    
    <div class="formbody">
    
    
    <div id="usual1" class="usual"> 

    <ul class="seachform1">
    <li class="sarchbtn"><label></label><input name="" type="button" class="scbtn" value="新增商品" onclick="openAdd();" />  </li>  
    </ul>

<form name="form1" id="form1"
			action="<%=path%>/servlet/GoodsServlet?action=3" method="post">
			<ul class="prosearch">
				
				<li><label>查询：</label><i>商品编号</i><a><input name="goodsid" id="goodsid1"
						type="text" class="scinput" /><br>
			
				</a><a><input name="select_btn" type="submit" class="sure"
						value="查询" onclick="checkNull()" />
				</a>
				</li>

			</ul>
		</form>

    <div class="formtitle"><span>商品信息列表</span></div>
    
    <table class="tablelist" >
    	<thead>
    	<tr>
        <th>序号</th>
        <th>商品编号</th>
        <th>商品名称</th>
        <th>供应商</th>
        <th>规格</th>
        <th>单位</th>
        <th>价格</th>
        <th>描述</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <%
        List<Goods> goodsList=(List<Goods>)request.getAttribute("goodsList");
		 int orderNum=0;
		for(int i=0;goodsList!=null&&i<goodsList.size();i++){
			 Goods m=goodsList.get(i);
			 orderNum++;
		%>
        <tr>
          <td><%=(orderNum)%></td>
          <td><%=m.getGoodsid()%></td>
          <td><%=m.getGoodsname()%></td>
          <td><%=m.getSuppliername()%></td>
          <td><%=m.getStandard()%></td>
          <td><%=m.getUnits()%></td>
          <td><%=m.getPrice()%></td>
          <td><%=m.getDescription()%></td>
          <td><a href="<%=path%>/page/goods/goods_edit.jsp?id=<%=m.getGoodsid() %>" class="tablelink">修改</a>     <a href="<%=path %>/servlet/GoodsServlet?action=2&goodsid=<%=m.getGoodsid() %>" class="tablelink"> 删除</a></td>
        </tr> 
        <%
		}
		%>
        
        </tbody>
    </table>
    
	</div> 

    </div>

</body>
</html>
