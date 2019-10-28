package com.i5jie.ticket.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.i5jie.ticket.beans.TcUser;
import com.i5jie.ticket.dao.TcLoginMapper;
import com.i5jie.ticket.service.ITcLoginService;

@Component
public class TcLoginServiceImpl implements ITcLoginService {

	@Autowired
	private TcLoginMapper TcLoginMapper;
	
	@Override
	public TcUser login(TcUser user) {
		//
//		TcUser tcUser1=new TcUser();
//		tcUser1.setPassword(654321);
//		tcUser1.setLoginname(654321);
		//
		TcUser tcUser = TcLoginMapper.login(user);
		return tcUser;
	}

}
