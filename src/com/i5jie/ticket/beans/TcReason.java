package com.i5jie.ticket.beans;
import java.util.*;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *业务实体bean
 *@author AutoBuild
 *
 */
@Alias("tcReason")
public class TcReason {
	
	Integer tcOrder_id;   // TcOrder实体的关联外键

	Integer tcOrderStage;  // 送票阶段

	List<TcOrder> tcOrderList;   // TcOrder实体的集合

	Integer receiveName;  // 接收人

	Integer flag;   // 逻辑删除标识位

	String tcUserName;  // 名字

	List<TcUser> tcUserList;   // TcUser实体的集合

	Integer tcUser_id;   // TcUser实体的关联外键

	Integer id;   // 实体的id

	Integer state;  // 是否处理

	String type;  // 类型

	String content;  // 拒绝内容


	public Integer getTcOrder_id() {
		return tcOrder_id;
	}

	public void setTcOrder_id(Integer tcOrder_id) {
		this.tcOrder_id = tcOrder_id;
	}
	public Integer getTcOrderStage() {
		return tcOrderStage;
	}

	public void setTcOrderStage(Integer tcOrderStage) {
		this.tcOrderStage = tcOrderStage;
	}
	public List<TcOrder> getTcOrderList() {
		return tcOrderList;
	}

	public void setTcOrderList(List<TcOrder> tcOrderList) {
		this.tcOrderList = tcOrderList;
	}
	public Integer getReceiveName() {
		return receiveName;
	}

	public void setReceiveName(Integer receiveName) {
		this.receiveName = receiveName;
	}
	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public String getTcUserName() {
		return tcUserName;
	}

	public void setTcUserName(String tcUserName) {
		this.tcUserName = tcUserName;
	}
	public List<TcUser> getTcUserList() {
		return tcUserList;
	}

	public void setTcUserList(List<TcUser> tcUserList) {
		this.tcUserList = tcUserList;
	}
	public Integer getTcUser_id() {
		return tcUser_id;
	}

	public void setTcUser_id(Integer tcUser_id) {
		this.tcUser_id = tcUser_id;
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
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
