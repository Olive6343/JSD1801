package net.line.manager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.line.common.DbUtils;
import net.line.model.InStore;

public class InStoreManager {
	private DbUtils dbUtils = new DbUtils();
	List<InStore> inStoreList = new ArrayList<InStore>();
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;

	/**
	 * 添加入库信息
	 * 
	 * @param storeno
	 * @param storetype
	 * @param storemgr
	 * @param goodsid
	 * @param goodsname
	 * @param goodsprice
	 * @param goodsamount
	 * @param goodsmoney
	 * @param mgname
	 * @param storetime
	 * @param description
	 */

	public void addInStore(String storeno, String storetype, String storemgr,
			String goodsid, String goodsname, String goodsprice,
			String goodsamount, String goodsmoney, String supplier,
			String storetime, String description) {

		try {
			String sql = "insert into t_InStore(storeno,storetype,storemgr,goodsid,goodsname,goodsprice,goodsamount,goodsmoney,supplier,storetime,description) values('"
					+ storeno
					+ "','"
					+ storetype
					+ "','"
					+ storemgr
					+ "','"
					+ goodsid
					+ "','"
					+ goodsname
					+ "','"
					+ goodsprice
					+ "','"
					+ goodsamount
					+ "','"
					+ goodsmoney
					+ "','"
					+ supplier
					+ "','"
					+ storetime + "','" + description + "')";
			conn = dbUtils.getConn();
			stmt = dbUtils.createStmt(conn);
			int c = dbUtils.excuteUpdate(sql, stmt);
		} catch (Exception e) {
			System.out.println("add InStore failed!" + e.getMessage());
		} finally {
			dbUtils.closeConnAndStmt(rs, stmt, conn);
		}

	}

	/**
	 * 删除入库信息
	 * 
	 * @param storeno
	 */
	public void delInStore(String storeno) {

		try {
			String sql = "delete from t_instore where storeno='" + storeno
					+ "'";
			conn = dbUtils.getConn();
			stmt = dbUtils.createStmt(conn);
			int c = dbUtils.excuteUpdate(sql, stmt);
		} catch (Exception e) {

			System.out.println("add instore failed!" + e.getMessage());
		}
	}

	/**
	 * 修改InStore
	 * 
	 * @param storeno
	 * @param storetype
	 * @param storemgr
	 * @param goodsid
	 * @param goodsname
	 * @param goodsprice
	 * @param goodsamount
	 * @param goodsmoney
	 * @param mgname
	 * @param storetime
	 * @param description
	 */
	public void editInStore(String storeno, String storetype, String storemgr,
			String goodsid, String goodsname, String goodsprice,
			String goodsamount, String goodsmoney, String supplier,
			String storetime, String description) {
		try {
			String sql = "update t_instore set storeno='" + storeno
					+ "',storetype='" + storetype + "',storemgr='" + storemgr
					+ "',goodsid='" + goodsid + "',goodsname='" + goodsname
					+ "',goodsprice='" + goodsprice + "',goodsamount='"
					+ goodsamount + "',goodsmoney='" + goodsmoney
					+ "',supplier='" + supplier + "',storetime='" + storetime
					+ "',description='" + description + "' where storeno='"
					+ storeno + "'";
			conn = dbUtils.getConn();
			stmt = dbUtils.createStmt(conn);
			System.out.println("update_sql" + sql);
			int c = dbUtils.excuteUpdate(sql, stmt);
		} catch (Exception e) {
			System.out.println("update instore failed!" + e.getMessage());
		} finally {
			dbUtils.closeConnAndStmt(rs, stmt, conn);
		}
	}

	/**
	 * 用list显示入库信息
	 * 
	 * @param storeno
	 * @return
	 */
	public List<InStore> find(String storeno) {
		String sql;
		System.out.println("这里的storeno是：" + storeno);
		if (storeno != null) {
			sql = "select * from t_instore where storeno='" + storeno + "'";
		} else {
			sql = "select * from t_instore";
		}
		try {
			System.out.println("输出sql语句：" + sql);
			conn = dbUtils.getConn();
			stmt = dbUtils.createStmt(conn);
			rs = dbUtils.excuteQuery(sql, stmt);
			while (rs.next()) {
				InStore is = new InStore();
				is.setStoreno(rs.getString("storeno"));
				is.setStoretype(rs.getString("storetype"));
				is.setStoremgr(rs.getString("storemgr"));
				is.setGoodsid(rs.getString("goodsid"));
				is.setGoodsname(rs.getString("goodsname"));
				is.setGoodsprice(rs.getFloat("goodsprice"));
				is.setGoodsamount(rs.getInt("goodsamount"));
				is.setGoodsmoney(rs.getFloat("goodsmoney"));
				is.setSupplier(rs.getString("supplier"));
				is.setStoretime(rs.getString("storetime"));
				is.setDescription(rs.getString("description"));

				inStoreList.add(is);
			}
		} catch (Exception e) {
			System.out.println("查询错误！" + e.getMessage());
		} finally {
			dbUtils.closeConnAndStmt(rs, stmt, conn);
		}
		return inStoreList;
	}

	/**
	 * 查找仓库类型
	 * @return
	 */
	public List<InStore> findStoreType() {
		String sql;
		sql="select * from t_storetype";
		try{
			conn=dbUtils.getConn();
			stmt=dbUtils.createStmt(conn);
			rs=dbUtils.excuteQuery(sql, stmt);
			while(rs.next()){
				InStore g=new InStore();
				g.setStoretype(rs.getString("storetype"));
				inStoreList.add(g);
			}
		}catch (Exception e) {
			System.out.println("查询错误！"+e.getMessage());
		}finally{
			dbUtils.closeConnAndStmt(rs, stmt, conn);
		}
		return inStoreList;
	}
	
	public List<InStore> findSupplier() {
		String sql;
		sql="select * from t_supplier";
		try{
			conn=dbUtils.getConn();
			stmt=dbUtils.createStmt(conn);
			rs=dbUtils.excuteQuery(sql, stmt);
			while(rs.next()){
				InStore g=new InStore();
				//g.setStoretype(rs.getString("storetype"));
				g.setSupplier(rs.getString("spName"));
				inStoreList.add(g);
			}
		}catch (Exception e) {
			System.out.println("查询错误！"+e.getMessage());
		}finally{
			dbUtils.closeConnAndStmt(rs, stmt, conn);
		}
		return inStoreList;
	}
	
	
}
