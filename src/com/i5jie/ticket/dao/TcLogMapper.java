package com.i5jie.ticket.dao;

import java.util.List;

import com.i5jie.ticket.beans.TcLog;

public interface TcLogMapper extends BaseMapper<TcLog> {

	/**
	  * 查询多对多实体集合的方法
	  */
	public List<TcLog> selectTcUserName();

	/**
	  * 查询多对多实体集合的方法
	  */
	public List<TcLog> selectTcOrderNumber();

}
