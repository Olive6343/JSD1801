package net.line.manager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Response;

import net.line.common.DbUtils;
import net.line.model.Saler;

public class SalerManager {
	private DbUtils dbUtils=new DbUtils();
	List<Saler> salerList=new ArrayList<Saler>();
	Connection conn=null;
	Statement stmt=null;
	ResultSet rs=null;
	/**
	 * 校验销售员密码
	 * 
	 */
	public boolean checkSaler(String salerNo,String salerPwd){
		boolean flag=false;
		try{
			String sql="select * from where salerNo='"+salerNo+"' and salerPwd='"+salerPwd+"'";
			//连接数据库
			conn=dbUtils.getConn();
			stmt=dbUtils.createStmt(conn);
			rs=dbUtils.excuteQuery(sql, stmt);
			if(rs.next()){
				return true;
			}
		}catch (SQLException e) {
			// TODO: handle exception
			System.out.println("不存在改销售员或密码错误！"+e.getMessage());
		}finally{
			dbUtils.closeConnAndStmt(rs, stmt, conn);
		}
		return flag;
	}
	
	/**
	 * 增加销售员信息
	 * 
	 */
	public void addSaler(String salerNo,String salerName,String salerPwd,String salerSex,String salerTel){
		try{
			String sql="insert into t_saler(salerNo,salerName,salerPwd,salerSex,salerTel) values('"+salerNo+"','"+salerName+"','"+salerPwd+"','"+salerSex+"','"+salerTel+"')";
		Connection conn=dbUtils.getConn();
		Statement stmt=dbUtils.createStmt(conn);
		int c=dbUtils.excuteUpdate(sql, stmt);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("add saler failed!"+e.getMessage());
		}finally{
			dbUtils.closeConnAndStmt(rs, stmt, conn);
		}
	}
	/**
	 * 删除该销售员
	 * 
	 */
	public boolean delSaler(String salerNo) {
		// TODO Auto-generated method stub
		boolean flag=false;
	
		try{
		String sql="delete  from t_saler where salerNo='"+salerNo+"'";
		Connection conn=dbUtils.getConn();
		Statement stmt=dbUtils.createStmt(conn);
		int c=dbUtils.excuteUpdate(sql, stmt);
		if(c>0){
			flag=true;
		}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("add saler failed!"+e.getMessage());
		}
		return flag;
	}
/**
 * 修改销售员信息
 * @param salerNo
 * @param salerName
 * @param salerPwd
 * @param salerSex
 * @param salerTel
 */
	public void editSaler(String salerNo, String salerName, String salerPwd,
			String salerSex, String salerTel) {
		try{
			String sql="update t_saler set salerName='"+salerName+"' , salerPwd='"+salerPwd+"', salerSex='"+salerSex+"' , salerTel='"+salerTel+"' where salerNo='"+salerNo+"' ";
		conn=dbUtils.getConn();
		stmt=dbUtils.createStmt(conn);
		int c=dbUtils.excuteUpdate(sql, stmt);
		}catch (Exception e) {
			System.out.println("update saler failed!"+e.getMessage());
		}finally{
			dbUtils.closeConnAndStmt(rs, stmt, conn);
		}
		
	}
/**
 * 显示销售员信息
 * @param salerNo
 * @return
 */
	public List<Saler> find(String salerNo) {
		String sql;
		if(salerNo!=null){
			 sql="select * from t_saler where salerNo='"+salerNo+"'";
		}else{
			sql="select * from t_saler";
		}
		try{
			conn=dbUtils.getConn();
			stmt=dbUtils.createStmt(conn);
			rs=dbUtils.excuteQuery(sql, stmt);
			
			while(rs.next()){
				Saler sl=new Saler();
				sl.setSalerNo(rs.getString("salerNo"));
				sl.setSalerName(rs.getString("salerName"));
				sl.setSalerPwd(rs.getString("salerPwd"));
				sl.setSalerSex(rs.getString("salerSex"));
				sl.setSalerTel(rs.getString("salerTel"));
				salerList.add(sl);
			}
		}catch (Exception e) {
			System.out.println("查询错误！"+e.getMessage());
		}finally{
			dbUtils.closeConnAndStmt(rs, stmt, conn);
		}
		return salerList;
	}
	

	
	
	
}
