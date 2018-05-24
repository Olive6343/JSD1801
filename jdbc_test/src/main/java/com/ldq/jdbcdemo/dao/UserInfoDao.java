package com.ldq.jdbcdemo.dao;

import java.util.List;

import com.ldq.jdbcdemo.entity.UserInfo;
import com.ldq.jdbcdemo.util.PageModel;

/**
 * jdbc 操作数据库的接口
 * @author Administrator
 *
 */
public interface UserInfoDao {

	/**
	 * 查询所有用户信息
	 * 
	 * @return
	 */
	List<UserInfo> selectAll();
	
	/**
	 * 新增用户记录
	 * 
	 * @return
	 */
	int add(UserInfo userInfo);
	/**
	 * 根据id删除用户记录
	 * 
	 * @param id
	 * @return
	 */
	int deleteById(Long id);
	
	/**
	 * 根据用户id修改用户记录
	 * 
	 * @param id
	 * @return
	 */
	int updateById(Long id, UserInfo userInfo);
	/**
	 * 分页查询
	 * @param pageModel
	 * @return
	 */
	PageModel<UserInfo> selectByPage(PageModel<UserInfo> pageModel);
}
