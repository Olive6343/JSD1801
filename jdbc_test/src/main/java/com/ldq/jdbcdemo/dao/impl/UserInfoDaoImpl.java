package com.ldq.jdbcdemo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ldq.jdbcdemo.dao.UserInfoDao;
import com.ldq.jdbcdemo.entity.UserInfo;
import com.ldq.jdbcdemo.util.DBUtil;
import com.ldq.jdbcdemo.util.PageModel;

/**
 * jdbc 操作数据库的实现类
 * @author Administrator
 *
 */
public class UserInfoDaoImpl implements UserInfoDao{

	List<UserInfo> list = new ArrayList<UserInfo>();
	private Connection conn;
	private Statement st;
	private ResultSet rs;
	private PreparedStatement ps;
	
	public List<UserInfo> selectAll() {
		try {
			// 1.获得数据库连接
			conn = DBUtil.getConnection();
			// 2.创建SQL语句
			String sql = "SELECT * FROM user_info";
			// 3.创建Statement对象
			st = conn.createStatement();
			// 4.编译并执行SQL语句， 并将返回的数据保存到结果集对象中
			rs = st.executeQuery(sql);
			// 5.迭代结果集，处理每一条记录
			while(rs.next()){
				UserInfo info = new UserInfo();
				info.setuId(rs.getLong("u_id"));
				info.setUsername(rs.getString("username"));
				info.setPassword(rs.getString("password"));
				info.setIdCard(rs.getString("id_card"));
				info.setStatus(rs.getInt("status"));
				list.add(info);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.release(conn, st, rs);
		}
		return list;
	}
	
	public PageModel<UserInfo> selectByPage(PageModel<UserInfo> pageModel){
		try {
			conn = DBUtil.getConnection();
			// 1.获得数据库连接
			// 2.创建SQL语句
			StringBuilder builder = new StringBuilder();
			builder.append("SELECT * FROM(")
			.append("SELECT INFO.*, ROW_NUMBER()  OVER(ORDER BY INFO.U_ID ASC)  RN ")
			.append("FROM USER_INFO INFO").append(")WHERE RN BETWEEN ? AND ?");
			// 3.创建Statement对象
			ps = conn.prepareStatement(builder.toString());
			ps.setInt(1, pageModel.getStart());
			ps.setInt(2, pageModel.getEnd());
			// 4.编译并执行SQL语句， 并将返回的数据保存到结果集对象中
			rs = ps.executeQuery();
			List<UserInfo> list = new ArrayList<>();
			// 5.迭代结果集，处理每一条记录
			while(rs.next()){
				UserInfo info = new UserInfo();
				info.setuId(rs.getLong("u_id"));
				info.setUsername(rs.getString("username"));
				info.setPassword(rs.getString("password"));
				info.setIdCard(rs.getString("id_card"));
				info.setStatus(rs.getInt("status"));
				list.add(info);
			}
			pageModel.setList(list);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.release(conn, st, rs);
		}
		return pageModel;
	}
	
	
	@Override
	public int deleteById(Long id) {
		int num = 0;
		try {
			//1.创建数据库廉连接
			conn = DBUtil.getConnection();
			// 取消默认提交事务
			conn.setAutoCommit(false);
			//2.创建SQL语句
			String sql = "delete from user_info where u_id = ?";
			//3.创建PrepareStatement对象，对SQL进行预编译
			ps = conn.prepareStatement(sql);
			ps.setLong(1, id);
			//4.编译执行并SQL语句，返回受影响的记录的行数
			num = ps.executeUpdate();
			System.out.println(num + "条记录已删除！");
			// 手动提交事务，并重置默认事务
			conn.setAutoCommit(true);
		} catch (Exception e) {
			e.printStackTrace();
			if(conn != null){
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally{
			DBUtil.release(conn, st, null);
		}
		return num;
	}
	
	@Override
	public int add(UserInfo userInfo) {
		int num = 0;
		try {
			conn = DBUtil.getConnection();
			String sql = "insert into user_info(username,password,id_card,status)values(?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, userInfo.getUsername());
			ps.setString(2, userInfo.getPassword());
			ps.setString(3, userInfo.getIdCard());
			ps.setInt(4, userInfo.getStatus());
			num = ps.executeUpdate();
			System.out.println(num + "条记录已增加！");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.release(conn, st, null);
		}
		return num;
	}
	
	
	@Override
	public int updateById(Long id,UserInfo userInfo) {
		int num = 0;
		try {
			// 1.获得数据库连接
			conn = DBUtil.getConnection();
			// 2.创建SQL语句
			String sql = "update user_info set username = ?, password = ?, id_card = ? ,status = ? where u_id = ?";
			// 3.创建PreparedStatement对象，并对SQL进行预编译
			System.out.println(sql);
			ps = conn.prepareStatement(sql);
			ps.setString(1, userInfo.getUsername());
			ps.setString(2, userInfo.getPassword());
			ps.setString(3, userInfo.getIdCard());
			ps.setInt(4, userInfo.getStatus());
			ps.setLong(5, id);
			// 4.执行SQL语句，返回受影响的记录的行数
			num = ps.executeUpdate();
			System.out.println(num + "条记录已修改！");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}

	public static void main(String[] args) {
		UserInfoDao userInfoDao = new UserInfoDaoImpl();
		// JDK8 lambda表达式
//		userInfoDao.selectAll().forEach(System.out::println);
		
//		System.out.println(userInfoDao.deleteById(4l));
		
//		System.out.println(userInfoDao.add(new UserInfo(null,"2132","wer","2",1)));
//		userInfoDao.selectAll().forEach(System.out::println);
//		
//		System.out.println(userInfoDao.deleteById(11l));
//		
//		UserInfo info = new UserInfo(null,"123456","11111","12",2);
//		System.out.println(userInfoDao.updateById(6l, info));
//		
		PageModel<UserInfo> pageModel = new PageModel<>();
		pageModel.setPagesize(5);
		pageModel.setPagenum(2);
		pageModel.setTotalrows(userInfoDao.selectAll().size());
		userInfoDao.selectByPage(pageModel);
		
		pageModel.getList().forEach(System.out::println);
	}




}
