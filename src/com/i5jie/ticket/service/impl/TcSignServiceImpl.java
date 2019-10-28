package com.i5jie.ticket.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.i5jie.ticket.dao.TcSignMapper;
import com.i5jie.ticket.service.ITcSignService;
import com.i5jie.ticket.beans.TcSign;
import com.i5jie.ticket.utils.plugin.QueryData;

@Component
public class TcSignServiceImpl implements ITcSignService {

	@Autowired
	private TcSignMapper tcSignMapper;

	@Override
	public List<TcSign> selectTcUserName(){
	
		return tcSignMapper.selectTcUserName();
			
	}
	
	@Override
	public List<TcSign> tcSignListPage(QueryData queryData){
	
		return tcSignMapper.listPage(queryData);
			
	}
	
	@Override
	public TcSign tcSignSingle(TcSign tcSign){
	
		return tcSignMapper.getSingle(tcSign);
			
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Integer addTcSign(TcSign tcSign){
	
		return tcSignMapper.insert(tcSign);
			
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean editTcSign(TcSign tcSign){
	
		return tcSignMapper.update(tcSign);
			
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean removeTcSign(TcSign tcSign){
	
		return tcSignMapper.delete(tcSign);
			
	}
	

}