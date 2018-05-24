package net.line.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtils {
	
	//类变量
	public static final String JDBC_URL="jdbc:mysql://localhost:3306/labtask_db";
	public static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
	public static final String JDBC_USER="root";
	public static final String JDBC_PWD="root";
	
	//构造方法
	public DbUtils(){
		
	}
	//添加类方法
	
	/**
	 * 创建Connection连接对象 
	 */
	public Connection getConn(){
		Connection conn=null;
		try{
		//加载驱动
		Class.forName(JDBC_DRIVER);
		//通过驱动管理其DriverManager的getConnection()方法获得连接对象
		conn=DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PWD);
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("获得连接失败!"+e.getMessage());
		}
		return conn;
	}
	
	/**
	 * 创建执行SQL命令的Statement对象
	 * @param conn
	 */
	public Statement createStmt(Connection conn){
		Statement stmt=null;
		try{
		stmt=conn.createStatement();
		}catch (SQLException e) {
			System.out.println("创建执行SQL命令的Statement对象失败!"+e.getMessage());
		}
		return stmt;

	}
	
	/**
	 * 数据库更新次数
	 * @param sql
	 * @param stmt
	 * @return
	 */
	public int excuteUpdate(String sql ,Statement stmt){
		int c=0;
		try{
		 c=stmt.executeUpdate(sql);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
		
	}
	
	public ResultSet excuteQuery(String sql,Statement stmt){

		ResultSet rs=null;
		try{
		 rs=stmt.executeQuery(sql);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
		
	
		
		
	}
	/**
	 * 依次关闭结果集、statement、数据库连接
	 * @param rs
	 * @param stmt
	 * @param conn
	 */
	public  void closeConnAndStmt(ResultSet rs,Statement stmt,Connection conn) {
		try {
			if (rs!= null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}
	
	
	public static void main(String[]args)throws Exception{
		
		DbUtils dbUtils=new DbUtils();
		Connection conn=dbUtils.getConn();
		Statement stmt=dbUtils.createStmt(conn);
		String stuNo="201400201029";
		String stuName="乐勇";
		//定义SQL命令的字符串
		//String sql="insert into t_student(stuNo,stuName) values('"+stuNo+"','"+stuName+"')";
		String sql="select * from t_student where 1=1";
	
		ResultSet rs=dbUtils.excuteQuery(sql, stmt);
		//遍历结果集
		while(rs.next())
		{
			String clumn=rs.getString(1);
			System.out.println(clumn);
		
		}
		
	}

}
