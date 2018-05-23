package com.entor.bms.role.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entor.bms.user.dao.UserDAO;
import com.entor.bms.user.entity.UserInfo;
import com.entor.bms.utils.DBUtil;

public class UserDAOImpl implements UserDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;

	@Override
	public void insertUser(UserInfo userInfo) {
	}

	@Override
	public List<UserInfo> getAll() {
		List<UserInfo> infoList = new ArrayList<>();
		try {
			// 1.获得数据库连接
			conn = DBUtil.getConnection();
			// 2.创建SQL句
			String sql = "select * from user_info";
			// 3.创建statement
			ps = conn.prepareStatement(sql);
			// 4.编译并执行SQL句，并将返回的数据保存到结果集对象中
			rs = ps.executeQuery();
			// 5.迭代结果集，处理每一条记录
			while (rs.next()) {
				UserInfo info = new UserInfo();
				info.setUid(rs.getInt("u_id"));
				info.setName(rs.getString("name"));
				info.setIdCard(rs.getString("id_card"));
				info.setRentBooks(rentIdsToList(rs.getString("rent_ids")));
				info.setStatus(rs.getInt("status"));
				infoList.add(info);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.release(conn, ps, rs);
		}
		return infoList;
	}

	@Override
	public Integer getMaxId() {
		return 0;
	}

	@Override
	public UserInfo selectUserInfoByIdCard(String idCard) {
		UserInfo info = null;
		try {
			// 1.获得数据库连接
			conn = DBUtil.getConnection();
			// 2.创建SQL句
			String sql = "select * from user_info where status != 0 and id_card = ?";
			// 3.创建statement对象
			ps = conn.prepareStatement(sql);
			ps.setString(1, idCard);
			// 4.编译并执行SQL句，并将返回的数据保存到结果集对象中
			rs = ps.executeQuery();
			// 5.迭代结果集，处理每一条记录
			while (rs.next()) {
				info = new UserInfo();
				info.setUid(rs.getInt("u_id"));
				info.setName(rs.getString("name"));
				info.setIdCard(rs.getString("id_card"));
				info.setRentBooks(rentIdsToList(rs.getString("rent_ids")));
				info.setStatus(rs.getInt("status"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.release(conn, ps, rs);
		}
		return info;
	}

	@Override
	public UserInfo selectByIdCardAndPassword(String idCard, String password) {
		UserInfo info = null;
		try {
			// 1.获得数据库连接
			conn = DBUtil.getConnection();
			// 2.创建SQL句
			String sql = "select * from user_info where status != 0 and id_card = ? and password = ?";
			// 3.创建statement对象
			ps = conn.prepareStatement(sql);
			ps.setString(1, idCard);
			ps.setString(2, password);
			// 4.编译并执行SQL句，并将返回的数据保存到结果集对象中
			rs = ps.executeQuery();
			// 5.迭代结果集，处理每一条记录
			while (rs.next()) {
				info = new UserInfo();
				info.setUid(rs.getInt("u_id"));
				info.setName(rs.getString("name"));
				info.setPassword(rs.getString("password"));
				info.setIdCard(rs.getString("id_card"));
				info.setRentBooks(rentIdsToList(rs.getString("rent_ids")));
				info.setStatus(rs.getInt("status"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.release(conn, ps, rs);
		}
		return info;
	}

	@Override
	public void updateUserInfo(List<UserInfo> list) {

	}

	/**
	 * 将以逗号分割的租赁书籍的id的字符串转换成id的集合
	 * 
	 * @param rentIds
	 * @return
	 */
	private List<Integer> rentIdsToList(String rentIds) {
		List<Integer> list = new ArrayList<>();
		if (rentIds != null && !"".equals(rentIds)) {
			for (String id : rentIds.split(",")) {
				list.add(Integer.valueOf(id));
			}
		}
		return list;
	}

	@Override
	public void updatePassByIdCard(String idCard, String newpass) {
		try {
			// 1.获得数据库连接
			conn = DBUtil.getConnection();
			// 2.创建SQL句
			String sql = "update user_info set password=? where id_card=?";
			// 3.创建statement对象
			ps = conn.prepareStatement(sql);
			ps.setString(1, newpass);
			ps.setString(2, idCard);
			// 4.编译并执行SQL句，并将返回的数据保存到结果集对象中
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.release(conn, ps, null);
		}
	}

	public static void main(String[] args) {
		UserDAO dao = new UserDAOImpl();
		dao.updatePassByIdCard("123123", "abc123");
	}
}
