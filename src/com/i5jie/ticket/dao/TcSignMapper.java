package com.i5jie.ticket.dao;

import java.util.List;

import com.i5jie.ticket.beans.TcSign;

public interface TcSignMapper extends BaseMapper<TcSign> {

	/**
	  * 查询多对多实体集合的方法
	  */
	public List<TcSign> selectTcUserName();

}
