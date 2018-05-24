package net.line.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.line.common.TNo;
import net.line.manager.StoreTypeManager;
import net.line.model.StoreType;

public class StoreTypeServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	StoreTypeManager storeTypeManager = new StoreTypeManager();
	TNo tNo=new TNo();
	String url = null;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//System.out.println("提交方式" + req.getMethod());

		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		System.out.println("执行StoreTypeManager");
		// System.out.println("提交方式"+req.getMethod());
		String action = req.getParameter("action");// 0登录，1新增仓库类型，2删除仓库类型，3查询仓库类型，4修改仓库类型
		System.out.println("action:" + action);
		switch (Integer.parseInt(action)) {
		case 0:
			// this.login(req, resp);
			break;
		case 1:
			this.addStoreType(req, resp);
			this.listStoreType(req, resp);
			break;
		case 2:
			this.delStoreType(req, resp);
			this.listStoreType(req, resp);
			break;
		case 3:
			this.listStoreType(req, resp);
			break;
		case 4:
			this.editStoreType(req, resp);
			this.listStoreType(req, resp);
			break;

		default:
			break;
		}
	}

	/**
	 * 新增仓库类型
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws ServletException
	 * @throws IOException
	 */
	private void addStoreType(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, ServletException, IOException {
		// 接收Sale人Manager的对象
		String stNo = tNo.getTNo();
		String storeType = req.getParameter("storeType");
		//System.out.println("仓库号是：" + stNo);
		storeTypeManager.addStoreType(stNo,storeType);
		System.out.println("添加仓库信息的仓库号为："+stNo);
	}

	/**
	 * 删除仓库类型
	 * 
	 * @param req
	 * @param resp
	 */
	private void delStoreType(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		// req.setCharacterEncoding("UTF-8");
		// 解决接收中文乱码
		String stNo = new String(req.getParameter("stNo")
				.getBytes("ISO-8859-1"), "utf-8");
		System.out.println("仓库类型：" + stNo);

		storeTypeManager.delStoreType(stNo);

	}

	/**
	 * 修改仓库类型
	 * 
	 * @param req
	 * @param resp
	 */
	private void editStoreType(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		String stNo = req.getParameter("stNo");
		String storeType = req.getParameter("storeType");

		System.out.println("修改仓库类型：" + stNo);
		storeTypeManager.editStoreType(stNo, storeType);

	}

	/**
	 * 显示仓库类型
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @throws ServletException
	 */
	private void listStoreType(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {

		StoreTypeManager storeTypeManager = new StoreTypeManager();
		String stNo = req.getParameter("stNo");
		//System.out.println("stNo:"+stNo);
		List<StoreType> storeTypeList = storeTypeManager.find(stNo);
		if (storeTypeList.size() ==0) {
			storeTypeList = storeTypeManager.find(null);
		}
		req.setAttribute("storeTypeList", storeTypeList);
		RequestDispatcher rd = req.getRequestDispatcher("/page/storetype/storetype_list.jsp");
		rd.forward(req, resp);
		System.out.println("显示仓库类型成功");

	}

}
