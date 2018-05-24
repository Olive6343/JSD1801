<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ page contentType="image/jpeg" import="java.awt.*,java.awt.image.*,java.util.*,javax.imageio.*" %>
<%!
Color getRandColor(int fc,int bc){
	Random rd=new Random();
	if(fc>255) fc=255;
	if(bc>255) bc=255;
	int r=fc+rd.nextInt(bc-fc);
	int g=fc+rd.nextInt(bc-fc);
	int b=fc+rd.nextInt(bc-fc);
	return new Color(r,g,b);	
	}	
 %>
 <% //设置页面不缓存
 response.setHeader("pragma", "No-cache");
 response.setHeader("Cache-Control", "No-cache");
 response.setDateHeader("Expires", 0);
 //在内存中创建图像
 int width=60,height=20;
 BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
 //获取图形上下文
 Graphics g=image.getGraphics();
 //生成岁随机类
 Random rd=new Random();
 //设置背景颜色
 g.setColor(getRandColor(200, 250));
 g.fillRect(0, 0, width, height);
 //设定字体	
 g.setFont(new Font("Time New Roman",Font.PLAIN,18));
 //随机产生干扰线
 g.setColor(getRandColor(160, 200));
 for(int i=0;i<155;i++){
 	int x=rd.nextInt(width);
 	int y=rd.nextInt(height);
 	int x1=rd.nextInt(12);
 	int y1=rd.nextInt(12);
 	g.drawLine(x, y, x+x1, y+y1);
 }
 //随机产生的验证码
 String sRand="";
 for(int i=0;i<4;i++){
 	String rand=String.valueOf(rd.nextInt(10));
 	sRand+=rand;
 	//将验证码显示到图像中
 	g.setColor(new Color(20+rd.nextInt(110),20+rd.nextInt(110),20+rd.nextInt(110)));
 	g.drawString(rand, 13*i+6, 16);
 	}
 	//将验证码存入session
 	session.setAttribute("rand", sRand);
 	g.dispose();
 	//输出图像到页面
 	ImageIO.write(image, "JPEG", response.getOutputStream());
 	out.clear();
 	out=pageContext.pushBody();
 	%>

