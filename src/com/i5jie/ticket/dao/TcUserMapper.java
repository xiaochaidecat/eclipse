package com.i5jie.ticket.dao;

import java.util.List;

import com.i5jie.ticket.beans.TcUser;

public interface TcUserMapper extends BaseMapper<TcUser> {

	/**
	  * 查询多对多实体集合的方法
	  */
	public List<TcUser> selectTcPartName();

	public boolean insertTcUser_TcPart(TcUser tcUser);

	/**
	  * 通过给定条件查询多对多实体的方法
	  */
	public List<TcUser> selectTcPartList(TcUser tcUser);

	public boolean deleteTcUser_TcPartByTcUser(TcUser tcUser);

}
