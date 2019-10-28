package com.i5jie.ticket.service;

import java.util.List;
import com.i5jie.ticket.beans.TcCustomer;
import com.i5jie.ticket.utils.plugin.QueryData;

public interface ITcCustomerService {


	/**
	  * 浏览页面中所用到的查询
	  */
	public List<TcCustomer> tcCustomerListPage(QueryData queryData);


	/**
	  * 详细页面中所用到的查询
	  */
	public TcCustomer tcCustomerSingle(TcCustomer tcCustomer);


	public List<TcCustomer> selectTcCompanyName();


	public boolean insertTcCompany_TcCustomer(TcCustomer tcCustomer);


	/**
	  * 新建插入时所用到的方法
	  */
	public Integer addTcCustomer(TcCustomer tcCustomer,Integer[] tcCompany_id);


	/**
	  * 通过给定条件查询多对多实体的方法
	  */
	public List<TcCustomer> selectTcCompanyList(TcCustomer tcCustomer);


	public boolean deleteTcCompany_TcCustomerByTcCustomer(TcCustomer tcCustomer);


	/**
	  * 修改更新时所用到的方法
	  */
	public boolean editTcCustomer(TcCustomer tcCustomer,Integer[] tcCompany_id);


	/**
	  * 删除时所用到的方法
	  */
	public boolean removeTcCustomer(TcCustomer tcCustomer);


}