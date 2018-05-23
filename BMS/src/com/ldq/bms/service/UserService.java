package com.ldq.bms.service;

import java.util.List;

import com.ldq.bms.entity.UserInfo;
import com.ldq.bms.utils.LoginStatusEnum;
import com.ldq.bms.utils.UserStatusEnum;

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

    /**
     * 判断idCard是否唯一
     * 
     * @param idCard
     * @return
     */
    boolean isIdCardOnlyOne(String idCard);

    LoginStatusEnum loginValidate(String idCard, String password);

    /**
     * 根据idCard获得用户信息
     * 
     * @param idCard
     * @return
     */
    UserInfo getUserInfoByIdCard(String idCard);

    /**
     * 根据id更新用户租赁信息
     * 
     * @param userInfo
     */
	void updateRentBooksById(UserInfo userInfo);

	/**
	 * 根据id更新用户租赁信息
	 * 
	 * @param userInfo
	 * @param ids
	 */
	void updateRentBooksById(UserInfo userInfo, List<Integer> ids);

	/**
	 * 查询所有用户信息
	 * 
	 * @return
	 */
	List<UserInfo> getAllUsers();

	/**
	 * 根据状态获得用户信息
	 * 
	 * @param Integer 状态对应的值
	 * @return 用户信息集合
	 */
	List<UserInfo> getUserListByStatus(Integer status);
	
	/**
	 * 根据状态获得用户信息
	 * 
	 * @param status
	 * @return
	 */
	UserInfo getUserInfoByStatus(Integer status);

	/**
	 * 通过姓名关键字查找用户信息
	 * 
	 * @param name 姓名关键字
	 * @return 用户信息
	 */
	List<UserInfo> searchUserInfoByName(String name);

	/**
	 * 添加用户信息， 由管理员操作
	 * 
	 * @param userInfo 用户信息
	 */
	void addUser(UserInfo userInfo);

	/**
	 * 根据证件号修改用户信息
	 * @param u
	 */
	void updateUserInfoByIdCard(UserInfo u);

	/**
	 * 通过姓名查找用户信息
	 * 
	 * @param name 姓名
	 * @return
	 */
	UserInfo getUserInfoByName(String name);

	/**
	 * 删除指定的用户信息
	 * 
	 * @param userInfo 待删除的用户对象
	 */
	void deleteUserInfo(UserInfo userInfo);

	/**
	 * 通过ids批量删除用户信息
	 * 
	 * @param list 待删除的id数组
	 */
	void batchDeleteByIds(List<Integer> list);

	/**
	 * 根据状态查询用户信息
	 * 
	 * @param userStatusEnum 状态对应的枚举类型
	 * @return 用户信息集合
	 */
	List<UserInfo> queryUserInofByStatus(UserStatusEnum userStatusEnum);

	/**
	 * 根据状态删除用户信息
	 * 
	 * @param list 待删除用户集合
	 */
	void deleteUserInfoByStatus(Integer status);
}
