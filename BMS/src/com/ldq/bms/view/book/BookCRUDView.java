package com.ldq.bms.view.book;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ldq.bms.entity.BookInfo;
import com.ldq.bms.entity.UserInfo;
import com.ldq.bms.service.BookService;
import com.ldq.bms.service.impl.BookServiceImpl;

public class BookCRUDView {
	private Scanner sc = new Scanner(System.in);
	private BookService bookService = new BookServiceImpl();
	private UserInfo userInfo;

	public BookCRUDView(UserInfo userInfo) {
		this.userInfo = userInfo;
		crud();
	}

	/**
	 * 书籍管理页面
	 */
	private void crud() {
		System.out.println("++++++++CRUD页面+++++++++");
		System.out.println("+++++1.查询                           +++++");
		System.out.println("+++++2.增加                           +++++");
		System.out.println("+++++3.修改                           +++++");
		System.out.println("+++++4.删除                           +++++");
		System.out.println("+++++5.返回上一层                 +++++");
		while (true) {
			System.out.println("请输入选项：");
			String option = sc.next();
			if ("1".equals(option)) {// 查询
				new QueryBookView(userInfo);
				return;
			}
			if ("2".equals(option)) {// 增加
				bookAdd();
				return;
			}
			if ("3".equals(option)) {// 更新
				bookUpdateView();
				return;
			}
			if ("4".equals(option)) {// 删除
				bookDeleteView();
				return;
			}
			if ("5".equals(option)) {// 返回上一层
				new BookManagerView(userInfo);
				return;
			}
			System.out.println("请输入正确的选项！");
		}
	}
	
	/**
	 * 书籍删除页面
	 */
	private void bookDeleteView() {
		System.out.println("+++++++++书籍删除页面+++++++++");
		System.out.println("+++++1.清空书架                    +++++");
		System.out.println("+++++2.根据书名删除             +++++");
		System.out.println("+++++3.根据id批量删除          +++++");
		System.out.println("+++++4.返回上层                    +++++");
		while(true){
			System.out.println("请输入选项：");
			String option = sc.next();
			if("1".equals(option)){// 清空书架
				bookDelete();
				return;
			}
			if("2".equals(option)){// 根据书名删除
				bookDeleteByBookName();
				return;
			}
			if("3".equals(option)){// 根据id批量删除
				bookBatchDeleteById();
				return;
			}
			if("4".equals(option)){// 返回上一层
				new BookManagerView(userInfo);
				return;
			}
			System.out.println("请输入正确的选项！");
		}
	}

	/**
	 * 通过id批量删除书籍记录
	 */
	private void bookBatchDeleteById() {
		System.out.println("++++++++批量删除++++++++");
		List<Integer> list = new ArrayList<>();
		while(true){
			System.out.println("请输入id：（输入n退出！）");
			String input = sc.next();
			if("n".equals(input)){
				break;
			}
			// 保存输入的id
			list.add(Integer.parseInt(input));
		}
		
		// 根据id批量删除书籍信息
		bookService.batchDeleteByIds(list);
		
		System.out.println("删除成功！");
		bookDeleteView();// 返回删除页面
		return;
	}

	/**
	 * 根据书名删除书籍记录
	 */
	private void bookDeleteByBookName() {
		System.out.println("请输入书名：");
		String bookName = sc.next();
		
		// 根据书名获得书籍信息
		BookInfo bookInfo = bookService.queryByBookName(bookName);
		// 未查询到，无法删除
		if(bookInfo == null){
			System.out.println("书籍信息不存在，删除失败！");
			bookDeleteView();
			return;
		}
		bookService.deleteBookInfo(bookInfo);
		System.out.println("删除成功！");
		bookDeleteView();
		return;
		
	}

	/**
	 * 清空书架
	 */
	private void bookDelete() {
		System.out.println("确认清空吗？y/n");
		String input = sc.next();
		if("y".equalsIgnoreCase(input)){
			// 清空书架
			bookService.clearBooks();
			System.out.println("清理成功！");
		}
		new BookManagerView(userInfo);
		return;
	}

