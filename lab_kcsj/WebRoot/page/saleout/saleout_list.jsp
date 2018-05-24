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
    
    
       function checkNull() {
		if (form1.saleNo.value == "") {
			alert("请输入要查询的销售单号！");
			form1.saleNo.focus();
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
	
window.location.href="<%=path%>/page/saleout/saleout_add.jsp";	
}

</script>
</head>

<body class="sarchbody">

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li>首页</li>
    <li>销售信息列表</li>
    </ul>
    </div>
    
   
    
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

    
    
    
    <div class="formtitle"><span>销售信息列表</span></div>
    
    <form name="form1" id="form1"
			action="<%=path%>/servlet/SaleOutServlet?action=3" method="post">
			<ul class="prosearch">
				
				<li><label>查询：</label><i>销售单号</i><a><input name="saleNo" id="saleNo"
						type="text" class="scinput" />
				</a><a><input name="select_btn" type="button" class="sure"
						value="查询" onclick="checkNull()" />
				</a>
				</li>

			</ul>
		</form>
		<div class="formtitle1">
			<span>销售信息表</span>
		</div>
    
    <table class="tablelist">
    	<thead>
    	<tr>
        <th>序号</th>
        <th>销售单号</th>
        <th>销售人</th>
        <th>销售时间</th>
        <th>商品名称</th>
        <th>数量</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <%
        List<SaleOut> saleOutList=(List<SaleOut>)request.getAttribute("saleOutList");
		 int orderNum=0;
		for(int i=0;saleOutList!=null&&i<saleOutList.size();i++){
			 SaleOut m=saleOutList.get(i);
			 orderNum++;
			 //<td>${LoginName}</td>
		%>
        <tr>
          <td><%=(orderNum)%></td>
          <td><%=m.getSaleNo()%></td>
          <td><%=m.getSaleName()%></td>
          
          <td><%=m.getSaleTime()%></td> 
          <td><%=m.getGoodsName()%></td>
          <td><%=m.getAmount()%></td>
          
          <td><a href="<%=path%>/page/saleout/saleout_edit.jsp?id=<%=m.getSaleNo() %>" class="tablelink">修改</a>  
             <a href="<%=path %>/servlet/SaleOutServlet?action=2&storeno=<%=m.getSaleNo()  %>" class="tablelink"> 删除</a></td>
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
