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

    List<UserInfo> getAll();

    Integer getMaxId();

    UserInfo selectUserInfoByIdCard(String idCard);
}
