package net.line.manager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import net.line.common.DbUtils;
import net.line.model.Goods;
import net.line.model.Supplier;

public class GoodsManager {
	
	private DbUtils dbUtils=new DbUtils();
	List<Goods> goodsList=new ArrayList<Goods>();
	Connection conn=null;
	Statement stmt=null;
	ResultSet rs=null;

	/**
	 * 增加商品信息
	 * 
	 */
	public void addGoods(String goodsid,String goodsname,String suppliername,String standard,String units,String price,String description){
		try{
			String sql="insert into t_goods(goodsid,goodsname,suppliername,standard,units,price,description) values('"+goodsid+"','"+goodsname+"','"+suppliername+"','"+standard+"','"+units+"','"+price+"','"+description+"')";
		conn=dbUtils.getConn();
		stmt=dbUtils.createStmt(conn);
		int c=dbUtils.excuteUpdate(sql, stmt);
		}catch (Exception e) {
			System.out.println("add goods failed!"+e.getMessage());
		}finally{
			dbUtils.closeConnAndStmt(rs, stmt, conn);
		}
	}
	/**
	 * 删除该商品
	 * 
	 */
	public boolean delGoods(String goodsid) {
		boolean flag=false;
	
		try{
		String sql="delete  from t_goods where goodsid='"+goodsid+"'";
		Connection conn=dbUtils.getConn();
		Statement stmt=dbUtils.createStmt(conn);
		int c=dbUtils.excuteUpdate(sql, stmt);
		if(c>0){
			flag=true;
		}
		}catch (Exception e) {
			System.out.println("delete goods failed!"+e.getMessage());
		}
		return flag;
	}
/**
 * 修改商品信息
 * @param salerNo
 * @param salerName
 * @param salerPwd
 * @param salerSex
 * @param salerTel
 */
	public void editGoods(String goodsid,String goodsname,String suppliername,String standard,String units,String price,String description) {
		try{
			String sql="update t_goods set goodsname='"+goodsname+"' ,suppliername='"+suppliername+"' ,standard='"+standard+"' ,units='"+units+"' , price='"+price+"', description='"+description+"' where goodsid='"+goodsid+"' ";
		conn=dbUtils.getConn();
		stmt=dbUtils.createStmt(conn);
		int c=dbUtils.excuteUpdate(sql, stmt);
		}catch (Exception e) {
			System.out.println("update goods failed!"+e.getMessage());
		}finally{
			dbUtils.closeConnAndStmt(rs, stmt, conn);
		}
		
	}
/**
 * 显示商品信息
 * @param salerNo
 * @return
 */
	public List<Goods> find(String goodsid) {
		String sql;
		if(goodsid!=null){
			 sql="select * from t_goods where goodsid='"+goodsid+"'";
		}else{
			sql="select * from t_goods";
		}
		try{
			conn=dbUtils.getConn();
			stmt=dbUtils.createStmt(conn);
			rs=dbUtils.excuteQuery(sql, stmt);
			
			while(rs.next()){
				Goods g=new Goods();
				g.setGoodsid(rs.getString("goodsid"));
				g.setGoodsname(rs.getString("goodsname"));
				g.setSuppliername(rs.getString("suppliername"));
				g.setStandard(rs.getString("standard"));
				g.setUnits(rs.getString("units"));
				g.setPrice(rs.getDouble("price"));
				g.setDescription(rs.getString("description"));
				
				goodsList.add(g);
			}
		}catch (Exception e) {
			System.out.println("查询错误！"+e.getMessage());
		}finally{
			dbUtils.closeConnAndStmt(rs, stmt, conn);
		}
		return goodsList;
	}
	
	/**
	 * 商品名称查找
	 * @return
	 */
	public List<Goods> findGoodsName() {
		String sql;
		sql="select * from t_instore";
		try{
			conn=dbUtils.getConn();
			stmt=dbUtils.createStmt(conn);
			rs=dbUtils.excuteQuery(sql, stmt);
			while(rs.next()){
				Goods g=new Goods();
				g.setGoodsname(rs.getString("goodsname"));
				goodsList.add(g);
			}
		}catch (Exception e) {
			System.out.println("查询错误！"+e.getMessage());
		}finally{
			dbUtils.closeConnAndStmt(rs, stmt, conn);
		}
		return goodsList;
	}
	
	public List<Goods> findSupplierName() {
		String sql;
		sql="select * from t_supplier";
		try{
			conn=dbUtils.getConn();
			stmt=dbUtils.createStmt(conn);
			rs=dbUtils.excuteQuery(sql, stmt);
			while(rs.next()){
				Goods g=new Goods();
				//遍历supplier表的spName
				g.setSuppliername(rs.getString("spName"));
				goodsList.add(g);
			}
		}catch (Exception e) {
			System.out.println("查询错误！"+e.getMessage());
		}finally{
			dbUtils.closeConnAndStmt(rs, stmt, conn);
		}
		return goodsList;
	}
	
	
}
