package com.i5jie.ticket.service;

import java.util.List;
import com.i5jie.ticket.beans.TcOrder;
import com.i5jie.ticket.utils.plugin.QueryData;

public interface ITcOrderService {


	public List<TcOrder> selectTcCourierName();


	public List<TcOrder> selectTcUserName();


	public List<TcOrder> selectTcCompanyName();


	/**
	  * 浏览页面中所用到的查询
	  */
	public List<TcOrder> tcOrderListPage(QueryData queryData);


	/**
	  * 详细页面中所用到的查询
	  */
	public TcOrder tcOrderSingle(TcOrder tcOrder);


	/**
	  * 新建插入时所用到的方法
	  */
	public Integer addTcOrder(TcOrder tcOrder);


	/**
	  * 修改更新时所用到的方法
	  */
	public boolean editTcOrder(TcOrder tcOrder);


	/**
	  * 删除时所用到的方法
	  */
	public boolean removeTcOrder(TcOrder tcOrder);


}