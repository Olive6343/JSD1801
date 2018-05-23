package com.ldq.bms.view.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ldq.bms.entity.BookInfo;
import com.ldq.bms.entity.UserInfo;
import com.ldq.bms.service.UserService;
import com.ldq.bms.service.impl.UserServiceImpl;
import com.ldq.bms.utils.UserStatusEnum;

public class UserManagerView {
	private Scanner sc = new Scanner(System.in);
	private UserService userService = new UserServiceImpl();
	private UserInfo userInfo;

	public UserManagerView(UserInfo userInfo) {
		this.userInfo = userInfo;

		// 初始化用户管理页面
		init();
	}

//	1	midean	206343	960320		2
	/**
	 * 用户管理初始化
	 */
	private void init() {
		System.out.println("+++++++++用户管理页面+++++++++");
		System.out.println("+++++1.查询                                  +++++");
		System.out.println("+++++2.增加                                  +++++");
		System.out.println("+++++3.修改                                  +++++");
		System.out.println("+++++4.删除                                  +++++");
		System.out.println("+++++5.返回上一层                      +++++");
		while (true) {
			System.out.println("请输入选项：");
			String option = sc.next();
			if ("1".equals(option)) {// 查询
				query();
				return;
			}
			if ("2".equals(option)) {// 增加
				userAdd();
				return;
			}
			if ("3".equals(option)) {// 修改
				userUpdate();
				return;
			}
			if ("4".equals(option)) {// 删除
				userDeleteView();
				return;
			}
			if ("5".equals(option)) {// 返回上一层
				new AdminView(userInfo);
				return;
			}
		}
	}

	/**
	 * 查询用户页面
	 */
	private void query() {
		System.out.println("+++++++++查询页面+++++++++");
		System.out.println("+++++1.通过证件查询          +++++");
		System.out.println("+++++2.通过状态查询          +++++");
		System.out.println("+++++3.查询全部用户          +++++");
		System.out.println("+++++4.姓名搜索用户          +++++");
		System.out.println("+++++5.返回上一层              +++++");
		while (true) {
			System.out.println("请输入选项：");
			String option = sc.next();
			if ("1".equals(option)) {// 通过证件查询
				System.out.println("请输入证件号：");
				UserInfo userInfo = userService.getUserInfoByIdCard(sc.next());
				if (userInfo == null) {
					System.out.println("没有相关的用户信息！");
				} else {
					System.out.println(userInfo);
				}
				query();
				return;
			}
			if ("2".equals(option)) {// 通过状态查询
				queryUserInfoByStatus();
				query();
				return;
			}
			if ("3".equals(option)) {// 查询全部用户
				List<UserInfo> list = userService.getAllUsers();
				if (list != null && list.size() > 0) {
					list.forEach(userInfo -> {
						System.out.println(userInfo);
					});
				} else {
					System.out.println("没有相关用户信息！");
				}
				query();
				return;
			}
			if ("4".equals(option)) {// 姓名搜索用户
				System.out.println("请输入姓名：");
				List<UserInfo> list = userService.searchUserInfoByName(sc.next());
				if (list != null && list.size() > 0) {
					list.forEach(userInfo -> {
						System.out.println(userInfo);
					});
				} else {
					System.out.println("没有相关用户信息！");
				}
				query();
				return;
			}
			if ("5".equals(option)) {// 返回上一层
				init();
				return;
			}
			System.out.println("请输入正确的选项！");
		}
	}

	private void queryUserInfoByStatus() {
		// TODO sdf
		UserStatusEnum userStatusEnum = UserStatusEnum.FROZEN;
		System.out.println("请输入状态：");
		switch (sc.next()) {
		case "冻结":
			userStatusEnum = UserStatusEnum.FROZEN;
			break;
		case "普通用户":
			userStatusEnum = UserStatusEnum.COMMON;
			break;
		case "管理员":
			userStatusEnum = UserStatusEnum.ADMIN;
			break;
		}
		List<UserInfo> list = userService.queryUserInofByStatus(userStatusEnum);
		if (list != null && list.size() > 0) {
			list.forEach(userInfo -> {
				System.out.println(userInfo);
			});
		} else {
			System.out.println("没有相关用户信息！");
		}
	}

	/**
	 * 用户添加
	 */
	private void userAdd() {
		System.out.println("+++++++++用户添加页面+++++++++");
		System.out.println("请输入用户姓名：");
		String name = sc.next();
		String idCard = null;
		for (;;) {
			System.out.println("请输入用户证件号：");
			idCard = sc.next();

			// 验证证件号唯一
			if (!userService.isIdCardOnlyOne(idCard))
				break;
			else
				System.out.println("证件号已被使用，请重新输入！");
		}

		// 封装用户对象
		UserInfo userInfo = new UserInfo();
		userInfo.setName(name);
		userInfo.setIdCard(idCard);

		// 添加到数据库用户对象
		userService.addUser(userInfo);
		System.out.println("添加成功！");

		init();// 回到用户管理页面
		return;

	}

