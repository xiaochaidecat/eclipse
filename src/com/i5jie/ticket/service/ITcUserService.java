package com.i5jie.ticket.service;

import java.util.List;
import com.i5jie.ticket.beans.TcUser;
import com.i5jie.ticket.utils.plugin.QueryData;

public interface ITcUserService {


	/**
	  * 浏览页面中所用到的查询
	  */
	public List<TcUser> tcUserListPage(QueryData queryData);


	/**
	  * 详细页面中所用到的查询
	  */
	public TcUser tcUserSingle(TcUser tcUser);


	public List<TcUser> selectTcPartName();


	public boolean insertTcUser_TcPart(TcUser tcUser);


	/**
	  * 新建插入时所用到的方法
	  */
	public Integer addTcUser(TcUser tcUser,Integer[] tcPart_id);


	/**
	  * 通过给定条件查询多对多实体的方法
	  */
	public List<TcUser> selectTcPartList(TcUser tcUser);


	public boolean deleteTcUser_TcPartByTcUser(TcUser tcUser);


	/**
	  * 修改更新时所用到的方法
	  */
	public boolean editTcUser(TcUser tcUser,Integer[] tcPart_id);


	/**
	  * 删除时所用到的方法
	  */
	public boolean removeTcUser(TcUser tcUser);


}