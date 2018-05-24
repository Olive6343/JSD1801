package com.entor.uims.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entor.uims.domain.User;
import com.entor.uims.service.UserService;

/**
 * Servlet implementation class AddUserServlet
 */
@WebServlet("/addUser")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserService();
       
    public AddUserServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.设置请求参数编码格式
		request.setCharacterEncoding("utf-8");
		//2.获取参数
		String loginname = request.getParameter("loginname");
		String password = request.getParameter("password");
		String realname = request.getParameter("realname");
		String authority = request.getParameter("authority");
		
		//3.判断用户是否存在
		String message = "";
		if(userService.isLoginNameExist(loginname)){
			message = "用户已存在，请更换登录名！";
		}else{
			//4.添加用户
			User user = new User();
			user.setLoginName(loginname);
			user.setPassword(password);
			user.setRealName(realname);
			user.setAuthority(Integer.parseInt(authority));
			userService.saveUser(user);
			
			message = "增加成功，返回列表查看！";
			
			
		}
		// 返回添加页面
		request.setAttribute("message", message);
		request.getRequestDispatcher("addUser.jsp").forward(request, response);
	}
}
