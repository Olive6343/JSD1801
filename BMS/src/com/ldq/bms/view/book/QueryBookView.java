package com.ldq.bms.view.book;

import java.util.List;
import java.util.Scanner;

import com.ldq.bms.entity.BookInfo;
import com.ldq.bms.entity.UserInfo;
import com.ldq.bms.service.BookService;
import com.ldq.bms.service.impl.BookServiceImpl;
import com.ldq.bms.view.IndexView;
import com.ldq.bms.view.user.AdminView;

public class QueryBookView {
	private BookService bookService = new BookServiceImpl();
	private Scanner sc = new Scanner(System.in);
	
	public QueryBookView(UserInfo userInfo){
		query(userInfo);
	}

	private void query(UserInfo userInfo) {
		System.out.println("+++++++++查询页面+++++++++");
		System.out.println("+++++1.通过书名查询      +++++");
		System.out.println("+++++2.通过id查询          +++++");
		System.out.println("+++++3.通过书名搜索      +++++");
		System.out.println("+++++4.查询所有书籍      +++++");
		System.out.println("+++++5.返回上一层          +++++");
		while (true) {
			System.out.println("请输入选项：");
			String option = sc.next();
			if ("1".equals(option)) {// 通过书名查询（需要提供书籍的全名）
				System.out.println("请输入书名：");
				BookInfo bookInfo = bookService.queryByBookName(sc.next());
				// 如果查询到书籍，输出书籍信息；如果没有查询到，输出相关提示
				if (bookInfo != null)
					System.out.println(bookInfo);
				else
					System.out.println("没有查询到相关书籍！");
				// 回到查询页面
				query(userInfo);
				return;
			}
			if ("2".equals(option)) {// 通过id查询，id唯一标识一本书
				System.out.println("请输入书籍编号：");
				BookInfo bookInfo = bookService.queryByBookId(Integer.parseInt(sc.next()));
				// 如果查询到书籍，输出书籍信息；如果没有查询到，输出相关提示
				if (bookInfo != null)
					System.out.println(bookInfo);
				else
					System.out.println("没有查询到相关书籍！");
				// 回到查询页面
				query(userInfo);
				return;
			}
			if ("3".equals(option)) {// 通过书名搜索，书名是关键字，这个关键字可能对应多个书籍信息
				System.out.println("请输入书名：");
				List<BookInfo> list = bookService.search(sc.next());
				// 如果集合不为空，遍历集合并输出所有的书籍信息；如果为空，输出提示
				if (list != null && list.size() > 0) {
					list.forEach(bookInfo -> {
						System.out.println(bookInfo);
					});
				} else
					System.out.println("没有查询到相关书籍！");
				// 返回查询页面
				query(userInfo);
				return;
			}
			if ("4".equals(option)) {// 查询所有书籍信息
				List<BookInfo> list = bookService.getAllBooks();
				// 如果集合不为空，遍历集合并输出所有的书籍信息；如果为空，输出提示
				if (list != null && list.size() > 0) {
					list.forEach(bookInfo -> {
						System.out.println(bookInfo);
					});
				} else
					System.out.println("没有查询到相关书籍！");
				query(userInfo);
				return;
			}
			if ("5".equals(option)) {
				if (userInfo.getStatus() == 1) {
					new IndexView();
					return;
				}
				new BookCRUDView(userInfo);
				return;
			}
			System.out.println("请输入正确的选项！");
		}
	}
}
