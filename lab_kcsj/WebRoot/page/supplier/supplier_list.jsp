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
		if (form1.spId.value == "") {
			alert("请输入要查询的供应商编号！");
			form1.spId.focus();
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
	
window.location.href="<%=path%>/page/supplier/supplier_add.jsp";
	}
</script>
</head>

<body class="sarchbody">

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="/task/index_1.jsp">首页</a>
			</li>
			<li>供应商信息列表</li>
		</ul>
	</div>

	<div class="formbody">

		<div id="usual1" class="usual">

			<ul class="seachform1">
				<li class="sarchbtn"><label></label><input name=""
					type="button" class="scbtn" value="新增供应商" onclick="openAdd();" />
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
				<span>供应商信息列表</span>
			</div>

			<form name="form1" id="form1"
				action="<%=path%>/servlet/SupplierServlet?action=3&id=spId"
				method="post">
				<ul class="prosearch">

					<li><label>查询：</label><i>供应商编号</i><a><input name="spId"
							id="spId" type="text" class="scinput" /> </a><a><input
							name="select_btn" type="submit" class="sure" value="查询"
							onclick="checkNull()" /> </a></li>

				</ul>
			</form>
			<div class="formtitle1">
				<span>供应商信息表</span>
			</div>

			<table class="tablelist">
				<thead>
					<tr>
						
						<th>序号</th>
						<th>供应商编号</th>
						<th>供应商名称</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<%
						List<Supplier> spList = (List<Supplier>) request
								.getAttribute("spList");
						int orderNum = 0;
						for (int i = 0; spList != null && i < spList.size(); i++) {
							Supplier s = spList.get(i);
							orderNum++;
					%>
					<tr>
						<td><%=(orderNum)%></td>
						<td><%=s.getSpId()%></td>
						<td><%=s.getSpName()%></td>
						

						<td><a
							href="<%=path%>/page/supplier/supplier_edit.jsp?id=<%=s.getSpId()%>"
							class="tablelink">修改</a> <a
							href="<%=path%>/servlet/SupplierServlet?action=2&spId=<%=s.getSpId()%>"
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
