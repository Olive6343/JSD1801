package com.ldq.bms.dao;

import java.util.List;

import com.ldq.bms.entity.UserInfo;

public interface UserDAO {
    /**
     * 添加注册数据
     *
     * @param userInfo
     */
    void insertUser(UserInfo userInfo);

    /**
     * 获得所有用户信息
     * 
     * @return 用户信息集合
     */
    List<UserInfo> getAll();

    /**
     * 获得用户id
     * 
     * @return
     */
    Integer getMaxId();

    /**
     * 通过证件号查找用户信息
     * 
     * @param idCard 待查找的用户证件号
     * @return 用户对象
     */
    UserInfo selectUserInfoByIdCard(String idCard);

    /**
     * 更新用户信息
     * 
     * @param list 用户列表
     */
	void updateUserInfo(List<UserInfo> list);

	/**
	 * 通过id获得用户信息
	 * 
	 * @param id 待查询的id
	 * @return
	 */
	UserInfo getUserInfoById(Integer id);
}
