package net.line.common;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class IdentityServlet extends HttpServlet {
	// 随机字符字典
	public static final char[] CHARS = { '0', '2', '3', '4', '5', '6',
			'7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
			'k', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
			'x', 'y', 'z' };
	public static Random random = new Random(); // 随机数

	public String getRandomString() { // 获取4位随机数
		StringBuffer buffer = new StringBuffer(); // 字符串缓存
		for (int i = 0; i < 4; i++) { // 循环4次
			// 每次去一个随机数
			buffer.append(CHARS[random.nextInt(CHARS.length)]);
		}
		return buffer.toString();
	}

	public static Color getRandomColor() { // 获取随机的颜色
		return new Color(random.nextInt(255), random.nextInt(255),
				random.nextInt(255));
	}

	public Color getReverseColor(Color color) { // 返回某颜色的反色
		return new Color(255 - color.getRed(), 255 - color.getGreen(),
				255 - color.getBlue());
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException { // GET方法
		// TODO Auto-generated method stub
		System.out.println("执行doget方法");
		resp.setContentType("image/jpeg"); // 设置输出类型，必需的
		String randomString = getRandomString(); // 随机字符串
		System.out.println("rand+"+randomString);
		
		// 放到session中
		req.getSession(true).setAttribute("randomString", randomString);
		int width = 100; // 图片宽度
		int height = 30; // 图片高度
		Color color=getRandomColor();// 随机颜色，用于背景色
		//Color color = new Color(255,255,240); //固定白色
		Color reverse = getReverseColor(color); // 反色，用于前景色
		System.out.println("color"+color);
		// 创建一个彩色图片
		BufferedImage bi = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_BGR);
		Graphics2D g = bi.createGraphics(); // 获取绘画对象
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24)); // 设置字体
		g.setColor(color); // 设置颜色
		g.fillRect(0, 0, width, height); // 设置背景
		g.setColor(reverse); // 设置反色
		g.drawString(randomString, 18, 20); // 绘制随机字符
		// 画最多100个噪音点
		for (int i = 0, n = random.nextInt(100); i < n; i++) {
			// 随机噪音点
			g.drawRect(random.nextInt(width), random.nextInt(height), 1, 1);
		}
		ServletOutputStream out = resp.getOutputStream();
		// 转成JPEG格式
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
		// 编码器
		encoder.encode(bi); // 对图片进行
		out.flush(); // 输出到客户端
	}

}
