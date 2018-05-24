<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>


</head>
  
  <body>
   <div class="place" style="background-color: #F0FFFF;">
    <span>位置：</span>
    <ul class="placeul">
    <li>首页</li>
    </ul>
    </div>
    
    <div class="mainindex" style="font:bolder;font-size: large;height: 100%;">
    
    <div class="welinfo" > 
    <span><img src="images/time.png" alt="时间" /></span>
    <i>您上次登录的时间：${LoginTime}</i> （不是您登录的？请重新登录！）
    </div>
    
   
    


  
    </div>
  </body>
</html>
