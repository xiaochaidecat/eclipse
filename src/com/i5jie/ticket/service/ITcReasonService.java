package com.i5jie.ticket.service;

import java.util.List;
import com.i5jie.ticket.beans.TcReason;
import com.i5jie.ticket.utils.plugin.QueryData;

public interface ITcReasonService {


	public List<TcReason> selectTcOrderStage();


	public List<TcReason> selectTcUserName();


	/**
	  * 浏览页面中所用到的查询
	  */
	public List<TcReason> tcReasonListPage(QueryData queryData);


	/**
	  * 详细页面中所用到的查询
	  */
	public TcReason tcReasonSingle(TcReason tcReason);


	/**
	  * 新建插入时所用到的方法
	  */
	public Integer addTcReason(TcReason tcReason);


	/**
	  * 修改更新时所用到的方法
	  */
	public boolean editTcReason(TcReason tcReason);


	/**
	  * 删除时所用到的方法
	  */
	public boolean removeTcReason(TcReason tcReason);


}