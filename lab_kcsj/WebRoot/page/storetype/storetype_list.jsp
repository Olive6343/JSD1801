<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="net.line.model.*"%>
<%@ page import="net.line.manager.*"%>
<%@ include file="/util/common.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

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
		if (form1.stNo.value == "") {
			alert("请输入要查询的仓库号！");
			form1.stNo.focus();
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
	
window.location.href="<%=path%>/page/storetype/storetype_add.jsp";
	}
</script>
</head>

<body class="sarchbody">

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="/task/index_1.jsp">首页</a></li>
			<li>仓库信息列表</li>
		</ul>
	</div>

	<div class="formbody">

		<div id="usual1" class="usual">

			<ul class="seachform1">
				<li class="sarchbtn"><label></label><input name=""
					type="button" class="scbtn" value="新增仓库" onclick="openAdd();" />
				</li>
			</ul>

			<form name="form1" id="form1"
				action="<%=path%>/servlet/StoreTypeServlet?action=3&id=stNo" method="post">
				<ul class="prosearch">

					<li><label>查询：</label><i>仓库号</i><a><input name="stNo"
							id="stNo" type="text" class="scinput" /><br> </a><a><input
							name="select_btn" type="submit" class="sure" value="查询"
							onclick="checkNull()" /> </a>
					</li>

				</ul>
			</form>

			<div class="formtitle">
				<span>仓库类型信息列表</span>
			</div>

			<table class="tablelist">
				<thead>
					<tr>
						
						<th>序号</th>
						<th>仓库号</th>
						<th>仓库类型</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<%
						List<StoreType> storeTypeList = (List<StoreType>) request
								.getAttribute("storeTypeList");
						int orderNum = 0;
						for (int i = 0; storeTypeList != null && i < storeTypeList.size(); i++) {
							StoreType m = storeTypeList.get(i);
							orderNum++;
					%>
					<tr>
						<td><%=(orderNum)%></td>
						<td><%=m.getStNo()%></td>
						<td><%=m.getStoreType()%></td>

						<td><a
							href="<%=path%>/page/storetype/storetype_edit.jsp?id=<%=m.getStNo()%>"
							class="tablelink">修改</a> <a
							href="<%=path%>/servlet/StoreTypeServlet?action=2&stNo=<%=m.getStNo()%>"
							class="tablelink"> 删除</a></td>
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
