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

public class SalerFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("登录过滤器执行.....");
		HttpServletRequest request=(HttpServletRequest)req;
		req.setCharacterEncoding("utf-8");
		HttpServletResponse response=(HttpServletResponse)resp;
		HttpSession httpsession=request.getSession();
		String job=(String)httpsession.getAttribute("job");
		if(job=="销售员"){
			chain.doFilter(req, resp);
		}
		
		response.sendRedirect("sindex.jsp");
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
