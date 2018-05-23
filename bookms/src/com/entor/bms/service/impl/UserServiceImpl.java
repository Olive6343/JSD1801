package com.entor.bms.service.impl;

import com.entor.bms.dao.UserDAO;
import com.entor.bms.dao.impl.UserDAOImpl;
import com.entor.bms.entity.UserInfo;
import com.entor.bms.service.UserService;
import com.entor.bms.utils.LoginStatusEnum;
import com.entor.bms.utils.StringUtils;
import com.entor.bms.utils.UserStatusEnum;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO = new UserDAOImpl();

    /**
     * 调用数据访问层的添加用户的方法
     *
     * @param userInfo
     */
    @Override
    public void saveUser(UserInfo userInfo) {
        // 设置用户id，用户id是maxId + 1
        userInfo.setUid(userDAO.getMaxId() + 1);
        // 设置用户状态
        userInfo.setStatus(1);
        // 调用dao插入用户的操作
        userDAO.insertUser(userInfo);
    }

    @Override
    public boolean isIdCardOnlyOne(String idCard) {
        if (getUserInfoByIdCard(idCard) != null)
            return true;
        return false;
    }

    @Override
    public LoginStatusEnum loginValidate(String idCard, String password) {
        //  匹配证件和密码
        UserInfo userInfo = getUserInfoByIdCard(idCard);
        if (userInfo == null || !password.equals(userInfo.getPassword()))
            return LoginStatusEnum.FAILURE;
        if (userInfo.getStatus() == 0)
            return LoginStatusEnum.FROZEN;
        return LoginStatusEnum.OK;
    }

    @Override
    public UserInfo getUserInfoByIdCard(String idCard) {
        return userDAO.selectUserInfoByIdCard(idCard);
    }

    @Override
    public void updateRentBooksById(UserInfo userInfo) {
        // 查找所有用户
        List<UserInfo> list = userDAO.getAll();
        // 替换原有的对象
        list.set(list.indexOf(userInfo), userInfo);
        // 更新用户信息
        userDAO.updateUserInfo(list);
    }

    @Override
    public void updateRentBooksById(UserInfo userInfo, List<Integer> ids) {
        // 查找所有用户
        List<UserInfo> list = userDAO.getAll();
        // 获取当前用户的租赁信息
        List<Integer> idList = userInfo.getRentBooks();
        // 从list中剔除掉ids
        for (Integer i : ids) {
            idList.remove(i);
        }
        // 再将新的租赁信息覆盖到原有信息
        userInfo.setRentBooks(idList);
        // 替换原有对象
        list.set(list.indexOf(userInfo), userInfo);
        // 更新用户信息
        userDAO.updateUserInfo(list);
    }

    @Override
    public List<UserInfo> getAllUsers() {
        return userDAO.getAll();
    }

    @Override
    public List<UserInfo> getUserInfoByStatus(UserStatusEnum userStatusEnum) {
        // 根据状态类型设置要查询的状态值
        Integer status = userStatusEnum == UserStatusEnum.FROZEN ? 0 : userStatusEnum
                == UserStatusEnum.COMMON ? 1 : 2;
        // 取得所有的用户信息
        List<UserInfo> list = getAllUsers();
        // 筛选用户信息
        List<UserInfo> list2 = new ArrayList<>();
        for (UserInfo u : list) {
            if (u != null && u.getStatus() == status) {
                list2.add(u);
            }
        }
        return list2;
    }

    @Override
    public List<UserInfo> searchUserInfoByName(String name) {
        // 创建搜索结果的集合，没有元素
        List<UserInfo> searchResult = new ArrayList<>();
        // 查找所有的用户
        List<UserInfo> list = getAllUsers();
        // 遍历用户的记录
        for (UserInfo userInfo : list) {
            // 如果书名关键字被某个用户名称包含，当前用户对象就是搜索的结果之一
            // 模糊查询
            if (userInfo != null && StringUtils.containsIgnoreCase(userInfo.getName(), name)) {
                // 将查询到的有效信息添加到结果集中
                searchResult.add(userInfo);
            }
        }
        // 始终返回查询的结果集，通过结果集的元素的个数（size属性）来判断是否查询到有效信息
        return searchResult;
    }

    @Override
    public void addUser(UserInfo userInfo) {
        // 设置用户id，用户id是maxId + 1
        userInfo.setUid(userDAO.getMaxId() + 1);
        // 设置默认的密码
        userInfo.setPassword("123");
        // 设置默认用户状态
        userInfo.setStatus(1);
        // 调用dao插入用户的操作
        userDAO.insertUser(userInfo);
    }

    @Override
    public void updateUserInfoByIdCard(UserInfo userInfo) {
        // 查找所有的用户
        List<UserInfo> list = getAllUsers();
        // 遍历用户的记录
        for (UserInfo u : list) {
            if (u != null && u.getIdCard().equals(userInfo.getIdCard())) {
                if (userInfo.getName() != null)
                    u.setName(userInfo.getName());
                if (userInfo.getPassword() != null)
                    u.setPassword(userInfo.getPassword());
                if (userInfo.getStatus() != null)
                    u.setStatus(userInfo.getStatus());
            }
        }
        // 更新用户信息
        userDAO.updateUserInfo(list);
    }
}
