<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="net.line.model.*"%>
<%@ page import="net.line.manager.*"%>
<%@ include file="/util/common.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
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
	
window.location.href="<%=path%>/page/user/user_add.jsp";	
}

</script>

<script type="text/javascript">
    KE.show({
        id : 'content7',
        cssPath : './index.css'
    });
    
    
       function checkNull() {
		if ( from1.job.value== "") {
			alert("请输入要查询的权限！");
			form1.job.focus();
			return;
		}else{
		form1.submit();
		}
	}
  </script>

</head>

<body class="sarchbody">

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="/task/index_1.jsp">首页</a></li>
    <li>用户管理</li>
    </ul>
    </div>
    
    <div class="formbody">
    
    
    <div id="usual1" class="usual"> 
    
    
    

    

    
    <ul class="seachform1">
    <li class="sarchbtn"><label></label><input name="" type="button" class="scbtn" value="新增用户" onclick="openAdd();" />  </li>  
    </ul>
    
    <script language="javascript">
	$(document).ready(function() 
{ 
    $(".scbtn1").click(function() 
    {      
        if( $(".seachform2").hasClass("hideclass") ) 
        { 
            $(".seachform2").removeClass("hideClass"); 
        } 
        else 
        { 
            $(".seachform2").addClass("hideClass"); 
        }    
    }); 
}); 
	
	
	</script>
    
    
    <script type="text/javascript">
$(document).ready(function(){
  $(".scbtn1").click(function(){
  $(".seachform2").fadeIn(200);
  }); 


});
</script>

	<form name="form1" id="form1"
				action="<%=path%>/servlet/UserServlet?action=4&id=userid"
				method="post">
				<ul class="prosearch">

					<li><label>查询：</label>
							<i>用户名</i><a><input name="userid"
							id="userid" type="text" class="scinput" /> </a>
							<a><input
							name="select_btn" type="submit" class="sure" value="查询"
							onclick="checkNull()" /> </a></li>

				</ul>
			</form>


    <div class="formtitle"><span>用户信息列表</span></div>
    
    <table class="tablelist">
    	<thead>
    	<tr>
        <th>编号</th>
        <th>用户名</th>
        <th>密码</th>
        <th>权限</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <%
        List<User> userList=(List<User>)request.getAttribute("userList");
		 int orderNum=0;
		for(int i=0;userList!=null&&i<userList.size();i++){
			 User m=userList.get(i);
			 orderNum++;
		%>
        <tr>
          <td><%=(orderNum)%></td>
          <td><%=m.getUserid()%></td>
          <td><%=m.getPwd()%></td>
          <td><%=m.getJob()%></td>
          <td><a href="<%=path%>/page/user/user_edit.jsp?id=<%=m.getUserid() %>" class="tablelink">修改</a>  
             <a href="<%=path %>/servlet/UserServlet?action=3&userid=<%=m.getUserid() %>" class="tablelink"> 删除</a></td>
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
