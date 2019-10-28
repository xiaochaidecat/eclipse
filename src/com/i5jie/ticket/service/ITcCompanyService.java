package com.i5jie.ticket.service;

import java.util.List;
import com.i5jie.ticket.beans.TcCompany;
import com.i5jie.ticket.utils.plugin.QueryData;

public interface ITcCompanyService {


	/**
	  * 浏览页面中所用到的查询
	  */
	public List<TcCompany> tcCompanyListPage(QueryData queryData);


	/**
	  * 详细页面中所用到的查询
	  */
	public TcCompany tcCompanySingle(TcCompany tcCompany);


	public List<TcCompany> selectTcCustomerName();


	public boolean insertTcCompany_TcCustomer(TcCompany tcCompany);


	/**
	  * 新建插入时所用到的方法
	  */
	public Integer addTcCompany(TcCompany tcCompany,Integer[] tcCustomer_id);


	/**
	  * 通过给定条件查询多对多实体的方法
	  */
	public List<TcCompany> selectTcCustomerList(TcCompany tcCompany);


	public boolean deleteTcCompany_TcCustomerByTcCompany(TcCompany tcCompany);


	/**
	  * 修改更新时所用到的方法
	  */
	public boolean editTcCompany(TcCompany tcCompany,Integer[] tcCustomer_id);


	/**
	  * 删除时所用到的方法
	  */
	public boolean removeTcCompany(TcCompany tcCompany);


}