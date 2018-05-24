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
	
window.location.href="<%=path%>/page/saler/saler_add.jsp";	
}

</script>
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="/task/index_1.jsp">首页</a></li>
    <li>销售员管理</li>
    </ul>
    </div>
    
    <div class="formbody">
    
    
    <div id="usual1" class="usual"> 

    <ul class="seachform1">
    <li class="sarchbtn"><label></label><input name="" type="button" class="scbtn" value="新增销售员" onclick="openAdd();" />  </li>  
    </ul>

<form name="form1" id="form1"
			action="<%=path%>/editSaler?action=select" method="post">
			<ul class="prosearch">
				
				<li><label>查询：</label><i>销售员编号</i><a><input name="salerNo" id="salerNo"
						type="text" class="scinput" /><br>
			
				</a><a><input name="select_btn" type="button" class="sure"
						value="查询" onclick="checkNull()" />
				</a>
				</li>

			</ul>
		</form>

    <div class="formtitle"><span>销售员信息列表</span></div>
    
    <table class="tablelist">
    	<thead>
    	<tr>
        <th>序号</th>
        <th>销售员编号</th>
        <th>销售员名字</th>
        <th>密码</th>
        <th>性别</th>
        <th>电话</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <%
        List<Saler> salerList=(List<Saler>)request.getAttribute("salerList");
		 int orderNum=0;
		for(int i=0;salerList!=null&&i<salerList.size();i++){
			 Saler m=salerList.get(i);
			 orderNum++;
		%>
        <tr>
          <td><%=(orderNum)%></td>
          <td><%=m.getSalerNo()%></td>
          <td><%=m.getSalerName()%></td>
          <td><%=m.getSalerPwd()%></td>
          <td><%=m.getSalerSex()%></td>
          <td><%=m.getSalerTel()%></td>
          <td><a href="<%=path%>/page/saler/saler_edit.jsp?id=<%=m.getSalerNo() %>" class="tablelink">修改</a>     <a href="<%=path %>/servlet/SalerServlet?action=2&salerNo=<%=m.getSalerNo() %>" class="tablelink"> 删除</a></td>
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
