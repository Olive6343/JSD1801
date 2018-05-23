package com.ldq.bms.service.impl;

import java.util.List;

import com.ldq.bms.dao.UserDAO;
import com.ldq.bms.dao.impl.UserDAOImpl;
import com.ldq.bms.entity.UserInfo;
import com.ldq.bms.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO = new UserDAOImpl();

    /**
     * 调用数据访问层的添加用户的方法
     *
     * @param userInfo
     */
    @Override
    public void saveUser(UserInfo userInfo) {
        userInfo.setUid(userDAO.getMaxId() + 1);
        userInfo.setStatus(1);
        userDAO.insertUser(userInfo);
    }

    @Override
    public boolean isIdCardOnlyOne(String idCard) {
        // 1.查询出所有的记录
        List<UserInfo> list = userDAO.getAll();

        // 2.在所有记录中验证idCard唯一性
        for (UserInfo userInfo : list) {
            if (idCard.equals(userInfo.getIdCard())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean loginValidate(String idCard, String password) {
        // 1.查询出所有的记录
        List<UserInfo> list = userDAO.getAll();
        // 2.匹配证件和密码
        for (UserInfo userInfo : list) {
            if (idCard.equals(userInfo.getIdCard()) && password.equals(userInfo.getPassword())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public UserInfo getUserInfoByIdCard(String idCard) {
        return userDAO.selectUserInfoByIdCard(idCard);
    }
}
