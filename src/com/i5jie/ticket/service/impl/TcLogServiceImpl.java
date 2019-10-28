package com.i5jie.ticket.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.i5jie.ticket.dao.TcLogMapper;
import com.i5jie.ticket.service.ITcLogService;
import com.i5jie.ticket.beans.TcLog;
import com.i5jie.ticket.utils.plugin.QueryData;

@Component
public class TcLogServiceImpl implements ITcLogService {

	@Autowired
	private TcLogMapper tcLogMapper;

	@Override
	public List<TcLog> selectTcUserName(){
	
		return tcLogMapper.selectTcUserName();
			
	}
	
	@Override
	public List<TcLog> selectTcOrderNumber(){
	
		return tcLogMapper.selectTcOrderNumber();
			
	}
	
	@Override
	public List<TcLog> tcLogListPage(QueryData queryData){
	
		return tcLogMapper.listPage(queryData);
			
	}
	
	@Override
	public TcLog tcLogSingle(TcLog tcLog){
	
		return tcLogMapper.getSingle(tcLog);
			
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Integer addTcLog(TcLog tcLog){
	
		return tcLogMapper.insert(tcLog);
			
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean removeTcLog(TcLog tcLog){
	
		return tcLogMapper.delete(tcLog);
			
	}
	

}