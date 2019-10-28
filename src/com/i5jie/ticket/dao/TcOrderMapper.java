package com.i5jie.ticket.dao;

import java.util.List;

import com.i5jie.ticket.beans.TcOrder;

public interface TcOrderMapper extends BaseMapper<TcOrder> {

	/**
	  * 查询多对多实体集合的方法
	  */
	public List<TcOrder> selectTcCourierName();

	/**
	  * 查询多对多实体集合的方法
	  */
	public List<TcOrder> selectTcUserName();

	/**
	  * 查询多对多实体集合的方法
	  */
	public List<TcOrder> selectTcCompanyName();

}
