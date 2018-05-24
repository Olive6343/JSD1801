<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="net.line.model.*"%>
<%@ page import="net.line.manager.*"%>
<%@ include file="/util/common.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<base href="<%=basePath%>" />
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
    
    
       function checkNull() {
		if (form1.storeno.value == "") {
			alert("请输入要查询的入库单号！");
			form1.storeno.focus();
			return;
		}else{
		form1.submit();
		}
	}
  </script>

<script type="text/javascript">
$(document).ready(function(e) {

	$(".select3").uedSelect({
		width : 152
	});
});
function  openAdd(){
	
window.location.href="<%=path%>/servlet/InStoreServlet?action=6";
	}
</script>
</head>

<body class="sarchbody">

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="/task/index_1.jsp">首页</a>
			</li>
			<li>系统设置
			</li>
		</ul>
	</div>

	<div class="formbody">

		<div id="usual1" class="usual">

			<ul class="seachform1">
				<li class="sarchbtn"><label></label><input name=""
					type="button" class="scbtn" value="新增入库单" onclick="openAdd();" />
				</li>
			</ul>

			<script language="javascript">
				$(document).ready(function() {
					$(".scbtn1").click(function() {
						if ($(".seachform2").hasClass("hideclass")) {
							$(".seachform2").removeClass("hideClass");
						} else {
							$(".seachform2").addClass("hideClass");
						}
					});
				});
			</script>


			<script type="text/javascript">
				$(document).ready(function() {
					$(".scbtn1").click(function() {
						$(".seachform2").fadeIn(200);
					});

				});
			</script>




			<div class="formtitle">
				<span>仓库信息列表</span>
			</div>

			<form name="form1" id="form1"
				action="<%=path%>/servlet/InStoreServlet?action=3&id=storeno"
				method="post">
				<ul class="prosearch">

					<li><label>查询：</label><i>入库单号</i><a><input name="storeno"
							id="storeno" type="text" class="scinput" /> </a><a><input
							name="select_btn" type="submit" class="sure" value="查询"
							onclick="checkNull()" /> </a></li>

				</ul>
			</form>
			<div class="formtitle1">
				<span>仓库信息表</span>
			</div>

			<table class="tablelist">
				<thead>
					<tr>
						
						<th>序号</th>
						<th>入库单号</th>
						<th>入库类型</th>
						<th>入库负责人</th>
						<th>商品编号</th>
						<th>商品名称</th>
						<th>单价</th>
						<th>数量</th>
						<th>总金额</th>
						<th>入库时间</th>
						<th>供应商</th>
						<th>描述</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<%
						List<InStore> inStoreList = (List<InStore>) request
								.getAttribute("inStoreList");
						int orderNum = 0;
						for (int i = 0; inStoreList != null && i < inStoreList.size(); i++) {
							InStore m = inStoreList.get(i);
							orderNum++;
					%>
					<tr>
						
						<td><%=(orderNum)%></td>
						<td><%=m.getStoreno()%></td>
						<td><%=m.getStoretype()%></td>
						<td><%=m.getStoremgr()%></td>
						<td><%=m.getGoodsid()%></td>
						<td><%=m.getGoodsname()%></td>
						<td><%=m.getGoodsprice()%></td>
						<td><%=m.getGoodsamount()%></td>
						<td><%=m.getGoodsmoney()%></td>
						<td><%=m.getStoretime()%></td>
						<td><%=m.getSupplier() %></td>
						<td><%=m.getDescription()%></td>

						<td><a
							href="<%=path%>/page/instore/instore_edit.jsp?id=<%=m.getStoreno()%>"
							class="tablelink">修改</a> <a
							href="<%=path%>/servlet/InStoreServlet?action=2&storeno=<%=m.getStoreno()%>"
							class="tablelink"> 删除</a>
						</td>
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
