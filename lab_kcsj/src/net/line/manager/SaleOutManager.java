package net.line.manager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.line.common.DbUtils;
import net.line.model.Goods;
import net.line.model.SaleOut;

public class SaleOutManager {

		private DbUtils dbUtils = new DbUtils();
		List<SaleOut> saleOutList = new ArrayList<SaleOut>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		/**
		 * 添加入库信息
		 * 
		 * @param storeno
		 * @param storetype
		 * @param storemgr
		 * @param goodsid
		 * @param goodsname
		 * @param goodsprice
		 * @param goodsamount
		 * @param goodsmoney
		 * @param mgname
		 * @param storetime
		 * @param description
		 */

		/**
		 * 添加销售记录
		 * @param saleName
		 * @param saleNo
		 * @param saleTime
		 * @param goodsNo
		 * @param goodsName
		 * @param Price
		 * @param Amount
		 * @param Money
		 */
		public void addSaleOut(String saleName, String saleNo,String saleTime,
				String goodsNo, String goodsName, String Price,
				String Amount, String Money) {

			try {
				//数据库插入语句
				String sql = "insert into t_saleout(saleName,saleNo,saleTime,goodsNo, goodsName,Price,Amount,Money) values('"+saleName+"','"+saleNo+"','"+saleTime+"','"+goodsNo+"','"+goodsName+"','"+Price+"','"+Amount+"','"+Money+"')";
				//获得连接
				conn = dbUtils.getConn();
				//执行SQL命令的Statement对象
				stmt = dbUtils.createStmt(conn);
				//数据库更新次数
				int c = dbUtils.excuteUpdate(sql, stmt);
			} catch (Exception e) {
				System.out.println("add SaleOut failed!" + e.getMessage());
			} finally {
				dbUtils.closeConnAndStmt(rs, stmt, conn);
			}

		}

		/**
		 * 删除入库信息
		 * 
		 * @param storeno
		 */
		public void delSaleOut(String saleNo) {
			

			try {
				String sql = "delete from t_saleout where saleNo='" + saleNo
						+ "'";
				conn = dbUtils.getConn();
				stmt = dbUtils.createStmt(conn);
				int c = dbUtils.excuteUpdate(sql, stmt);
			} catch (Exception e) {
				
				System.out.println("add SaleOut failed!" + e.getMessage());
			}
		}

		/**
		 * 修改InStore
		 * 
		 * @param storeno
		 * @param storetype
		 * @param storemgr
		 * @param goodsid
		 * @param goodsname
		 * @param goodsprice
		 * @param goodsamount
		 * @param goodsmoney
		 * @param mgname
		 * @param storetime
		 * @param description
		 */
		public void editSaleOut(String saleName, String saleNo,String saleTime,
				String goodsNo, String goodsName, String Price,
				String Amount, String Money) {
			
			try {
				String sql = "update t_saleout set saleNo='" + saleNo
						+ "',saleName='" + saleName
						+ "',saleTime='" + saleTime
						+ "',goodsNo='" + goodsNo
						+ "',goodsName='" + goodsName + "',Price='" + Price
						+ "',Amount='" + Amount + "',Money='"
						+ Money + "' where saleNo='"+saleNo+"'";
				System.out.println(saleNo);
				conn = dbUtils.getConn();
				stmt = dbUtils.createStmt(conn);
				System.out.println("update_salout:"+sql);
				//int c = dbUtils.excuteUpdate(sql, stmt);
			} catch (Exception e) {
				System.out.println("update SaleOut failed!" + e.getMessage());
			} finally {
				dbUtils.closeConnAndStmt(rs, stmt, conn);
			}
		}
		
		/**
		 * 用list显示入库信息
		 * @param storeno
		 * @return
		 */
		public List<SaleOut> find(String saleNo){
			String sql;
			if(saleNo!=null){
				sql="select * from t_saleout where saleNo='"+saleNo+"'";
			}else{
				sql="select * from t_saleout";
			}
			try{
				System.out.println("输出sql语句："+sql);
				conn=dbUtils.getConn();
				stmt=dbUtils.createStmt(conn);
				rs=dbUtils.excuteQuery(sql, stmt);
				while(rs.next()){
					SaleOut so=new SaleOut();
					so.setSaleNo(rs.getString("saleNo"));
					so.setSaleName(rs.getString("saleName"));
					so.setSaleTime(rs.getString("saleTime"));
					so.setGoodsNo(rs.getString("goodsNo"));
					so.setGoodsName(rs.getString("goodsName"));
					so.setPrice(rs.getFloat("Price"));
					so.setAmount(rs.getInt("Amount"));
					so.setMoney(rs.getFloat("Money"));
					//把上述属性放到saleOutList
					saleOutList.add(so);
				}
			}catch (Exception e) {
				System.out.println("查询错误！"+e.getMessage());
			}finally{
				dbUtils.closeConnAndStmt(rs, stmt, conn);
			}
			return saleOutList;
		}
		
		/**
		 * 商品名称查找
		 * @return
		 */
		public List<SaleOut> findGoodsDetail() {
			String sql;
			sql="select * from t_saleout";
			try{
				conn=dbUtils.getConn();
				stmt=dbUtils.createStmt(conn);
				rs=dbUtils.excuteQuery(sql, stmt);
				while(rs.next()){
					SaleOut so=new SaleOut();
					so.setSaleNo(rs.getString("saleNo"));
					so.setGoodsNo(rs.getString("goodsNo"));
					so.setGoodsName(rs.getString("goodsName"));
					so.setPrice(rs.getFloat("Price"));
					so.setAmount(rs.getInt("Amount"));
					so.setMoney(rs.getFloat("Money"));
					saleOutList.add(so);
				}
			}catch (Exception e) {
				System.out.println("查询错误！"+e.getMessage());
			}finally{
				dbUtils.closeConnAndStmt(rs, stmt, conn);
			}
			return saleOutList;
		}
		
		public List<SaleOut> findGoodsName(){
			String sql;
			sql="select * from t_instore";
			try{
				conn=dbUtils.getConn();
				stmt=dbUtils.createStmt(conn);
				rs=dbUtils.excuteQuery(sql, stmt);
				while(rs.next()){
					SaleOut so=new SaleOut();
					so.setGoodsName(rs.getString("goodsName"));
					saleOutList.add(so);
				}
			}catch (Exception e) {
				System.out.println("查询错误！"+e.getMessage());
			}finally{
				dbUtils.closeConnAndStmt(rs, stmt, conn);
			}
			return saleOutList;
		}

}
