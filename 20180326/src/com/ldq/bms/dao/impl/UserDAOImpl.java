package com.ldq.bms.dao.impl;

import java.util.List;

import com.ldq.bms.dao.UserDAO;
import com.ldq.bms.entity.UserInfo;
import com.ldq.bms.utils.EditUtils;
import com.ldq.bms.utils.ReadAndWriteUtils;

public class UserDAOImpl implements UserDAO {
    @Override
    public void insertUser(UserInfo userInfo) {
        ReadAndWriteUtils.singleWrite(EditUtils.userInfoToString(userInfo));
    }

    @Override
    public List<UserInfo> getAll() {
        return ReadAndWriteUtils.readAllUserRecords();
    }

    @Override
    public Integer getMaxId() {
        List<UserInfo> list = getAll();
        Integer maxId = 0;
        for (UserInfo userInfo : list) {
            if (userInfo != null && userInfo.getUid() > maxId) {
                maxId = userInfo.getUid();
            }
        }
        return maxId;
    }

    @Override
    public UserInfo selectUserInfoByIdCard(String idCard) {
        List<UserInfo> list = getAll();
        for (UserInfo userInfo : list) {
            if (userInfo != null && userInfo.getIdCard().equals(idCard)) {
                return userInfo;
            }
        }
        return null;
    }
}
