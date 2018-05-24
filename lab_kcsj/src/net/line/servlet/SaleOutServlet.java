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
import net.line.manager.SaleOutManager;
import net.line.model.SaleOut;

public class SaleOutServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Time time=new Time();
	TNo tNo=new TNo();
	SaleOutManager saleOutManager = new SaleOutManager();
	String sql=null;
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
		System.out.println("执行SaleOutServlet");
		String action=req.getParameter("action");//0，1新增销售员，2删除销售员，3查询销售员，4修改销售员
		System.out.println("action:"+action);
		switch (Integer.parseInt(action)) {
		case 0:

			break;
		case 1:
			this.addSaleOut(req, resp);
			this.listSaleOut(req, resp);
			break;
		case 2:
			this.delSaleOut(req, resp);
			this.listSaleOut(req, resp);
			break;
		case 3:
			this.listSaleOut(req, resp);
			break;
		case 4:
			this.editSaleOut(req, resp);
			this.listSaleOut(req, resp);
			break;
		case 5:
			this.listGoodsName(req, resp);
		case 6:
			this.listGoodsDetail(req, resp);
			break;	
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
	private void addSaleOut(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, ServletException, IOException {
		// 接收Sale人Manager的对象
		String saleNo = tNo.getTNo();
		String saleName = req.getParameter("saleName");
		String saleTime = time.getTime();
	
		String goodsNo = req.getParameter("goodsNo");
		String goodsName = req.getParameter("goodsName");
		String Price = req.getParameter("Price");
		String Amount = req.getParameter("Amount");
		String Money =(Float.parseFloat(Price)*Float.parseFloat(Amount))+"";

		saleOutManager.addSaleOut(saleName,saleNo,saleTime,goodsNo, goodsName,Price,Amount,Money);
		System.out.println("添加销售记录：" + saleNo);
		System.out.println(goodsNo);
	}

	/**
	 * 删除销售员
	 * 
	 * @param req
	 * @param resp
	 */
	private void delSaleOut(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		// req.setCharacterEncoding("UTF-8");
		// 解决接收中文乱码
		String saleNo = new String(req.getParameter("storeno").getBytes(
				"ISO-8859-1"), "utf-8");
		System.out.println("删除销售单号为：" + saleNo);

		saleOutManager.delSaleOut(saleNo);

	}

	/**
	 * 修改InStore
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	private void editSaleOut(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		// req接收属性的值
		String saleNo = req.getParameter("saleNo");
		String saleName = req.getParameter("saleName");
		String saleTime = time.getTime();
		String goodsNo = req.getParameter("goodsNo");
		String goodsName = req.getParameter("goodsName");
		String Price = req.getParameter("Price");
		String Amount = req.getParameter("Amount");
		String Money =(Float.parseFloat(Price)*Float.parseFloat(Amount))+"";
		System.out.println("修改销售单号为：" + saleNo);
		System.out.println("修改销售ren为：" + saleName);
		saleOutManager.editSaleOut(saleName,saleNo,saleTime,goodsNo, goodsName,Price,Amount,Money);
	}

	
	/**
	 * 显示入库信息
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @throws ServletException
	 */
	public void listSaleOut(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		SaleOutManager saleOutManager=new SaleOutManager();
		String saleNo=req.getParameter("saleNo");
		System.out.println("saleNo:"+saleNo);
		List<SaleOut> saleOutList=saleOutManager.find(saleNo);
		if(saleOutList.size()==0){
			saleOutList=saleOutManager.find(null);
		}
		req.setAttribute("saleOutList",saleOutList);
		//请求转发
		RequestDispatcher rd=req.getRequestDispatcher("/page/saleout/saleout_list.jsp");
		rd.forward(req, resp);
		System.out.println("显示销售记录："+saleOutList);
		
	}
	
	
	/**
	 * 下拉框显示GoodsName
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @throws ServletException
	 */
	private void listGoodsName(HttpServletRequest req,HttpServletResponse resp) throws IOException,ServletException{
		List<SaleOut> saleOutList = new ArrayList<SaleOut>();
		saleOutList=saleOutManager.findGoodsName();
		req.setAttribute("saleOutList", saleOutList);
		RequestDispatcher rd=req.getRequestDispatcher("/page/saleout/saleout_add.jsp");
		rd.forward(req, resp);
		
	}
	
	
	private void listGoodsDetail(HttpServletRequest req,HttpServletResponse resp) throws IOException,ServletException{
		List<SaleOut> goodsDetailList =new ArrayList<SaleOut>();
		goodsDetailList=saleOutManager.findGoodsDetail();
		req.setAttribute("goodsDetailList", goodsDetailList);
		//System.out.println("goodsDetailList的长度为："+goodsDetailList.size());
		RequestDispatcher rd=req.getRequestDispatcher("/page/saleout/saleout_detail.jsp");
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
