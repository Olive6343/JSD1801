package com.entor.bms.dao.impl;

import com.entor.bms.dao.UserDAO;
import com.entor.bms.entity.UserInfo;
import com.entor.bms.utils.EditUtils;
import com.entor.bms.utils.ReadAndWriteUtils;

import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public void insertUser(UserInfo userInfo) {
        // 指定插入的文件的路径和用户记录
        ReadAndWriteUtils.singleWrite(EditUtils.userInfoToString(userInfo), ReadAndWriteUtils.USER_FILE_PATH);
    }

    @Override
    public List<UserInfo> getAll() {
        return ReadAndWriteUtils.readAllUserRecords();
    }

    @Override
    public Integer getMaxId() {
        // 获得所有的用户对象
        List<UserInfo> list = getAll();
        // 查找出最大的用户id
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

    @Override
    public void updateUserInfo(List<UserInfo> list) {
        //  将书籍集合写入到文件
        ReadAndWriteUtils.multiUsersWrite(list, ReadAndWriteUtils.USER_FILE_PATH);
    }
}
