package com.i5jie.ticket.dao;

import java.util.List;

import com.i5jie.ticket.utils.plugin.QueryData;

public interface BaseMapper<T> {

	public List<T> listPage(QueryData queryData);
	
	public T getSingle(T t);

	public Integer insert(T t);
	
	public boolean update(T t);
	
	public boolean delete(T t);
}
