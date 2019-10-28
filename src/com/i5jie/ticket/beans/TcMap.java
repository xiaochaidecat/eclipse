package com.i5jie.ticket.beans;

import org.apache.ibatis.type.Alias;

@Alias("tcMap")
public class TcMap {

	//主键
	private Integer id;
	
	//经度串
	private String node_longitude;
	
	//维度串
	private String node_latitude;
	
	//外键关联围栏主键
	private Integer mapId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNode_longitude() {
		return node_longitude;
	}

	public void setNode_longitude(String node_longitude) {
		this.node_longitude = node_longitude;
	}

	public String getNode_latitude() {
		return node_latitude;
	}

	public void setNode_latitude(String node_latitude) {
		this.node_latitude = node_latitude;
	}

	public Integer getMapId() {
		return mapId;
	}

	public void setMapId(Integer mapId) {
		this.mapId = mapId;
	}

	@Override
	public String toString() {
		return "TcMap [id=" + id + ", node_longitude=" + node_longitude + ", node_latitude=" + node_latitude
				+ ", mapId=" + mapId + "]";
	}
	
	

	public TcMap(Integer id, String node_longitude, String node_latitude, Integer mapId) {
		super();
		this.id = id;
		this.node_longitude = node_longitude;
		this.node_latitude = node_latitude;
		this.mapId = mapId;
	}

	public TcMap(String node_longitude, String node_latitude, Integer mapId) {
		super();
		this.node_longitude = node_longitude;
		this.node_latitude = node_latitude;
		this.mapId = mapId;
	}

	public TcMap() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
