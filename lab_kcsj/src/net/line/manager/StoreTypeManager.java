package net.line.manager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.line.common.DbUtils;
import net.line.model.StoreType;

public class StoreTypeManager {
	private DbUtils dbUtils = new DbUtils();
	List<StoreType> storeTypeList = new ArrayList<StoreType>();
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;

	/**
	 * 增加仓库类型
	 * 
	 */
	public void addStoreType( String stNo,String storeType) {
		try {
			String sql = "insert into t_storetype(stNo,storeType) values('" + stNo + "','"
					+ storeType + "')";
			conn = dbUtils.getConn();
			stmt = dbUtils.createStmt(conn);
			int c = dbUtils.excuteUpdate(sql, stmt);
		} catch (Exception e) {
			System.out.println("add storeType failed!" + e.getMessage());
		} finally {
			dbUtils.closeConnAndStmt(rs, stmt, conn);
		}
	}

	/**
	 * 删除该仓库类型
	 * 
	 */
	public boolean delStoreType(String stNo) {
		boolean flag = false;

		try {
			String sql = "delete  from t_storetype where stNo='" + stNo + "'";
			conn = dbUtils.getConn();
			stmt = dbUtils.createStmt(conn);
			int c = dbUtils.excuteUpdate(sql, stmt);
			if (c > 0) {
				flag = true;
			}
		} catch (Exception e) {

			System.out.println("delete storeType failed!" + e.getMessage());
		}
		return flag;
	}

	/**
	 * 修改仓库类型
	 */
	public void editStoreType(String stNo, String storeType) {
		try {
			String sql = "update t_storetype set storeType='" + storeType
					+ "'  where stNo='" + stNo + "' ";
			conn = dbUtils.getConn();
			stmt = dbUtils.createStmt(conn);
			int c = dbUtils.excuteUpdate(sql, stmt);
		} catch (Exception e) {
			System.out.println("update storeType failed!" + e.getMessage());
		} finally {
			dbUtils.closeConnAndStmt(rs, stmt, conn);
		}

	}

	/**
	 * 显示商品信息
	 * 
	 * @param salerNo
	 * @return
	 */
	public List<StoreType> find(String stNo) {
		String sql;
		System.out.println("这里的stNo是："+stNo);

		if (stNo!=null) {
			sql = "select * from t_storetype where stNo='" + stNo + "'";
		} else {
			sql = "select * from t_storetype";
		}
		try {
			System.out.println("输出SQL语句："+sql);
			conn = dbUtils.getConn();
			stmt = dbUtils.createStmt(conn);
			rs = dbUtils.excuteQuery(sql, stmt);

			while (rs.next()) {
				StoreType st = new StoreType();
				st.setStNo(rs.getString("stNo"));
				st.setStoreType(rs.getString("storeType"));

				storeTypeList.add(st);
			}
		} catch (Exception e) {
			System.out.println("查询错误！" + e.getMessage());
		} finally {
			dbUtils.closeConnAndStmt(rs, stmt, conn);
		}
		return storeTypeList;
	}

}
