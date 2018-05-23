package com.entor.bms.service;

import com.entor.bms.entity.UserInfo;
import com.entor.bms.utils.LoginStatusEnum;
import com.entor.bms.utils.UserStatusEnum;

import java.util.List;

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

    /**
     * 登录判断，根据证件号、密码和状态判断用户是否可以登录
     *
     * @param idCard
     * @param password
     * @return LoginStatusEnum.OK|LoginStatusEnum.FAILURE|LoginStatusEnum.FROZEN
     */
    LoginStatusEnum loginValidate(String idCard, String password);

    UserInfo getUserInfoByIdCard(String idCard);

    /**
     * 根据id更新用户租赁信息
     *
     * @param userInfo 新的用户信息
     */
    void updateRentBooksById(UserInfo userInfo);

    /**
     * 根据id更新用户租赁信息
     *
     * @param ids id集合
     */
    void updateRentBooksById(UserInfo userInfo, List<Integer> ids);

    /**
     * 查询所有用户信息
     *
     * @return
     */
    List<UserInfo> getAllUsers();

    /**
     * 根据状态查询用户信息
     *
     * @param userStatusEnum 状态对应的枚举类型
     * @return
     */
    List<UserInfo> getUserInfoByStatus(UserStatusEnum userStatusEnum);

    /**
     * 根据姓名搜索用户
     *
     * @param name 姓名关键字
     * @return 用户信息
     */
    List<UserInfo> searchUserInfoByName(String name);

    /**
     * 添加用户信息，由管理员操作
     *
     * @param userInfo
     */
    void addUser(UserInfo userInfo);

    /**
     * 根据证件号修改用户信息
     *
     * @param userInfo
     */
    void updateUserInfoByIdCard(UserInfo userInfo);
}
