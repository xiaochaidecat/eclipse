package com.i5jie.ticket.dao;

import com.i5jie.ticket.beans.TcUser;

public interface TcLoginMapper extends BaseMapper<TcUser> {

	public TcUser login(TcUser user);
}
