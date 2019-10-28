package com.i5jie.ticket.service;

import java.util.List;
import com.i5jie.ticket.beans.TcPart;
import com.i5jie.ticket.utils.plugin.QueryData;

public interface ITcPartService {


	/**
	  * 浏览页面中所用到的查询
	  */
	public List<TcPart> tcPartListPage(QueryData queryData);


	/**
	  * 详细页面中所用到的查询
	  */
	public TcPart tcPartSingle(TcPart tcPart);


	public List<TcPart> selectTcPowerName();


	public boolean insertTcPower_TcPart(TcPart tcPart);


	/**
	  * 新建插入时所用到的方法
	  */
	public Integer addTcPart(TcPart tcPart,Integer[] tcPower_id);


	/**
	  * 通过给定条件查询多对多实体的方法
	  */
	public List<TcPart> selectTcPowerList(TcPart tcPart);


	public boolean deleteTcPower_TcPartByTcPart(TcPart tcPart);


	/**
	  * 修改更新时所用到的方法
	  */
	public boolean editTcPart(TcPart tcPart,Integer[] tcPower_id);


	/**
	  * 删除时所用到的方法
	  */
	public boolean removeTcPart(TcPart tcPart);


}