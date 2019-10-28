package com.i5jie.ticket.dao;

import java.util.List;

import com.i5jie.ticket.beans.TcReason;

public interface TcReasonMapper extends BaseMapper<TcReason> {

	/**
	  * 查询多对多实体集合的方法
	  */
	public List<TcReason> selectTcOrderStage();

	/**
	  * 查询多对多实体集合的方法
	  */
	public List<TcReason> selectTcUserName();

}
