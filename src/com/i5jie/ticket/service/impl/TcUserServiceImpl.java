package com.i5jie.ticket.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.i5jie.ticket.dao.TcUserMapper;
import com.i5jie.ticket.service.ITcUserService;
import com.i5jie.ticket.beans.TcUser;
import com.i5jie.ticket.utils.plugin.QueryData;

@Component
public class TcUserServiceImpl implements ITcUserService {

	@Autowired
	private TcUserMapper tcUserMapper;

	@Override
	public List<TcUser> tcUserListPage(QueryData queryData){
	
		return tcUserMapper.listPage(queryData);
			
	}
	
	@Override
	public TcUser tcUserSingle(TcUser tcUser){
	
		return tcUserMapper.getSingle(tcUser);
			
	}
	
	@Override
	public List<TcUser> selectTcPartName(){
	
		return tcUserMapper.selectTcPartName();
			
	}
	
	@Override
	public boolean insertTcUser_TcPart(TcUser tcUser){
	
		return tcUserMapper.insertTcUser_TcPart(tcUser);
			
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Integer addTcUser(TcUser tcUser,Integer[] tcPart_id){
	
		tcUserMapper.insert(tcUser);

		if(tcPart_id != null){
			for (int i = 0; i < tcPart_id.length; i++) {
				TcUser _tcUser = new TcUser();
						
				_tcUser.setId(tcUser.getId());
				_tcUser.setTcPart_id(tcPart_id[i]);
						
				tcUserMapper.insertTcUser_TcPart(_tcUser);
			}
		}
		return tcUser.getId();
			
	}
	
	@Override
	public List<TcUser> selectTcPartList(TcUser tcUser){
	
		return tcUserMapper.selectTcPartList(tcUser);
			
	}
	
	@Override
	public boolean deleteTcUser_TcPartByTcUser(TcUser tcUser){
	
		return tcUserMapper.deleteTcUser_TcPartByTcUser(tcUser);
			
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean editTcUser(TcUser tcUser,Integer[] tcPart_id){
	
		boolean flag = tcUserMapper.update(tcUser);
		
		tcUserMapper.deleteTcUser_TcPartByTcUser(tcUser);
		
		if(tcPart_id != null){
				for (int i = 0; i < tcPart_id.length; i++) {
					TcUser _tcUser = new TcUser();
						
					_tcUser.setId(tcUser.getId());
					_tcUser.setTcPart_id(tcPart_id[i]);
						
					tcUserMapper.insertTcUser_TcPart(_tcUser);
				}
		}

		return flag;
			
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean removeTcUser(TcUser tcUser){
	
		return tcUserMapper.delete(tcUser);
			
	}
	

}