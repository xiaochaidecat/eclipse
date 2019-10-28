package com.i5jie.ticket.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.i5jie.ticket.dao.TcPartMapper;
import com.i5jie.ticket.service.ITcPartService;
import com.i5jie.ticket.beans.TcPart;
import com.i5jie.ticket.utils.plugin.QueryData;

@Component
public class TcPartServiceImpl implements ITcPartService {

	@Autowired
	private TcPartMapper tcPartMapper;

	@Override
	public List<TcPart> tcPartListPage(QueryData queryData){
	
		return tcPartMapper.listPage(queryData);
			
	}
	
	@Override
	public TcPart tcPartSingle(TcPart tcPart){
	
		return tcPartMapper.getSingle(tcPart);
			
	}
	
	@Override
	public List<TcPart> selectTcPowerName(){
	
		return tcPartMapper.selectTcPowerName();
			
	}
	
	@Override
	public boolean insertTcPower_TcPart(TcPart tcPart){
	
		return tcPartMapper.insertTcPower_TcPart(tcPart);
			
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Integer addTcPart(TcPart tcPart,Integer[] tcPower_id){
	
		tcPartMapper.insert(tcPart);

		if(tcPower_id != null){
			for (int i = 0; i < tcPower_id.length; i++) {
				TcPart _tcPart = new TcPart();
						
				_tcPart.setId(tcPart.getId());
				_tcPart.setTcPower_id(tcPower_id[i]);
						
				tcPartMapper.insertTcPower_TcPart(_tcPart);
			}
		}
		return tcPart.getId();
			
	}
	
	@Override
	public List<TcPart> selectTcPowerList(TcPart tcPart){
	
		return tcPartMapper.selectTcPowerList(tcPart);
			
	}
	
	@Override
	public boolean deleteTcPower_TcPartByTcPart(TcPart tcPart){
	
		return tcPartMapper.deleteTcPower_TcPartByTcPart(tcPart);
			
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean editTcPart(TcPart tcPart,Integer[] tcPower_id){
	
		boolean flag = tcPartMapper.update(tcPart);
		
		tcPartMapper.deleteTcPower_TcPartByTcPart(tcPart);
		
		if(tcPower_id != null){
				for (int i = 0; i < tcPower_id.length; i++) {
					TcPart _tcPart = new TcPart();
						
					_tcPart.setId(tcPart.getId());
					_tcPart.setTcPower_id(tcPower_id[i]);
						
					tcPartMapper.insertTcPower_TcPart(_tcPart);
				}
		}

		return flag;
			
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean removeTcPart(TcPart tcPart){
	
		return tcPartMapper.delete(tcPart);
			
	}
	

}