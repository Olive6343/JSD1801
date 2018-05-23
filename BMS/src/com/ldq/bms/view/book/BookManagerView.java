package com.ldq.bms.view.book;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ldq.bms.entity.BookInfo;
import com.ldq.bms.entity.UserInfo;
import com.ldq.bms.service.BookService;
import com.ldq.bms.service.UserService;
import com.ldq.bms.service.impl.BookServiceImpl;
import com.ldq.bms.service.impl.UserServiceImpl;
import com.ldq.bms.view.user.AdminView;

public class BookManagerView {
	private UserService userService = new UserServiceImpl();
	private BookService bookService = new BookServiceImpl();
	private Scanner sc = new Scanner(System.in);
	private UserInfo userInfo;

	public BookManagerView() {
	}

	public BookManagerView(UserInfo userInfo) {
		this.userInfo = userInfo;
		init();
		
	}

	private void init(){
		System.out.println("+++++欢迎" + userInfo.getName() + "使用图书管理系统+++++");
        System.out.println("+++++1.书籍管理                  +++++");
        System.out.println("+++++2.借书                         +++++");
        System.out.println("+++++3.还书                         +++++");
        System.out.println("+++++4.返回上一层              +++++");
        while (true) {
            System.out.println("请输入选项：");
            String option = sc.next();
            if ("1".equals(option)) {// 书籍管理
                new BookCRUDView(userInfo);
                return;
            }

            if ("2".equals(option)) {// 租赁
                rentBook();
                return;
            }
            if ("3".equals(option)) {// 还书
                returnBook();
                return;
            }
            if ("4".equals(option)) {// 返回上一层
                new AdminView(userInfo);
                return;
            }
            System.out.println("请输入正确的选项！");
        }
	}

	/**
	 * 书籍租赁
	 */
	private void rentBook() {
		System.out.println("+++++书籍租赁页面+++++");
		System.out.println("请提供证件号：");
		String idCard = sc.next();
		// 根据证件号查询用户信息
		UserInfo userInfo = userService.getUserInfoByIdCard(idCard);
		if(userInfo == null || userInfo.getStatus() != 1){
			System.out.println("证件号不可用，请联系管理员！");
			init();// 返回到主页面
			return;
		}
		
		BookInfo bookInfo = null;
		while(true){
			System.out.println("请输入书名：（y继续，n退出）");
			String bookName = sc.next();
			if("n".equalsIgnoreCase(bookName)){
				break;
			}
			
			bookInfo = bookService.queryByBookName(bookName);
			if(bookInfo == null || bookInfo.getAmount() == 0){
				System.out.println("此书不可租赁！");
				continue;
			}
			break;
		}
		
		if(bookInfo == null){
			init();
			return;
		}
		
		// 书籍数量 -1
		// 根据id更新书籍信息
		bookService.updateBookAmount(new BookInfo(bookInfo.getBid(),
				null,bookInfo.getAmount() - 1));
		// 用户租赁记录中添加该书籍的id
		userInfo.getRentBooks().add(bookInfo.getBid());
		// 根据id更新用户租赁信息
		userService.updateRentBooksById(userInfo);
		
		System.out.println("租书成功！");
		init();
		return;
	}

	/**
	 * 还书
	 */
	private void returnBook() {
		System.out.println("+++++书籍归还页面+++++");
		System.out.println("请提供证件号：");
		String idCard = sc.next();
		UserInfo userInfo = userService.getUserInfoByIdCard(idCard);
		if(userInfo == null || userInfo.getStatus() != 1){
			System.out.println("证件号不可用，请联系管理员！");
			init();
			return;
		}
		
		// 输出用户借的所有书籍的id
		userInfo.getRentBooks().forEach(bid ->{
			System.out.println("书籍id：" + bid);
		});
		
		List<Integer> ids = new ArrayList<>();
		while(true){
			System.out.println("选择要归还的书籍id：（y继续，n结束）");
			String bid = sc.next();
			if("n".equalsIgnoreCase(bid)){
				break;
			}
			
			if(!userInfo.getRentBooks().contains(Integer.parseInt(bid))){
				System.out.println("请输入正确的书籍id！");
				continue;
			}
			
			// 把需要删除的id添加到集合中
			ids.add(Integer.parseInt(bid));
		}
		// 放弃归还
		if(ids.size() == 0){
			init();
			return;
		}
		// 对应的书籍的数量+1
		bookService.returnBooks(ids);
		// 从用户的信息中剔除
		userService.updateRentBooksById(userInfo,ids);
		System.out.println("归还成功！");
		init();
		return;
	}
}
