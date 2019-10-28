package com.i5jie.ticket.beans;
import java.util.*;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *业务实体bean
 *@author AutoBuild
 *
 */
@Alias("tcSign")
public class TcSign {
	
	Integer flag;   // 逻辑删除标识位

	@DateTimeFormat( pattern = "yyyy-MM-dd" )//yyyy-MM-dd HH:mm:ss
	Date createTime;  // 创建时间

	String tcUserName;  // 名字

	Integer tcUser_id;   // TcUser实体的关联外键

	List<TcUser> tcUserList;   // TcUser实体的集合

	Integer id;   // 实体的id

	Integer state;  // 签到状态


	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getTcUserName() {
		return tcUserName;
	}

	public void setTcUserName(String tcUserName) {
		this.tcUserName = tcUserName;
	}
	public Integer getTcUser_id() {
		return tcUser_id;
	}

	public void setTcUser_id(Integer tcUser_id) {
		this.tcUser_id = tcUser_id;
	}
	public List<TcUser> getTcUserList() {
		return tcUserList;
	}

	public void setTcUserList(List<TcUser> tcUserList) {
		this.tcUserList = tcUserList;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
}
