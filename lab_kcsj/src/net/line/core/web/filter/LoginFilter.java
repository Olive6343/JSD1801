package net.line.core.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {
	private FilterConfig user;
	public void destroy() {
		

	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		
		
		System.out.println("登录过滤器执行.....");
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)resp;
		HttpSession httpsession=request.getSession();
		req.setCharacterEncoding("utf-8");
		
		//String userid1=(String)httpsession.getAttribute("LoginName");
		//String checkuserid=request.getParameter("userid");
		String id = (String) request.getSession().getAttribute("LoginName");
		//String uerid=(String)request.getAttribute("userid");
		System.out.println("userid="+id);
		if(id!=null){
			//response.sendRedirect("/task/login.jsp");
			chain.doFilter(request, response);

		}else{
			//chain.doFilter(request, response);
			response.sendRedirect("/task/login.jsp");
		}
	}

	public void init(FilterConfig user) throws ServletException {
		System.out.println("过滤器初始化1");
		this.setUser(user);

	}

	public FilterConfig getUser() {
		return user;
	}

	public void setUser(FilterConfig user) {
		this.user = user;
	}
	
}
