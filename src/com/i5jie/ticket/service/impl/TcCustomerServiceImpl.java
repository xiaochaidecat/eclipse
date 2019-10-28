package com.i5jie.ticket.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.i5jie.ticket.dao.TcCustomerMapper;
import com.i5jie.ticket.service.ITcCustomerService;
import com.i5jie.ticket.beans.TcCustomer;
import com.i5jie.ticket.utils.plugin.QueryData;

@Component
public class TcCustomerServiceImpl implements ITcCustomerService {

	@Autowired
	private TcCustomerMapper tcCustomerMapper;

	@Override
	public List<TcCustomer> tcCustomerListPage(QueryData queryData){
	
		return tcCustomerMapper.listPage(queryData);
			
	}
	
	@Override
	public TcCustomer tcCustomerSingle(TcCustomer tcCustomer){
	
		return tcCustomerMapper.getSingle(tcCustomer);
			
	}
	
	@Override
	public List<TcCustomer> selectTcCompanyName(){
	
		return tcCustomerMapper.selectTcCompanyName();
			
	}
	
	@Override
	public boolean insertTcCompany_TcCustomer(TcCustomer tcCustomer){
	
		return tcCustomerMapper.insertTcCompany_TcCustomer(tcCustomer);
			
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Integer addTcCustomer(TcCustomer tcCustomer,Integer[] tcCompany_id){
	
		tcCustomerMapper.insert(tcCustomer);

		if(tcCompany_id != null){
			for (int i = 0; i < tcCompany_id.length; i++) {
				TcCustomer _tcCustomer = new TcCustomer();
						
				_tcCustomer.setId(tcCustomer.getId());
				_tcCustomer.setTcCompany_id(tcCompany_id[i]);
						
				tcCustomerMapper.insertTcCompany_TcCustomer(_tcCustomer);
			}
		}
		return tcCustomer.getId();
			
	}
	
	@Override
	public List<TcCustomer> selectTcCompanyList(TcCustomer tcCustomer){
	
		return tcCustomerMapper.selectTcCompanyList(tcCustomer);
			
	}
	
	@Override
	public boolean deleteTcCompany_TcCustomerByTcCustomer(TcCustomer tcCustomer){
	
		return tcCustomerMapper.deleteTcCompany_TcCustomerByTcCustomer(tcCustomer);
			
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean editTcCustomer(TcCustomer tcCustomer,Integer[] tcCompany_id){
	
		boolean flag = tcCustomerMapper.update(tcCustomer);
		
		tcCustomerMapper.deleteTcCompany_TcCustomerByTcCustomer(tcCustomer);
		
		if(tcCompany_id != null){
				for (int i = 0; i < tcCompany_id.length; i++) {
					TcCustomer _tcCustomer = new TcCustomer();
						
					_tcCustomer.setId(tcCustomer.getId());
					_tcCustomer.setTcCompany_id(tcCompany_id[i]);
						
					tcCustomerMapper.insertTcCompany_TcCustomer(_tcCustomer);
				}
		}

		return flag;
			
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean removeTcCustomer(TcCustomer tcCustomer){
	
		return tcCustomerMapper.delete(tcCustomer);
			
	}
	

}