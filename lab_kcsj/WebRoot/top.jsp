<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<style type="text/css">
#apDiv1 {
	position: absolute;
	width: 308px;
	height: 89px;
	z-index: 1;
	left: 3px;
	top: -2px;
}
#apDiv2 {
	position: absolute;
	width: 107px;
	height: 42px;
	z-index: 2;
	font-size: 24pt;
	font-weight: bold;
	font-family: "微软雅黑";
	font-style: italic;
}

body,td,th {
	font-family: "方正兰亭超细黑简体";
	color: #FFFFCC;
	font-size: 5.5px;
}
#apDiv8 {
	position: absolute;
	width: 200px;
	height: 36px;
	z-index: 1;
	left: 97px;
	top: 27px;
	font-size: 18pt;
}
#apDiv9 {
	position: absolute;
	width: 204px;
	height: 18px;
	z-index: 2;
	left: 96px;
	top: 60px;
	font-size: 5pt;
}
</style>
<script language="JavaScript" src="js/jquery.js"></script>
<script type="text/javascript">
$(function(){	
	//顶部导航切换
	$(".nav li a").click(function(){
		$(".nav li a.selected").removeClass("selected");
		$(this).addClass("selected");
	});	
});	
</script>


</head>

<body style="background: url(images/topbg.gif) repeat-x; font-family: '微软雅黑'; color: #FFFFCC;">

    <div class="topleft">
      <div id="apDiv1"><img src="images/logo11.png" width="88" height="88" />
        <div id="apDiv8">图书管理系统</div>
        <div class="div9" id="apDiv9">PURCHASE-SALE-STOCK MANAGEMENT SYSTEM GUI</div>
      </div>
</div>
        
    <ul class="nav">
   
    </ul>
            
    <div class="topright">    
    <ul>
    <li><span><img src="images/help.png" title="帮助"  class="helpimg"/></span><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
    <li><a href="login.jsp" target="_parent">退出</a></li>
    </ul>
     
    <div class="user">
    <span>${LoginName}</span>
    <i>您好！</i>
  
    </div>    
    
    </div>

</body>
</html>
