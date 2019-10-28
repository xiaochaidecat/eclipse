package com.i5jie.ticket.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.i5jie.ticket.dao.TcReasonMapper;
import com.i5jie.ticket.service.ITcReasonService;
import com.i5jie.ticket.beans.TcReason;
import com.i5jie.ticket.utils.plugin.QueryData;

@Component
public class TcReasonServiceImpl implements ITcReasonService {

	@Autowired
	private TcReasonMapper tcReasonMapper;

	@Override
	public List<TcReason> selectTcOrderStage(){
	
		return tcReasonMapper.selectTcOrderStage();
			
	}
	
	@Override
	public List<TcReason> selectTcUserName(){
	
		return tcReasonMapper.selectTcUserName();
			
	}
	
	@Override
	public List<TcReason> tcReasonListPage(QueryData queryData){
	
		return tcReasonMapper.listPage(queryData);
			
	}
	
	@Override
	public TcReason tcReasonSingle(TcReason tcReason){
	
		return tcReasonMapper.getSingle(tcReason);
			
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Integer addTcReason(TcReason tcReason){
	
		return tcReasonMapper.insert(tcReason);
			
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean editTcReason(TcReason tcReason){
	
		return tcReasonMapper.update(tcReason);
			
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean removeTcReason(TcReason tcReason){
	
		return tcReasonMapper.delete(tcReason);
			
	}
	

}