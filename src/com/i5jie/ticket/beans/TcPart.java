package com.i5jie.ticket.beans;
import java.util.*;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *业务实体bean
 *@author AutoBuild
 *
 */
@Alias("tcPart")
public class TcPart {
	
	Integer tcPower_id;   // TcPower实体的关联外键

	List<TcPart> tcPowerList;   // TcPart实体的集合

	Integer flag;   // 逻辑删除标识位

	String tcPowerName;  // 权限名

	String name;  // 角色名

	Integer id;   // 实体的id


	public Integer getTcPower_id() {
		return tcPower_id;
	}

	public void setTcPower_id(Integer tcPower_id) {
		this.tcPower_id = tcPower_id;
	}
	public List<TcPart> getTcPowerList() {
		return tcPowerList;
	}

	public void setTcPowerList(List<TcPart> tcPowerList) {
		this.tcPowerList = tcPowerList;
	}
	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public String getTcPowerName() {
		return tcPowerName;
	}

	public void setTcPowerName(String tcPowerName) {
		this.tcPowerName = tcPowerName;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
