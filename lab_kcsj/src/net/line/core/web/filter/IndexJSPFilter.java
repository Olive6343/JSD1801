package net.line.core.web.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.Request;

public class IndexJSPFilter implements Filter {
	private FilterConfig user2;
	public void destroy() {
		
}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {

		System.out.println("登录过滤器执行.LoginServletFilter....");

		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)resp;
		HttpSession httpSession=request.getSession();
		response.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");

		String id = (String) request.getSession().getAttribute("LoginName");
		String uerid=(String)request.getAttribute("userid");
		System.out.println("id="+id);
		if(id!=null){
			chain.doFilter(request, response);
		}else{
			PrintWriter out = response.getWriter();
			out.print("<script type='text/Javascript'>alert('您还没有登录，请先登录！');</script>");
			//out.flush();
			//out.close();
			response.sendRedirect("/task/login.jsp");
		}
		
	}

	public void init(FilterConfig user2) throws ServletException {
		System.out.println("过滤器初始化2");
		this.setUser2(user2);
	}

	/**
	 * @return the user2
	 */
	public FilterConfig getUser2() {
		return user2;
	}

	/**
	 * @param user2 the user2 to set
	 */
	public void setUser2(FilterConfig user2) {
		this.user2 = user2;
	}

}
