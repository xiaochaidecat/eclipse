package com.i5jie.ticket.dao;

import java.util.List;

import com.i5jie.ticket.beans.TcCompany;
import com.i5jie.ticket.beans.TcMap;
import com.i5jie.ticket.beans.TcMapUser;
import com.i5jie.ticket.utils.plugin.QueryData;

public interface TcMapMapper extends BaseMapper<TcMapUser> {

	int addMap(TcMap tcMap);

	List<TcMap> getTcMapListByMapId(Integer tcMapUserId);


}
