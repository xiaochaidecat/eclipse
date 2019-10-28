package com.i5jie.ticket.dao;

import java.util.List;

import com.i5jie.ticket.beans.TcCompany;

public interface TcCompanyMapper extends BaseMapper<TcCompany> {

	/**
	  * 查询多对多实体集合的方法
	  */
	public List<TcCompany> selectTcCustomerName();

	public boolean insertTcCompany_TcCustomer(TcCompany tcCompany);

	/**
	  * 通过给定条件查询多对多实体的方法
	  */
	public List<TcCompany> selectTcCustomerList(TcCompany tcCompany);

	public boolean deleteTcCompany_TcCustomerByTcCompany(TcCompany tcCompany);

}
