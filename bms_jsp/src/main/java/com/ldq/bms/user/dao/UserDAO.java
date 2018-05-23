package com.ldq.bms.user.dao;

import java.util.List;

import com.ldq.bms.user.entity.UserInfo;

public interface UserDAO {
	/**
	 * 添加注册数据
	 *
	 * @param userInfo
	 */
	void insertUser(UserInfo userInfo);

	/**
	 * 获得所有用户信息
	 * @return
	 */
	List<UserInfo> getAll();

	/**
	 * 获得用户id的最大值（用于id的自增）
	 * 
	 * @return
	 */
	Integer getMaxId();

	/**
	 * 根据身份证查找用户信息
	 * 
	 * @param idCard
	 * @return
	 */
	UserInfo selectUserInfoByIdCard(String idCard);

	/**
	 * 根据证件号、密码查找用户
	 * 
	 * @param idCard
	 * @param password
	 * @return
	 */
	UserInfo selectByIdCardAndPassword(String idCard, String password);

	/**
	 * 通过id更新用户权限的状态
	 * 
	 * @param uid
	 * @param status
	 */
	void updateStatusByUId(Integer uid, Integer status);

	/**
	 * 通过证件号更新用户密码
	 * 
	 * @param idCard
	 * @param newpass
	 */
	void updatePassByIdCard(String idCard, String newpass);

	/**
	 * 通过用户id查找用户
	 * @param uid
	 * @return
	 */
	UserInfo selecUserInfoById(Integer uid);

	/**
	 * 更新用户信息
	 * @param userInfo
	 */
	void updateUserInfo(UserInfo userInfo);

	/**
	 * 根据用户id、图片地址更新图片
	 * @param uid
	 * @param pic
	 */
	void updatePicById(Integer uid, String pic);

	/**
	 * 根据id删除用户信息
	 * @param uid 待删除的用户id
	 */
	void deleteUser(Integer uid);

	/**
	 * 批量删除用户信息
	 * @param uids 待删除的用户id的集合
	 */
	void batchDel(String[] uids);

	List<UserInfo> selectByName(String name);

	List<UserInfo> searchUserInfoByNameOrIdCardOrStatus(String name, String idCard, String status);
}
