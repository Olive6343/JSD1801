package net.line.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.line.manager.SupplierManager;
import net.line.model.Supplier;

public class SupplierServlet extends HttpServlet {

	SupplierManager supplierManager=new SupplierManager();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		System.out.println("运行到SupplierServlet..");
		String action=req.getParameter("action");
		System.out.println("action:"+action);
		switch (Integer.parseInt(action)) {
		case 0:
			
			break;
		case 1:
			this.addSupplier(req, resp);
			this.listSupplier(req, resp);
			break;
		case 2:
			this.delSupplier(req, resp);
			this.listSupplier(req, resp);
			break;
		case 3:
			this.listSupplier(req, resp);
			break;	
		case 4:
			this.editSupplier(req, resp);
			this.listSupplier(req, resp);
			break;
		default:
			break;
		}
	}
	
	
	private void addSupplier(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String spId=req.getParameter("spId");
		String spName=req.getParameter("spName");
		
		supplierManager.addSupplier(spId, spName);
	}
	
	private void delSupplier(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//获取spId并处理乱码问题
		String spId=new String(req.getParameter("spId").getBytes("ISO-8859-1"),"utf-8");
		//String spName=req.getParameter("spName");
		
		supplierManager.delSupplier(spId);
	}
	
	private void editSupplier(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String spId=req.getParameter("spId");
		String spName=req.getParameter("spName");
		
		supplierManager.editSupplier(spId, spName);
	}
	
	private void listSupplier(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String spId=req.getParameter("spId");
		System.out.println("供应商编号为："+spId);
		List<Supplier> spList=supplierManager.find(spId);
		if(spList.size()==0){
			spList=supplierManager.find(null);
		}
		req.setAttribute("spList", spList);
		RequestDispatcher rd=req.getRequestDispatcher("/page/supplier/supplier_list.jsp");
		rd.forward(req, resp);
	}
	
	
	
	

}
