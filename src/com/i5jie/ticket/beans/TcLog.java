package com.i5jie.ticket.beans;
import java.util.*;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *业务实体bean
 *@author AutoBuild
 *
 */
@Alias("tcLog")
public class TcLog {
	
	List<TcOrder> tcOrderList;   // TcOrder实体的集合

	Integer flag;   // 逻辑删除标识位

	String tcOrderNumber;  // 票数

	@DateTimeFormat( pattern = "yyyy-MM-dd" )//yyyy-MM-dd HH:mm:ss
	Date operateTime;  // 操作时间

	Integer tcUser_id;   // TcUser实体的关联外键

	List<TcUser> tcUserList;   // TcUser实体的集合

	String type;  // 类型

	String content;  // 内容

	Integer receiveId;  // 接受人

	Integer tcOrder_id;   // TcOrder实体的关联外键

	String tcUserName;  // 名字

	Integer startId;  // 发起人

	@DateTimeFormat( pattern = "yyyy-MM-dd" )//yyyy-MM-dd HH:mm:ss
	Date tcOrderOrderTime;  // 送票时间

	Integer id;   // 实体的id


	public List<TcOrder> getTcOrderList() {
		return tcOrderList;
	}

	public void setTcOrderList(List<TcOrder> tcOrderList) {
		this.tcOrderList = tcOrderList;
	}
	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public String getTcOrderNumber() {
		return tcOrderNumber;
	}

	public void setTcOrderNumber(String tcOrderNumber) {
		this.tcOrderNumber = tcOrderNumber;
	}
	public Date getOperateTime() {
		return operateTime;
	}

	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
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
	public Integer getReceiveId() {
		return receiveId;
	}

	public void setReceiveId(Integer receiveId) {
		this.receiveId = receiveId;
	}
	public Integer getTcOrder_id() {
		return tcOrder_id;
	}

	public void setTcOrder_id(Integer tcOrder_id) {
		this.tcOrder_id = tcOrder_id;
	}
	public String getTcUserName() {
		return tcUserName;
	}

	public void setTcUserName(String tcUserName) {
		this.tcUserName = tcUserName;
	}
	public Integer getStartId() {
		return startId;
	}

	public void setStartId(Integer startId) {
		this.startId = startId;
	}
	public Date getTcOrderOrderTime() {
		return tcOrderOrderTime;
	}

	public void setTcOrderOrderTime(Date tcOrderOrderTime) {
		this.tcOrderOrderTime = tcOrderOrderTime;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
