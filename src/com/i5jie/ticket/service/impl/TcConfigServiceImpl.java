package com.i5jie.ticket.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.i5jie.ticket.dao.TcConfigMapper;
import com.i5jie.ticket.service.ITcConfigService;
import com.i5jie.ticket.beans.TcConfig;
import com.i5jie.ticket.utils.plugin.QueryData;

@Component
public class TcConfigServiceImpl implements ITcConfigService {

	@Autowired
	private TcConfigMapper tcConfigMapper;

	@Override
	public List<TcConfig> tcConfigListPage(QueryData queryData){
	
		return tcConfigMapper.listPage(queryData);
			
	}
	
	@Override
	public TcConfig tcConfigSingle(TcConfig tcConfig){
	
		return tcConfigMapper.getSingle(tcConfig);
			
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Integer addTcConfig(TcConfig tcConfig){
	
		return tcConfigMapper.insert(tcConfig);
			
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean editTcConfig(TcConfig tcConfig){
	
		return tcConfigMapper.update(tcConfig);
			
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean removeTcConfig(TcConfig tcConfig){
	
		return tcConfigMapper.delete(tcConfig);
			
	}
	

}