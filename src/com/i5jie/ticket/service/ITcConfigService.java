package com.i5jie.ticket.service;

import java.util.List;
import com.i5jie.ticket.beans.TcConfig;
import com.i5jie.ticket.utils.plugin.QueryData;

public interface ITcConfigService {


	/**
	  * 浏览页面中所用到的查询
	  */
	public List<TcConfig> tcConfigListPage(QueryData queryData);


	/**
	  * 详细页面中所用到的查询
	  */
	public TcConfig tcConfigSingle(TcConfig tcConfig);


	/**
	  * 新建插入时所用到的方法
	  */
	public Integer addTcConfig(TcConfig tcConfig);


	/**
	  * 修改更新时所用到的方法
	  */
	public boolean editTcConfig(TcConfig tcConfig);


	/**
	  * 删除时所用到的方法
	  */
	public boolean removeTcConfig(TcConfig tcConfig);


}