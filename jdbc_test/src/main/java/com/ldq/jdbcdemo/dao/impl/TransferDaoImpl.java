package com.ldq.jdbcdemo.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.ldq.jdbcdemo.dao.TransferDao;
import com.ldq.jdbcdemo.util.DBUtil;

import oracle.jdbc.oracore.OracleType;

public class TransferDaoImpl implements TransferDao{

	private Connection conn;
	private CallableStatement cs;
	@Override
	public boolean transfer(Long inId, Long outId, double money) {
		boolean result = false;
		try {
			// 1.获得数据库连接
			conn = DBUtil.getConnection();
			// 取消默认提交事务
			conn.setAutoCommit(false);
			// 2.创建SQL语句
			String sql = "Call transfer(?,?,?,?)";
			// 3.创建CallableStatement对象，对sql进行预编译
			cs = conn.prepareCall(sql);
			// 设置输入参数
			cs.setLong(1, inId);
			cs.setLong(2, outId);
			cs.setDouble(3, money);
			// 注册输出参数
			cs.registerOutParameter(4, OracleType.STYLE_INT);
			// 4.编译并执行存储过程
			cs.execute();
			// 通过输出参数的占位符的位置获取到输出参数的值（是在存储过程中指定的）
			if(cs.getInt(4) == 1)
				result = true;
			// 手动提交事务，并重置默认事务
			conn.commit();
			conn.setAutoCommit(true);
		} catch (Exception e) {
			e.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}finally {
			DBUtil.release(conn, cs, null);
		}
		return result;
	}

	public static void main(String[] args) {
		TransferDao transferDao = new TransferDaoImpl();
		System.out.println(transferDao.transfer(2l, 1l, 1000));
	}
}
