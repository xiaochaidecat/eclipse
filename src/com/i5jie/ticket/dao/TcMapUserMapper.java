package com.i5jie.ticket.dao;

import java.util.List;

import com.i5jie.ticket.beans.TcMap;
import com.i5jie.ticket.beans.TcMapUser;
import com.i5jie.ticket.utils.plugin.QueryData;

public interface TcMapUserMapper extends BaseMapper<TcMapUserMapper> {

	public List<TcMapUser> tcMapUserListPage(QueryData queryData);

	public void addMapUser(TcMapUser tcMapUser);

	public TcMapUser getMapUserById(Integer tcMapUserId);
	
}
