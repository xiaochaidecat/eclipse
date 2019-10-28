package com.i5jie.ticket.service;

import java.util.List;
import com.i5jie.ticket.beans.TcSign;
import com.i5jie.ticket.utils.plugin.QueryData;

public interface ITcSignService {


	public List<TcSign> selectTcUserName();


	/**
	  * 浏览页面中所用到的查询
	  */
	public List<TcSign> tcSignListPage(QueryData queryData);


	/**
	  * 详细页面中所用到的查询
	  */
	public TcSign tcSignSingle(TcSign tcSign);


	/**
	  * 新建插入时所用到的方法
	  */
	public Integer addTcSign(TcSign tcSign);


	/**
	  * 修改更新时所用到的方法
	  */
	public boolean editTcSign(TcSign tcSign);


	/**
	  * 删除时所用到的方法
	  */
	public boolean removeTcSign(TcSign tcSign);


}