package com.i5jie.ticket.dao;

import java.util.List;

import com.i5jie.ticket.beans.TcCustomer;

public interface TcCustomerMapper extends BaseMapper<TcCustomer> {

	/**
	  * 查询多对多实体集合的方法
	  */
	public List<TcCustomer> selectTcCompanyName();

	public boolean insertTcCompany_TcCustomer(TcCustomer tcCustomer);

	/**
	  * 通过给定条件查询多对多实体的方法
	  */
	public List<TcCustomer> selectTcCompanyList(TcCustomer tcCustomer);

	public boolean deleteTcCompany_TcCustomerByTcCustomer(TcCustomer tcCustomer);

}
