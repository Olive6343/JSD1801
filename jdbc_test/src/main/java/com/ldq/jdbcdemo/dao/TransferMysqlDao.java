package com.ldq.jdbcdemo.dao;

public interface TransferMysqlDao {
	/**
	 * 转账，调用存储过程
	 * @param inId
	 * @param outId
	 * @param money
	 * @return
	 */
	boolean transfer(Long inId,Long outId,double money);
}
