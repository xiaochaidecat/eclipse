package com.i5jie.ticket.beans;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;

@Alias("tcMapUser")
public class TcMapUser {

	//主键
	private Integer id;
	
	//围栏创建者
	private TcUser founder;
	
	//围栏创建日期
	private Date date;

	//围栏名称
	private String mapName;
	
	//围栏节点信息
	private List<TcMap> tcMapList;

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TcUser getFounder() {
		return founder;
	}

	public void setFounder(TcUser founder) {
		this.founder = founder;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMapName() {
		return mapName;
	}

	public void setMapName(String mapName) {
		this.mapName = mapName;
	}

	public List<TcMap> getTcMapList() {
		return tcMapList;
	}

	public void setTcMapList(List<TcMap> tcMapList) {
		this.tcMapList = tcMapList;
	}
	
	

	public TcMapUser(Integer id, TcUser founder, Date date, String mapName, List<TcMap> tcMapList) {
		super();
		this.id = id;
		this.founder = founder;
		this.date = date;
		this.mapName = mapName;
		this.tcMapList = tcMapList;
	}

	public TcMapUser(TcUser founder, Date date, String mapName, TcMap tcMap) {
		super();
		this.founder = founder;
		this.date = date;
		this.mapName = mapName;
	}
	
	public TcMapUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
	
	
	
}
