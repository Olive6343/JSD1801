package net.line.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.line.manager.SalerManager;
import net.line.model.Saler;

public class SalerServlet extends HttpServlet {
	SalerManager salerManager = new SalerManager();
	String url = null;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("提交方式" + req.getMethod());
		//System.out.println("执行SalerServlet");
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 解决中文乱码
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("UTF-8");
		System.out.println("执行SalerServlet");
		String action = req.getParameter("action");// 0登录，1新增销售员，2删除销售员，3查询销售员，4修改销售员
		System.out.println("action:" + action);
		switch (Integer.parseInt(action)) {
		case 0:
			this.login(req, resp);
			break;
		case 1:
			this.addSaler(req, resp);
			this.listSaler(req, resp);
			break;
		case 2:
			this.delSaler(req, resp);
			this.listSaler(req, resp);
			break;
		case 3:
			// this.editSaler(req, resp);
			this.listSaler(req, resp);
			break;
		case 4:
			this.editSaler(req, resp);
			this.listSaler(req, resp);
			break;

		default:
			break;
		}
	}

	private void login(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		String path = req.getContextPath();

		String salerNo = req.getParameter("salerNo");
		String salerPwd = req.getParameter("salerPwd");
		// String job =request.getParameter("job");

		boolean flag = salerManager.checkSaler(salerNo, salerPwd);

		if (flag) {

			resp.sendRedirect(path + "/index.jsp");
		} else {
			resp.sendRedirect(path + "/login.jsp");
		}

	}

	/**
	 * 新增销售员
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws ServletException
	 * @throws IOException
	 */
	private void addSaler(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, ServletException, IOException {
		// 接收Sale人Manager的对象
		String salerNo = req.getParameter("salerNo");
		String salerName = req.getParameter("salerName");
		String salerPwd = req.getParameter("salerPwd");
		String salerSex = req.getParameter("salerSex");
		String salerTel = req.getParameter("salerTel");
		System.out.println("销售员Sex" + salerSex);

		salerManager.addSaler(salerNo, salerName, salerPwd, salerSex, salerTel);
	}

	/**
	 * 删除销售员
	 * 
	 * @param req
	 * @param resp
	 */
	private void delSaler(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		// req.setCharacterEncoding("UTF-8");
		// 解决接收中文乱码
		String salerNo = new String(req.getParameter("salerNo").getBytes(
				"ISO-8859-1"), "utf-8");
		System.out.println("销售员编号：" + salerNo);

		salerManager.delSaler(salerNo);

	}

	/**
	 * 修改销售员信息
	 * 
	 * @param req
	 * @param resp
	 */
	private void editSaler(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String salerNo = req.getParameter("salerNo");
		String salerName = req.getParameter("salerName");
		String salerPwd = req.getParameter("salerPwd");
		String salerSex = req.getParameter("salerSex");
		String salerTel = req.getParameter("salerTel");
		System.out.println("salerNo：" + salerNo);
		salerManager
				.editSaler(salerNo, salerName, salerPwd, salerSex, salerTel);
		System.out.println("修改销售员信息" + salerTel);
	}

	/**
	 * 显示销售员所有信息
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @throws ServletException
	 */
	private void listSaler(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {

		// �ض��򣨲����µ�request�����е�request�Ĳ���ᶪʧ��
		SalerManager salerManager = new SalerManager();
		List<Saler> salerList = salerManager.find(null);
		req.setAttribute("salerList", salerList);
		RequestDispatcher rd = req
				.getRequestDispatcher("/page/saler/saler_list.jsp");
		rd.forward(req, resp);
		System.out.println("显示销售员信息：");

	}

	/**
	 * 转发请求并跳转页面
	 * 
	 * @param URL
	 * @param request
	 * @param response
	 */
	public void dispatch(String URL, HttpServletRequest request,
			HttpServletResponse response) {
		RequestDispatcher dispatch = getServletContext().getRequestDispatcher(
				URL);
		try {
			dispatch.forward(request, response);
			return;
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
