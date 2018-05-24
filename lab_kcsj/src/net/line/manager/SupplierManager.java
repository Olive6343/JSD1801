package net.line.manager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.line.common.DbUtils;
import net.line.model.Supplier;

public class SupplierManager {
	private DbUtils dbUtils=new DbUtils();
	Connection conn=null;
	Statement stmt=null;
	ResultSet rs=null;
	/**
	 * 新增供应商
	 * @param spId
	 * @param spName
	 */
	public void addSupplier(String spId,String spName){
		try{
			String sql="insert into t_supplier(spId,spName) values('"+spId+"','"+spName+"')";
			conn=dbUtils.getConn();
			stmt=dbUtils.createStmt(conn);
			int c=dbUtils.excuteUpdate(sql, stmt);
		}catch (Exception e) {
			System.out.println("add supplier failed!"+e.getMessage());
		}finally{
			dbUtils.closeConnAndStmt(rs, stmt, conn);
		}
	}
	
	/**
	 * 删除Supplier
	 * @param spId
	 */
	public void delSupplier(String spId){
		try{
			String sql="delete from t_supplier where spId='"+spId+"'";
			conn=dbUtils.getConn();
			stmt=dbUtils.createStmt(conn);
			int c=dbUtils.excuteUpdate(sql, stmt);
		}catch (Exception e) {
			System.out.println("del supplier failed!"+e.getMessage());
		}finally{
			dbUtils.closeConnAndStmt(rs, stmt, conn);
		}
	}
	
	
	
	/**
	 * 修改供应商
	 * @param spId
	 * @param spName
	 */
	public void editSupplier(String spId,String spName){
		try{
			String sql="update t_supplier set spName='"+spName+"' where spId='"+spId+"'";
			conn=dbUtils.getConn();
			stmt=dbUtils.createStmt(conn);
			int c=dbUtils.excuteUpdate(sql, stmt);
		}catch (Exception e) {
			System.out.println("update supplier failed!"+e.getMessage());
		}finally{
			dbUtils.closeConnAndStmt(rs, stmt, conn);
		}
	}
	
	/**
	 * 显示Supplier
	 * @param spId
	 * @return
	 */
	public List<Supplier> find(String spId){
		String sql;
		if(spId!=null){
			sql="select * from t_supplier where spId='"+spId+"'";
		}else{
			sql="select * from t_supplier";
		}
		List<Supplier> spList =new ArrayList<Supplier>();
		try{
			System.out.println("输出sql语句："+sql);
			conn=dbUtils.getConn();
			stmt=dbUtils.createStmt(conn);
			rs=dbUtils.excuteQuery(sql, stmt);
			while(rs.next()){
				Supplier sp=new Supplier();
				sp.setSpId(rs.getString("spId"));
				sp.setSpName(rs.getString("spName"));	
			
				spList.add(sp);
			}
		}catch (Exception e) {
			System.out.println("显示Supplier错误！"+e.getMessage());
		}finally{
			dbUtils.closeConnAndStmt(rs, stmt, conn);
		}
		System.out.println("show spList 成功。");
		return spList;
	}
	

	
}
