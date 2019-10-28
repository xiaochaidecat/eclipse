package com.i5jie.ticket.service;

import java.util.List;
import com.i5jie.ticket.beans.TcLog;
import com.i5jie.ticket.utils.plugin.QueryData;

public interface ITcLogService {


	public List<TcLog> selectTcUserName();


	public List<TcLog> selectTcOrderNumber();


	/**
	  * 浏览页面中所用到的查询
	  */
	public List<TcLog> tcLogListPage(QueryData queryData);


	/**
	  * 详细页面中所用到的查询
	  */
	public TcLog tcLogSingle(TcLog tcLog);


	/**
	  * 新建插入时所用到的方法
	  */
	public Integer addTcLog(TcLog tcLog);


	/**
	  * 删除时所用到的方法
	  */
	public boolean removeTcLog(TcLog tcLog);


}