package com.i5jie.ticket.beans;
import java.util.*;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *业务实体bean
 *@author AutoBuild
 *
 */
@Alias("tcOrder")
public class TcOrder {
	
	Integer orderType;  // 送票方式

	Integer flag;   // 逻辑删除标识位

	List<TcCompany> tcCompanyList;   // TcCompany实体的集合

	Integer tcCourier_id;   // TcCourier实体的关联外键

	Integer tcUser_id;   // TcUser实体的关联外键

	List<TcUser> tcUserList;   // TcUser实体的集合

	String tcCourierName;  // 快递名

	String courierNumber;  // 快递单号

	Integer number;  // 票数

	String tcCompanyName;  // 公司名称

	@DateTimeFormat( pattern = "yyyy-MM-dd" )//yyyy-MM-dd HH:mm:ss
	Date orderTime;  // 送票时间

	Integer stage;  // 送票阶段

	String tcUserName;  // 名字

	Integer tcCompany_id;   // TcCompany实体的关联外键

	Integer id;   // 实体的id

	List<TcOrder> tcCourierList;   // TcOrder实体的集合


	public Integer getOrderType() {
		return orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}
	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public List<TcCompany> getTcCompanyList() {
		return tcCompanyList;
	}

	public void setTcCompanyList(List<TcCompany> tcCompanyList) {
		this.tcCompanyList = tcCompanyList;
	}
	public Integer getTcCourier_id() {
		return tcCourier_id;
	}

	public void setTcCourier_id(Integer tcCourier_id) {
		this.tcCourier_id = tcCourier_id;
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
	public String getTcCourierName() {
		return tcCourierName;
	}

	public void setTcCourierName(String tcCourierName) {
		this.tcCourierName = tcCourierName;
	}
	public String getCourierNumber() {
		return courierNumber;
	}

	public void setCourierNumber(String courierNumber) {
		this.courierNumber = courierNumber;
	}
	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getTcCompanyName() {
		return tcCompanyName;
	}

	public void setTcCompanyName(String tcCompanyName) {
		this.tcCompanyName = tcCompanyName;
	}
	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public Integer getStage() {
		return stage;
	}

	public void setStage(Integer stage) {
		this.stage = stage;
	}
	public String getTcUserName() {
		return tcUserName;
	}

	public void setTcUserName(String tcUserName) {
		this.tcUserName = tcUserName;
	}
	public Integer getTcCompany_id() {
		return tcCompany_id;
	}

	public void setTcCompany_id(Integer tcCompany_id) {
		this.tcCompany_id = tcCompany_id;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public List<TcOrder> getTcCourierList() {
		return tcCourierList;
	}

	public void setTcCourierList(List<TcOrder> tcCourierList) {
		this.tcCourierList = tcCourierList;
	}
}