	/**
	 * 更新书籍
	 */
	private void bookUpdateView() {
		System.out.println("+++++++++书籍更新页面+++++++++");
		System.out.println("+++++1.重新录入                          +++++");
		System.out.println("+++++2.修改书名                          +++++");
		System.out.println("+++++3.修改数量                          +++++");
		System.out.println("+++++4.返回上一层                      +++++");
		while(true){
			System.out.println("请输入选项：");
			String option = sc.next();
			if ("1".equals(option)) {// 重新录入
				bookUpdate();
				return;
			}
			if ("2".equals(option)) {// 修改书名
				updateBookName();
				return;
			}
			if ("3".equals(option)) {// 修改数量
				updateAmount();
				return;
			}
			if ("4".equals(option)) {// 返回上一层
				new BookManagerView(userInfo);;
				return;
			}
			System.out.println("请输入正确的选项！");
		}
	}

	/**
	 * 修改数量
	 */
	private void updateAmount() {
		// 更新书籍信息
		System.out.println("请输入书名：");
		String bookName = sc.next();
		BookInfo bookInfo = bookService.queryByBookName(bookName);
		System.out.println("请输入数量:");
		String amount = sc.next();
		
		// 将新的书籍信息封装到对象中
		BookInfo newBook = new BookInfo(bookInfo.getBid(),bookInfo.getBookName(),Integer.parseInt(amount));
		
		// 根据id更新书籍信息
		bookService.updateBookInfo(newBook);
		System.out.println("更新成功！");
		
		// 返回书籍管理页面
		new BookManagerView(userInfo);
		return;
	}

	/**
	 * 修改书名
	 */
	private void updateBookName() {
		// 更新书籍信息
		System.out.println("请输入书名：");
		String bookName = sc.next();
		// 对录入的书籍名称，去重复操作
		BookInfo bookInfo = bookService.queryByBookName(bookName);
		// 没找到书籍，无法更新
		if (bookInfo == null) {
			System.out.println("没有指定书籍，请重新输入！");
			bookUpdate();
			return;
		}
		// 通过去重复操作获得书名
		String newBookName = getNewBookName(bookInfo);
		
		// 将新的书籍信息封装到对象中
		BookInfo newBook = new BookInfo(bookInfo.getBid(), newBookName, bookInfo.getAmount());

		// 根据id更新书籍信息
		bookService.updateBookInfo(newBook);
		System.out.println("更新成功！");

		// 返回书籍管理页面
		new BookManagerView(userInfo);
		return;

	}

	/**
	 * 通过去重复操作获得书名
	 * 
	 * @param bookInfo
	 * @return
	 */
	private String getNewBookName(BookInfo bookInfo) {
		String newBookName = null;
		while(true){
			System.out.println("请输入新书名：");
			newBookName = sc.next();
			
			// 新旧书名不可重复
			if(bookInfo.getBookName().equals(newBookName)){
				System.out.println("新旧书名不可重复，请重新输入！");
				continue;
			}
			
			// 录入的新书名，不可与其他书名重复
			BookInfo info = bookService.queryByBookName(newBookName);
			if(info != null){
				System.out.println("该书名已存在，请重新输入！");
				continue;
			}
			break;
		}
		return newBookName;
	}

	/**
	 * 书籍信息更新，重新录入
	 */
	private void bookUpdate() {
		// 更新书籍信息
		System.out.println("请输入书名：");
		String bookName = sc.next();
		// 对录入的书籍名称，去重复操作
		BookInfo bookInfo = bookService.queryByBookName(bookName);
		// 没找到书籍，无法更新
		if(bookInfo == null){
			System.out.println("没有指定书籍，请重新输入！");
			bookUpdate();
			return;
		}
		
		String newBookName = getNewBookName(bookInfo);
		
		System.out.println("请输入数量:");
		String amount = sc.next();
		
		// 将新的书籍信息封装到对象中
		BookInfo newBook = new BookInfo(bookInfo.getBid(),newBookName,Integer.parseInt(amount));
		
		// 根据id更新书籍信息
		bookService.updateBookInfo(newBook);
		System.out.println("更新成功！");
		
		// 返回书籍管理页面
		new BookManagerView(userInfo);
		return;
	}

	/**
	 * 新增书籍
	 */
	private void bookAdd() {
		System.out.println("+++++++++录入书籍+++++++++");
		System.out.println("请输入新增书籍名称：");
		String name = sc.next();
		System.out.println("请输入新增书籍的数量：");
		String amount = sc.next();
		
		// 封装书籍对象
		BookInfo bookInfo = new BookInfo();
		bookInfo.setBookName(name);
		bookInfo.setAmount(Integer.parseInt(amount));
		
		// 保存到数据库对象
		bookService.saveBook(bookInfo);
		System.out.println("添加成功！");

		new BookManagerView(userInfo);// 回到管理页面
		return;

	}
}
