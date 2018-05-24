package net.line.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import com.sun.xml.internal.bind.v2.runtime.Location;

import net.line.common.Time;
import net.line.manager.UserManager;
import net.line.model.User;

public class UserServlet extends HttpServlet {

	private UserManager userManager = new UserManager();
	private String userid;
	private String pwd;
	private String job;
	private Time t = new Time();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		System.out.println("执行UserServlet");
		String action = request.getParameter("action");// 1表示添加，2表示更新，3表示删除，4表示查询,5更新,0表示登录
		System.out.println("action:" + action);
		switch (Integer.parseInt(action)) {
		case 0:
			this.login(request, response);
			break;
		case 1:

			this.addUser(request, response);
			this.listUser(request, response);
			break;
		case 2:
			this.findUser(request, response);

			break;
		case 3:
			this.delUser(request, response);
			this.listUser(request, response);
			break;
		case 4:
			this.listUser(request, response);
			break;
		case 5:
			this.edit(request, response);
			this.listUser(request, response);
			break;
		case 6:
			// this.save
			break;
		default:
			break;
		}

	}

	/**
	 * 修改用户
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void edit(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		String job = request.getParameter("job");
		
		userManager.editUser(userid, pwd, job);

	}

	/**
	 * 用户登录
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void login(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		response.setContentType("text/html;charset=utf-8");
		// 获取请求的上下文路径
		String path = request.getContextPath();
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		String job = request.getParameter("job");
		String time = t.getTime();

		// String code=request.getParameter("randomString");
		System.out.println("当前时间：" + time);
		request.getSession().setAttribute("LoginTime", time);
		// 获得request对象code的值
		String checkcode = request.getParameter("code");
		// 获得session记住的randomString的值
		String code = (String) request.getSession()
				.getAttribute("randomString");
		System.out.println(code + "" + checkcode);
		// 验证用户输入验证码是否正确
		if (!code.equalsIgnoreCase(checkcode) || checkcode == null) {
			// 进来表示不正确
			PrintWriter out = response.getWriter();
			out.print("<script type='text/Javascript'>alert('验证码错误，请重新输入！');location.href='/task/login.jsp'</script>");
			out.flush();
			out.close();
			return;
		}
		// 验证码正确后校验用户信息
		// 调用UserManager的用户校验方法，如果返回值为true，则跳转到主页，否则返回的登录页面
		boolean flag = userManager.checkUser(userid, pwd, job);
		//密码或用户名错误提示
		if(flag==false){
			PrintWriter out = response.getWriter();
			out.print("<script type='text/Javascript'>alert('密码或用户名错误错误，请重新输入！');location.href='/task/login.jsp'</script>");
			out.flush();
			out.close();
			return;
		}
		System.out.println("job:" + job);

		// 判断登录用户名的权限，销售员跳转到销售员界面sindex.jsp，管理员或超级管理员跳转到index.jsp
		if (job.equals("销售员")) {
			if (flag) {
				// 用session记住销售员名字
				request.getSession().setAttribute("LoginName", userid);
				response.sendRedirect(path + "/sindex.jsp");
				System.out.println("跳转到sindex.jsp");
			} else {
				response.sendRedirect(path + "/login.jsp");
			}
		} else if ( job.equals("超级管理员")) {
			if (flag) {
				System.out.println("执行到这。。");
				request.getSession().setAttribute("LoginName", userid);
				response.sendRedirect(path + "/index.jsp");
				System.out.println("跳转到index.jsp");
			} else {
				response.sendRedirect(path + "/login.jsp");
			}
		}else if(job.equals("管理员")){
			if(flag){
				request.getSession().setAttribute("LoginName", userid);
				response.sendRedirect(path+"/mindex.jsp");
				System.out.println("跳转到mindex.jsp");
			}else{
				response.sendRedirect(path+"/login.jsp");
			}
		}

	}

	/**
	 * 用户add
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	private void addUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,
			ServletException {

		// ʹ使用request对象的getParameter方法接收http参数
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		String job = request.getParameter("job");
		// 调用UserManager的用户add方法
		userManager.addUser(userid, pwd, job);

	}

	/**
	 * �û��༭
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	private void findUser(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		try {
			// 使用request对象的getParamater方法接收http参数
			String userid = request.getParameter("userid");
			String pwd = request.getParameter("pwd");
			String job = request.getParameter("job");

			User user = userManager.findUserByUserid(userid);
			request.setAttribute("user", user);
			RequestDispatcher rd = request
					.getRequestDispatcher("/page/user/user_edit.jsp");
			rd.forward(request, response);
		} catch (IOException e) {
			throw e;
		} catch (ServletException e) {
			throw e;
		}

	}

	/**
	 * 删除用户
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void delUser(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// 解决接收中文乱码
		String userid = new String(request.getParameter("userid").getBytes(
				"ISO-8859-1"), "UTF-8");
		System.out.println("userid:" + userid);

		userManager.delUser(userid);

	}

	/**
	 * 显示用户列表
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void listUser(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		// 初始化
		UserManager userManager = new UserManager();
		String id=request.getParameter("userid");
		//String job=request.getParameter("job");
		//List<User> userList=userManager.findAll(userid);
		List<User> userList=userManager.findAll(id);
		if(userList.size()==0){
			userList=userManager.findAll(null);
		}
		request.setAttribute("userList", userList);
		// 重定向转发
		RequestDispatcher rd = request.getRequestDispatcher("/page/user/user_list.jsp");
		rd.forward(request, response);
		System.out.println("显示用户信息..");
	}
}
