package com.ldq.jdbcdemo.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil {

	/**
	 * 将jdbc.properties文件的信息加载到properties对象,并初始化
	 */
	private static Properties properties = new Properties();

	/**
	 * 连接对象
	 */
	private static Connection conn;

	/**
	 * 私有话构造器，不提供new方式创建对象
	 */
	private DBUtil() {
	}

	/**
	 * 静态代码块，初始化工具类
	 */
	static {
		try {
			// 通过类加载器加载文件并转换字节输入流
			InputStream is = DBUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
			// 将字节流加载到配置文件列表对象中
			properties.load(is);
			// 加载JDBC驱动
			Class.forName(properties.getProperty("jdbc.driverClass"));
			// 创建数据库连接
			conn = DriverManager.getConnection(properties.getProperty("jdbc.url"), properties.getProperty("jdbc.user"),
					properties.getProperty("jdbc.password"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 返回当前数据库连接
	 *
	 * @return 
	 */
	public static Connection getConnection(){
		try {
			// 当连接对象为null或者连接对象被关闭
			if (conn == null || conn.isClosed()) {
				// 创建数据库连接
				// DriverManager是驱动管理器，它能根据用户提供的数据库url、user和password等信息创建连接对象
				conn = DriverManager.getConnection(properties.getProperty("jdbc.url"),
						properties.getProperty("jdbc.user"), properties.getProperty("jdbc.password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static Statement creatStatment(Connection conn){
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return stmt;
	}
	
	public static void release(Connection conn, Statement st, ResultSet rs){
		try {
			if(rs != null){
				rs.close();
				rs = null;
			}
			if(st != null){
				st.close();
				st = null;
			}
			if(conn != null){
				conn.close();
				conn = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 测试方法
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(getConnection());
	}
	
}
