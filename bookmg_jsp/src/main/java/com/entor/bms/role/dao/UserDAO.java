package com.entor.bms.role.dao;

import java.util.List;

import com.entor.bms.user.entity.UserInfo;

public interface UserDAO {
    /**
     * 添加注册数据
     *
     * @param userInfo
     */
    void insertUser(UserInfo userInfo);

    List<UserInfo> getAll();

    Integer getMaxId();

    UserInfo selectUserInfoByIdCard(String idCard);

    /**
     * 更新用户信息
     *
     * @param list 用户列表
     */
    void updateUserInfo(List<UserInfo> list);

	UserInfo selectByIdCardAndPassword(String idCard, String password);

	void updatePassByIdCard(String idCard, String newpass);
}
