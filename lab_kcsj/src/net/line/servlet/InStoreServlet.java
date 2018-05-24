package net.line.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.line.common.TNo;
import net.line.common.Time;
import net.line.manager.InStoreManager;
import net.line.model.InStore;

public class InStoreServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	InStoreManager inStoreManager = new InStoreManager();
	String sql=null;
	Time time = new Time();
	TNo tNo = new TNo();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("提交方式" +req.getMethod());
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 解决中文乱码
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("UTF-8");
		System.out.println("执行InStoreServlet");
		String action=req.getParameter("action");//0，1新增销售员，2删除销售员，3查询销售员，4修改销售员
		System.out.println("action:"+action);
		switch (Integer.parseInt(action)) {
		case 0:

			break;
		case 1:
			this.addInStore(req, resp);
			this.listInStore(req, resp);
			break;
		case 2:
			this.delInStore(req, resp);
			this.listInStore(req, resp);
			break;
		case 3:
			this.listInStore(req, resp);
			break;
		case 4:
			this.editInStore(req, resp);
			this.listInStore(req, resp);
			break;
		case 5:
			//this.listInStoreType(req, resp);
		case 6:
			this.listSupplier(req, resp);
		default:
			break;
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
	private void addInStore(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, ServletException, IOException {
		// 接收Sale人Manager的对象
		String storeno =tNo.getTNo();
		String storetype = req.getParameter("storetype");
		String storemgr = req.getParameter("storemgr");
		String goodsid = req.getParameter("goodsid");
		String goodsname = req.getParameter("goodsname");
		String goodsprice = req.getParameter("goodsprice");
		String goodsamount = req.getParameter("goodsamount");
		String goodsmoney = (Float.parseFloat(goodsprice)*Float.parseFloat(goodsamount))+"";
		String supplier = req.getParameter("supplier");
		String storetime = time.getTime();//获取当前系统时间
		String description = req.getParameter("description");

		inStoreManager.addInStore(storeno, storetype, storemgr, goodsid,
				goodsname, goodsprice, goodsamount, goodsmoney, supplier,
				storetime, description);
		System.out.println("添加入库信息：" + storeno);
	}

	/**
	 * 删除销售员
	 * 
	 * @param req
	 * @param resp
	 */
	private void delInStore(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		// req.setCharacterEncoding("UTF-8");
		// 解决接收中文乱码
		String storeno = new String(req.getParameter("storeno").getBytes(
				"ISO-8859-1"), "utf-8");
		System.out.println("删除采购单号为：" + storeno);

		inStoreManager.delInStore(storeno);

	}

	/**
	 * 修改InStore
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	private void editInStore(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		// req接收属性的值
		
		String storeno =req.getParameter("storeno");
		String storetype = req.getParameter("storetype");
		String storemgr = req.getParameter("storemgr");
		String goodsid = req.getParameter("goodsid");
		String goodsname = req.getParameter("goodsname");
		String goodsprice = req.getParameter("goodsprice");
		String goodsamount = req.getParameter("goodsamount");
		String goodsmoney = (Float.parseFloat(goodsprice)*Float.parseFloat(goodsamount))+"";
		String supplier = req.getParameter("supplier");
		String storetime = time.getTime();
		String description = req.getParameter("description");
		System.out.println("修改入库单号为："+storeno);
		inStoreManager.editInStore(storeno, storetype, storemgr, goodsid,
				goodsname, goodsprice, goodsamount, goodsmoney, supplier,
				storetime, description);
	}

	
	/**
	 * 显示入库信息
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @throws ServletException
	 */
	public void listInStore(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		InStoreManager inStoreManager=new InStoreManager();
		String storeno=req.getParameter("storeno");
		List<InStore> inStoreList=inStoreManager.find(storeno);
		if(inStoreList.size()==0){
			inStoreList=inStoreManager.find(null);
		}
		req.setAttribute("inStoreList",inStoreList);
		RequestDispatcher rd=req.getRequestDispatcher("/page/instore/instore_list.jsp");
		rd.forward(req, resp);
		System.out.println("显示入库信息：" );
	}
		
	
//	public void listInStoreType(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
//		List<InStore> istypeList=new ArrayList<InStore>();
//		istypeList=inStoreManager.findStoreType();
//		req.setAttribute("istypeList", istypeList);
//		RequestDispatcher rd=req.getRequestDispatcher("/page/instore/instore_add.jsp");
//		rd.forward(req, resp);
//	}
	
	public void listSupplier(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		List<InStore> istypeList=new ArrayList<InStore>();
		istypeList=inStoreManager.findSupplier();
		req.setAttribute("istypeList", istypeList);
		RequestDispatcher rd=req.getRequestDispatcher("/page/instore/instore_add.jsp");
		rd.forward(req, resp);
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
