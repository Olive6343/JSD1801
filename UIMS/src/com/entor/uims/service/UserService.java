package com.entor.uims.service;

import java.util.List;

import com.entor.uims.dao.UserDao;
import com.entor.uims.domain.User;


/**
 * 处理用户数据的业务逻辑层
 * @author Administrator
 *
 */
public class UserService {

	private UserDao userDao = new UserDao();//service的逻辑需要依赖dao的数据
	
	/**
	 * 验证登录名和密码
	 * @param loginName
	 * @param password
	 * @return
	 */
	public boolean validate(String loginName,String password){
		
		//1.根据登录名和密码取出表记录对应的user对象
		User user = userDao.getByLoginNameAndPassword(loginName, password);
		//2.判断user
		if(user == null){
			return false;
		}
		return true;
	}
	
	/**
	 * 根据登录名查找用户
	 * 
	 * @param loginname
	 * @return
	 */
	public User getUserByLoginName(String loginname){
		return userDao.getUserByLoginName(loginname);
	}
	
	/**
	 * 根据登录名判断用户是否存在
	 * 
	 * @param loginName
	 * @return
	 */
	public boolean isNameExist(String loginName) {
		User user = getUserByLoginName(loginName);
		if(user == null){
			return false;
		}
		return true;
	}

	/**
	 * 保存用户
	 * 
	 * @param user
	 */
	public void saveUser(User user) {
		userDao.save(user);
	}

	/**
	 * 根据id查找用户信息
	 * 
	 * @param userid
	 * @return
	 */
	public User getUserById(String userid) {
		return userDao.getUserById(userid);
	}

	/**
	 * 根据id和姓名判断用户是否存在
	 * 
	 * @param userid
	 * @param name
	 * @return
	 */
	public boolean isNameExist(String userid, String name) {
		User user = userDao.getByIdAndName(userid,name);
		if(user == null)
			return false; 
		return true;
	}

	/**
	 * 根据id修改姓名
	 * 
	 * @param userid
	 * @param realname
	 */
	public void updateNameById(String userid, String realname) {
		userDao.updateNameById(userid,realname);
	}

	/**
	 * 根据用户输入的密码是否匹配
	 * 
	 * @param userid
	 * @param oldpass
	 * @return
	 */
	@SuppressWarnings("null")
	public boolean isPassExist(String userid, String oldpass) {
		User user = userDao.getUserById(userid);
		if(user == null && oldpass.equals(user.getPassword()))
			return false; 
		return true;
	}
	
	/**
	 * 根据id修改密码
	 * 
	 * @param userid
	 * @param password
	 */
	public void updatePassById(String userid, String password) {
		userDao.updatePassById(userid,password);
	}

	/**
	 * 取出所有用户
	 * @return
	 */
	public List<User> getAllUsers() {
		List<User> userlist = userDao.getAll();
		System.out.println(userlist);
		return userlist;
	}

	/**
	 * 根据登录名判断用户是否存在
	 * @param loginname
	 * @return
	 */
	public boolean isLoginNameExist(String loginname) {
		User user = getUserByLoginName(loginname);
		if(user == null){
			return false;
		}
		return true;
	}

	/**
	 * 更新用户信息
	 * @param user
	 */
	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	//根据用户删除用户信息
	public void deleteUser(String userid) {
		userDao.deleteById(userid);
	}

	
	/**
	 * 根据用户id批量删除用户
	 * @param userids
	 */
	public void batchDel(String[] userids) {
		userDao.batchDelete(userids);
		
	}
	
	
	
}
