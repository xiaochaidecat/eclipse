package com.i5jie.ticket.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.i5jie.ticket.beans.TcCompany;
import com.i5jie.ticket.beans.TcMap;
import com.i5jie.ticket.beans.TcMapUser;
import com.i5jie.ticket.dao.TcMapMapper;
import com.i5jie.ticket.dao.TcMapUserMapper;
import com.i5jie.ticket.service.ITcMapService;
import com.i5jie.ticket.utils.plugin.QueryData;
@Component
public class TcMapServiceImpl implements ITcMapService {

	@Autowired
	TcMapUserMapper tcMapUserMapper;
	
	@Autowired
	TcMapMapper tcMapMapper;

	@Override
	public List<TcMapUser> tcMapListPage(QueryData queryData) {
		return tcMapUserMapper.tcMapUserListPage(queryData);
	}

	@Override
	public void addMapUser(TcMapUser tcMapUser) {
		tcMapUserMapper.addMapUser(tcMapUser);
	}

	@Override
	public boolean addMap(TcMap tcMap) {
		int count = tcMapMapper.addMap(tcMap);
		if (count>0) {
		return true;	
		}
		return false;
	}

	@Override
	public TcMapUser getMapUserById(Integer tcMapUserId) {
		TcMapUser tcMapUser = tcMapUserMapper.getMapUserById(tcMapUserId);
		List<TcMap> tcMapList = tcMapMapper.getTcMapListByMapId(tcMapUserId);
		tcMapUser.setTcMapList(tcMapList);
		return tcMapUser;
	}
	
}
