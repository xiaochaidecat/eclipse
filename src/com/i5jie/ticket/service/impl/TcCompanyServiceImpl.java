package com.i5jie.ticket.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.i5jie.ticket.beans.TcCompany;
import com.i5jie.ticket.dao.TcCompanyMapper;
import com.i5jie.ticket.service.ITcCompanyService;
import com.i5jie.ticket.utils.plugin.QueryData;

@Component
public class TcCompanyServiceImpl implements ITcCompanyService {

	@Autowired
	private TcCompanyMapper tcCompanyMapper;

	public List<TcCompany> tcCompanyListPage(QueryData queryData){
	
		return tcCompanyMapper.listPage(queryData);
			
	}
	
	public TcCompany tcCompanySingle(TcCompany tcCompany){
	
		return tcCompanyMapper.getSingle(tcCompany);
			
	}
	
	public List<TcCompany> selectTcCustomerName(){
	
		return tcCompanyMapper.selectTcCustomerName();
			
	}
	
	public boolean insertTcCompany_TcCustomer(TcCompany tcCompany){
	
		return tcCompanyMapper.insertTcCompany_TcCustomer(tcCompany);
			
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public Integer addTcCompany(TcCompany tcCompany,Integer[] tcCustomer_id){
	
		tcCompanyMapper.insert(tcCompany);

		if(tcCustomer_id != null){
			for (int i = 0; i < tcCustomer_id.length; i++) {
				TcCompany _tcCompany = new TcCompany();
						
				_tcCompany.setId(tcCompany.getId());
				_tcCompany.setTcCustomer_id(tcCustomer_id[i]);
						
				tcCompanyMapper.insertTcCompany_TcCustomer(_tcCompany);
			}
		}
		return tcCompany.getId();
			
	}
	
	public List<TcCompany> selectTcCustomerList(TcCompany tcCompany){
	
		return tcCompanyMapper.selectTcCustomerList(tcCompany);
			
	}
	
	public boolean deleteTcCompany_TcCustomerByTcCompany(TcCompany tcCompany){
	
		return tcCompanyMapper.deleteTcCompany_TcCustomerByTcCompany(tcCompany);
			
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean editTcCompany(TcCompany tcCompany,Integer[] tcCustomer_id){
	
		boolean flag = tcCompanyMapper.update(tcCompany);
		
		tcCompanyMapper.deleteTcCompany_TcCustomerByTcCompany(tcCompany);
		
		if(tcCustomer_id != null){
				for (int i = 0; i < tcCustomer_id.length; i++) {
					TcCompany _tcCompany = new TcCompany();
						
					_tcCompany.setId(tcCompany.getId());
					_tcCompany.setTcCustomer_id(tcCustomer_id[i]);
						
					tcCompanyMapper.insertTcCompany_TcCustomer(_tcCompany);
				}
		}

		return flag;
			
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean removeTcCompany(TcCompany tcCompany){
	
		return tcCompanyMapper.delete(tcCompany);
			
	}

	
	

}