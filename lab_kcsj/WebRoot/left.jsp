<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>

<script type="text/javascript">
$(function(){	
	//导航切换
	$(".menuson .header").click(function(){
		var $parent = $(this).parent();
		$(".menuson>li.active").not($parent).removeClass("active open").find('.sub-menus').hide();
		
		$parent.addClass("active");
		if(!!$(this).next('.sub-menus').size()){
			if($parent.hasClass("open")){
				$parent.removeClass("open").find('.sub-menus').hide();
			}else{
				$parent.addClass("open").find('.sub-menus').show();	
			}
			
			
		}
	});
	
	// 三级菜单点击
	$('.sub-menus li').click(function(e) {
        $(".sub-menus li.active").removeClass("active");
		$(this).addClass("active");
    });
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('.menuson').slideUp();
		if($ul.is(':visible')){
			$(this).next('.menuson').slideUp();
		}else{
			$(this).next('.menuson').slideDown();
		}
	});
});
</script>


</head>

<body style="background:#f0f9fd;">
	<div class="lefttop"><span></span>通讯录</div>
    
    <dl class="leftmenu">
        
    <dd>
    <div class="title">
    <span><img src="images/leftico01.png" /></span>系统管理
    </div>
    	<ul class="menuson">
        <li><cite></cite><a href="/task/servlet/UserServlet?action=4" target="rightFrame">用户管理</a><i></i></li>
        </ul>    
    </dd>
    
    
    <dd>
    <div class="title">
    <span><img src="images/leftico01.png" />
    </span>仓库管理
    </div>
    	 <ul class="menuson">
        <li><cite></cite><a href="/task/servlet/StoreTypeServlet?action=3" target="rightFrame">仓库信息</a><i></i></li>
        </ul> 
    	   
    </dd> 
    
    
    <dd>
    <div class="title">
    <span><img src="images/leftico01.png" /></span>物料管理
    </div>
    	<ul class="menuson">
    	<li><cite></cite><a href="/task/servlet/GoodsServlet?action=3" target="rightFrame">商品信息管理</a><i></i></li>
        </ul>    
    </dd>
    
    
    <dd>
    <div class="title">
    <span><img src="images/leftico01.png" /></span>供应商管理
    </div>
    	<ul class="menuson">
        <li><cite></cite><a href="/task/servlet/SupplierServlet?action=3" target="rightFrame">供应商信息</a><i></i></li>
        </ul>    
    </dd> 
    
    
    <dd>
    <div class="title">
    <span><img src="images/leftico02.png" /></span>销售管理 </div>
    <ul class="menuson">
        <li><cite></cite><a href="/task/page/saleout/saleout_add.jsp" target="rightFrame">销售登记</a><i></i></li>
        <li><cite></cite><a href="/task/servlet/SaleOutServlet?action=3" target="rightFrame">销售记录表</a><i></i></li>
        <li><cite></cite><a href="/task/servlet/SaleOutServlet?action=6" target="rightFrame">销售商品明细</a><i></i></li>

    </ul>
   
     
    </dd> 
    
    <dd><div class="title"><span><img src="images/leftico04.png" /></span>库存管理</div>
    <ul class="menuson">
        <li><cite></cite><a href="/task/page/instore/instore_add.jsp" target="rightFrame">入库登记</a><i></i></li>
		<li><cite></cite><a href="/task/servlet/InStoreServlet?action=3" target="rightFrame">入库信息管理</a><i></i></li>
    </ul>
    
    </dd>   
    
    </dl>
    
</body>
</html>
