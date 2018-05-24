package net.line.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.line.manager.GoodsManager;
import net.line.model.Goods;

public class GoodsServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	GoodsManager goodsManager=new GoodsManager();
	String url=null;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//System.out.println("提交方式" +req.getMethod());
		
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		System.out.println("执行GoodsServlet");
		System.out.println("提交方式"+req.getMethod());
		String action=req.getParameter("action");//0登录，1新增商品，2删除商品，3查询商品，4修改商品
		System.out.println("action:"+action);
		switch (Integer.parseInt(action)) {
		case 0:
			//this.login(req, resp);
			break;
		case 1:
			this.addGoods(req, resp);
			this.listGoods(req, resp);
			break;
		case 2:
			this.delGoods(req, resp);
			this.listGoods(req, resp);
			break;
		case 3:
			//this.editSaler(req, resp);
			this.listGoods(req, resp);
			break;
		case 4:
			this.editGoods(req, resp);
			this.listGoods(req, resp);
			break;
		case 5:
			//this.editSaler(req, resp);
			this.listGoodsName(req, resp);
			break;	
		case 6:
			//this.editSaler(req, resp);
			this.listSupplierName(req, resp);
			break;
		default:
			break;
		}
	}
	

	
	/**
	 * 新增销售员
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws ServletException
	 * @throws IOException 
	 */
	private void addGoods(HttpServletRequest req, HttpServletResponse resp) throws ServletException,ServletException, IOException{
	     //接收Sale人Manager的对象
		String goodsid=req.getParameter("goodsid");
		String goodsname=req.getParameter("goodsname");
		String suppliername=req.getParameter("suppliername");
		String standard = req.getParameter("standard");
		String units = req.getParameter("units");
		String price = req.getParameter("price");
		String description = req.getParameter("description");
		 
		System.out.println("商品编号" + goodsid);

		goodsManager.addGoods(goodsid,goodsname,suppliername,standard,units,price,description);		
	}
	
	/**
	 * 删除销售员
	 * 
	 * @param req
	 * @param resp
	 */
	private void delGoods(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//req.setCharacterEncoding("UTF-8");
		//解决接收中文乱码
		String goodsid =new String(req.getParameter("goodsid").getBytes("ISO-8859-1"),"utf-8");
		System.out.println("商品编号：" + goodsid);
	
		goodsManager.delGoods(goodsid);
		
	}
	
	/**
	 * 修改销售员信息
	 * 
	 * @param req
	 * @param resp
	 */
	private void editGoods(HttpServletRequest req, HttpServletResponse resp)  throws IOException{
		
		String goodsid = req.getParameter("goodsid");
		String goodsname=req.getParameter("goodsname");
		String suppliername=req.getParameter("suppliername");
		String standard = req.getParameter("standard");
		String units = req.getParameter("units");
		String price=req.getParameter("price");
		String description=req.getParameter("description");
		
		//System.out.println("goodsid："+goodsid);
		goodsManager.editGoods(goodsid,goodsname,suppliername,standard,units,price,description);
		System.out.println("修改商品信息："+goodsid);
	}
	
	/**
	 * 显示商品所有信息
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @throws ServletException
	 */
	private void listGoods(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		
		GoodsManager goodsManager=new GoodsManager();
		List<Goods> goodsList=goodsManager.find(null);
		req.setAttribute("goodsList", goodsList);
		//System.out.println("goodsname:"+goodsname);
		RequestDispatcher rd=req.getRequestDispatcher("/page/goods/goods_list.jsp");
		rd.forward(req, resp);
		System.out.println("显示商品信息成功");
		

	}
	
	
	private void listGoodsName(HttpServletRequest req,HttpServletResponse resp) throws IOException,ServletException{
		//String 
		List<Goods> goodsList = new ArrayList<Goods>();
		goodsList=goodsManager.findGoodsName();
		req.setAttribute("goodsList", goodsList);
		RequestDispatcher rd=req.getRequestDispatcher("/page/goods/goods_add.jsp");
		rd.forward(req, resp);
	}
	
	private void listSupplierName(HttpServletRequest req,HttpServletResponse resp) throws IOException,ServletException{
		//String 
		List<Goods> snList = new ArrayList<Goods>();
		snList=goodsManager.findSupplierName();
		req.setAttribute("snList", snList);
		RequestDispatcher rd=req.getRequestDispatcher("/page/goods/goods_add.jsp");
		rd.forward(req, resp);
	}
	
	

}
