package com.entor.bms.dao;

import com.entor.bms.entity.UserInfo;

import java.util.List;

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
}
