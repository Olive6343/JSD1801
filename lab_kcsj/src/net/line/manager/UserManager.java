package net.line.manager;


import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Response;

import net.line.common.DbUtils;
import net.line.model.User;

/**
 * 管理用户信息
 * @author amu_1115
 * @version 1.0
 * 
 */
public class UserManager {
	private DbUtils dbUtils=new DbUtils();
	List<User> userList=new ArrayList<User>();
	Connection conn=null;
	Statement stmt=null;
	ResultSet rs=null;
	/**
	 * 校准用户密码
	 * @param userid
	 * @param pwd
	 * @param job
	 * @return
	 */
	public boolean  checkUser(String userid,String pwd,String job){
		System.out.println("执行到登录验证！");
		boolean flag=false;
		
		try{

		String sql="select * from t_user where userid='"+userid+"' and pwd='"+pwd+"'and job='"+job+"' ";
		
		conn=dbUtils.getConn();
		stmt=dbUtils.createStmt(conn);
		ResultSet rs=dbUtils.excuteQuery(sql, stmt);
		if(rs.next()){
			flag=true;
		}
		}catch (SQLException e) {
			System.out.print("登录名或密码错误!"+e.getMessage());
		}
		System.out.println("job:"+job);
		System.out.println("验证正确");
		
		return flag;
		
	}
	
	/**
	 * 新增用户
	 * @param userid
	 * @param pwd
	 * @param job
	 */
	public void  addUser(String userid,String pwd,String job){
	
		try{
		
		String sql="insert into t_user(userid,pwd,job) values('"+userid+"','"+pwd+"','"+job+"')";
	
		conn=dbUtils.getConn();
		stmt=dbUtils.createStmt(conn);
		int c=dbUtils.excuteUpdate(sql, stmt);
		}catch (Exception e) {
			System.out.print("add user failed!"+e.getMessage());
		}
		
		
	}
	/**
	 * 修改用户信息
	 * @param userid
	 * @param pwd
	 * @param job
	 */
	public void  editUser(String userid,String pwd,String job){
	
		try{
		
		String sql="update t_user set pwd='"+pwd+"' , job='"+job+"' where userid='"+userid+"'";
		System.out.print(sql);
		conn=dbUtils.getConn();
		stmt=dbUtils.createStmt(conn);
		int c=dbUtils.excuteUpdate(sql, stmt);
		}catch (Exception e) {
			System.out.print("add user failed!"+e.getMessage());
		}

	}
	/**
	 * 删除用户信息
	 * @param userid
	 */
	public void  delUser(String userid){
	
		try{
		
		String sql="delete from t_user  where userid='"+userid+"'";
		System.out.println(sql);
		conn=dbUtils.getConn();
		stmt=dbUtils.createStmt(conn);
		int c=dbUtils.excuteUpdate(sql, stmt);
		}catch (Exception e) {
			System.out.print("delUserr failed!"+e.getMessage());
		}
		
		
	}
	/**
	 * 显示用户信息
	 * @param userid
	 * @param job
	 */
	public List<User>  findAll(String id){
		String sql;
		System.out.println("这里的userid是："+id);
		if(id!=null)
		{
			sql="select * from t_user where userid='"+id+"'";
			//sql="select * from t_user where userid="%+like+%"'"";

//			if(userid!=null){
//				sql="select * from t_user where userid='"+userid+"' and job='"+job+"'";
//			}
//		}else if(userid!=null){
//			sql="select *from t_user where userid='"+userid+"'";
		}
		else{
			
			sql="select * from t_user";
		}
		
		try{
		System.out.println("输出sql语句：" + sql);	
		conn=dbUtils.getConn();
		stmt=dbUtils.createStmt(conn);
		rs=dbUtils.excuteQuery(sql, stmt);
		while(rs.next()){
//			String userid=rs.getString(1);
//			String pwd=rs.getString("pwd");
//			String job=rs.getString("job");
//			User model=new User();
//			model.setPassword(pwd);
//			model.setUserid(userid);
//			model.setJob(job);
//			users.add(model);
			
			User u=new User();
			u.setUserid(rs.getString("userid"));
			u.setPwd(rs.getString("pwd"));
			u.setJob(rs.getString("job"));
			
			userList.add(u);
		}
		
		}catch (Exception e) {
			System.out.print("findAll failed!"+e.getMessage());
		}
		return userList;
		
	}
	
	/**
	 * 通过userid找到用户信息
	 * @param userid
	 * @param pwd
	 */
	public User  findUserByUserid(String userid){
		User user=new User();
		try{
		
		String sql="select * from  t_user where userid='"+userid+"'";
	
		conn=dbUtils.getConn();
		stmt=dbUtils.createStmt(conn);
		rs=dbUtils.excuteQuery(sql, stmt);
		while(rs.next()){
		
			String userid1=rs.getString(1);
			String pwd=rs.getString("pwd");
			String job=rs.getString("job");
			user.setPwd(pwd);
			user.setJob(job);
			user.setUserid(userid1);
			
		}
		
		}catch (Exception e) {
			System.out.print("findUserByUserid failed!"+e.getMessage());
		}
		return user;
		
	}


}
