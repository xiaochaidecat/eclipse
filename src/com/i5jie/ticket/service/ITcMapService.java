package com.i5jie.ticket.service;

import java.util.List;

import com.i5jie.ticket.beans.TcMap;
import com.i5jie.ticket.beans.TcMapUser;
import com.i5jie.ticket.utils.plugin.QueryData;

public interface ITcMapService {

	//页面中所需要的查询，附带条件查询
	public List<TcMapUser> tcMapListPage(QueryData queryData);

	public void addMapUser(TcMapUser tcMapUser);

	public boolean addMap(TcMap tcMap);

	public TcMapUser getMapUserById(Integer tcMapUserId);
}
