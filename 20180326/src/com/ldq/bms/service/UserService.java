package com.ldq.bms.service;

import com.ldq.bms.entity.UserInfo;

/**
 * 用户服务接口
 */
public interface UserService {
    /**
     * 保存注册用户
     *
     * @param userInfo
     */
    void saveUser(UserInfo userInfo);

    boolean isIdCardOnlyOne(String idCard);

    boolean loginValidate(String idCard, String password);

    UserInfo getUserInfoByIdCard(String idCard);
}
