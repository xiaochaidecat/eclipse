package com.i5jie.ticket.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.i5jie.ticket.dao.TcOrderMapper;
import com.i5jie.ticket.service.ITcOrderService;
import com.i5jie.ticket.beans.TcOrder;
import com.i5jie.ticket.utils.plugin.QueryData;

@Component
public class TcOrderServiceImpl implements ITcOrderService {

	@Autowired
	private TcOrderMapper tcOrderMapper;

	@Override
	public List<TcOrder> selectTcCourierName(){
	
		return tcOrderMapper.selectTcCourierName();
			
	}
	
	@Override
	public List<TcOrder> selectTcUserName(){
	
		return tcOrderMapper.selectTcUserName();
			
	}
	
	@Override
	public List<TcOrder> selectTcCompanyName(){
	
		return tcOrderMapper.selectTcCompanyName();
			
	}
	
	@Override
	public List<TcOrder> tcOrderListPage(QueryData queryData){
	
		return tcOrderMapper.listPage(queryData);
			
	}
	
	@Override
	public TcOrder tcOrderSingle(TcOrder tcOrder){
	
		return tcOrderMapper.getSingle(tcOrder);
			
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Integer addTcOrder(TcOrder tcOrder){
	
		return tcOrderMapper.insert(tcOrder);
			
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean editTcOrder(TcOrder tcOrder){
	
		return tcOrderMapper.update(tcOrder);
			
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean removeTcOrder(TcOrder tcOrder){
	
		return tcOrderMapper.delete(tcOrder);
			
	}
	

}