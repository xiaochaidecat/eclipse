package com.i5jie.ticket.dao;

import java.util.List;

import com.i5jie.ticket.beans.TcPart;

public interface TcPartMapper extends BaseMapper<TcPart> {

	/**
	  * 查询多对多实体集合的方法
	  */
	public List<TcPart> selectTcPowerName();

	public boolean insertTcPower_TcPart(TcPart tcPart);

	/**
	  * 通过给定条件查询多对多实体的方法
	  */
	public List<TcPart> selectTcPowerList(TcPart tcPart);

	public boolean deleteTcPower_TcPartByTcPart(TcPart tcPart);

}