	/**
	 * 更新用户信息
	 */
	private void userUpdate() {
		System.out.println("+++++++++用户更新页面+++++++++");
		System.out.println("请输入有效证件号：");
		String idCard = sc.next();
		UserInfo userInfo;
		if ((userInfo = userService.getUserInfoByIdCard(idCard)) == null) {
			System.out.println("您输入的证件号不存在，请重新输入！");
			init();
			return;
		}

		UserInfo u = new UserInfo();
		u.setIdCard(userInfo.getIdCard());
		System.out.println("请输入用户姓名：（按j跳过）");
		String name;
		if (!"j".equalsIgnoreCase((name = sc.next()))) {
			u.setName(name);
		}
		System.out.println("请输入用户密码：（按j跳过）");
		String password;
		if (!"j".equalsIgnoreCase((password = sc.next()))) {
			u.setPassword(password);
		}
		System.out.println("请输入用户状态：（按j跳过）");
		String status = sc.next();

		// if (!"j".equalsIgnoreCase((status))) {
		// if (!"0".equals(status) && !"1".equals(status) &&
		// !"2".equals(status)) {
		// return;
		// }
		// u.setStatus(Integer.parseInt(status));
		// }
		// userService.updateUserInfoByIdCard(u);
		//
		// System.out.println("更新成功！");
		// init();
		// return;

		if ("0".equals(status) || "1".equals(status) || "2".equals(status)) {
			u.setStatus(Integer.parseInt(status));
		}

		userService.updateUserInfoByIdCard(u);

		System.out.println("更新成功！");
		init();
		return;
	}

	/**
	 * 
	 */
	private void userDeleteView() {
		System.out.println("+++++++++用户删除页面+++++++++");
		System.out.println("+++++1.根据姓名删除                  +++++");
		System.out.println("+++++2.根据证件号删除              +++++");
		System.out.println("+++++3.根据状态删除              +++++");
		System.out.println("+++++4.根据id批量删除            +++++");
		System.out.println("+++++5.返回上层                          +++++");
		while (true) {
			System.out.println("请输入选项：");
			String option = sc.next();
			if ("1".equals(option)) {// 根据姓名删除
				userDeleteByName();
				return;
			}
			if ("2".equals(option)) {// 根据证件号删除
				userDeleteByIdCard();
				return;
			}
			if ("3".equals(option)) {// 根据状态删除
				userDeleteByStatus();
				return;
			}
			if ("4".equals(option)) {// 根据id批量删除
				userBatchDeleteById();
				return;
			}
			if ("5".equals(option)) {// 返回上一层
				init();
				return;
			}
			System.out.println("请输入正确的选项！");
		}
	}

	/**
	 * 通过状态删除用户信息
	 * 
	 */
	private void userDeleteByStatus() {
		// TODO
		Integer status = 1;
		System.out.println("请输入状态：");
		String input = sc.next();
		switch (input) {
		case "冻结":
			status = 0;
			break;
		case "普通用户":
			status = 1;
			break;
		case "管理员":
			status = 2;
			break;
		}
		
		List<UserInfo> list = userService.getUserListByStatus(status);
//		List<UserInfo> list = userService.getAllUsers();
		// 如果查询不到用户信息，无法删除
		if(list == null){
			System.out.println("查无此状态的用户，删除失败！");
			userDeleteView();
			return;
		}
		
		userService.deleteUserInfoByStatus(status);
		
		System.out.println("删除成功！");
		userDeleteView();
		return;
	}

	/**
	 * 通过姓名删除用户信息
	 */
	private void userDeleteByName() {
		System.out.println("请输入姓名：");
		String name = sc.next();
		// 根据姓名获得用户信息
		UserInfo userInfo = userService.getUserInfoByName(name);
		// 若未查到用户信息，无法删除
		if (userInfo == null) {
			System.out.println("用户不存在，删除失败！");
			userDeleteView();
			return;
		}

		userService.deleteUserInfo(userInfo);
		System.out.println("删除成功！");
		userDeleteView();
		return;
	}

	/**
	 * 通过证件号删除用户信息
	 * 
	 */
	private void userDeleteByIdCard() {
		System.out.println("请输入证件号：");
		String idCard = sc.next();
		// 根据idCard获得用户信息
		UserInfo userInfo = userService.getUserInfoByIdCard(idCard);
		// 如果查询不到用户，则无法删除
		if (userInfo == null) {
			System.out.println("用户不存在，删除失败！");
			userDeleteView();
			return;
		}
		userService.deleteUserInfo(userInfo);
		System.out.println("删除成功！");
		userDeleteView();
		return;
	}

	/**
	 * 通过id批量删除用户信息
	 * 
	 */
	private void userBatchDeleteById() {
		System.out.println("++++++++批量删除++++++++");
		// 创建数组，用来保存id
		List<Integer> list = new ArrayList<>();
		while (true) {
			System.out.println("请输入id：（输入n结束！）");
			String input = sc.next();
			if ("n".equals(input)) {
				break;
			}
			// 保存输入的id
			list.add(Integer.parseInt(input));
		}
		// 根据id批量删除用户信息
		userService.batchDeleteByIds(list);
		System.out.println("删除成功！");
		userDeleteView();
		return;
	}

}
