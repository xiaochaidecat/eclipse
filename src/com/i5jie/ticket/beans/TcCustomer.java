package com.i5jie.ticket.beans;
import java.util.*;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *业务实体bean
 *@author AutoBuild
 *
 */
@Alias("tcCustomer")
public class TcCustomer {
	
	String tcCompanyName;  // 公司名称

	Integer flag;   // 逻辑删除标识位

	@DateTimeFormat( pattern = "yyyy-MM-dd" )//yyyy-MM-dd HH:mm:ss
	Date createTime;  // 创建时间

	List<TcCompany> tcCompanyList;   // TcCompany实体的集合

	Integer tcCompany_id;   // TcCompany实体的关联外键

	String name;  // 客户名称

	String telephone;  // 电话

	Integer id;   // 实体的id


	public String getTcCompanyName() {
		return tcCompanyName;
	}

	public void setTcCompanyName(String tcCompanyName) {
		this.tcCompanyName = tcCompanyName;
	}
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
	public List<TcCompany> getTcCompanyList() {
		return tcCompanyList;
	}

	public void setTcCompanyList(List<TcCompany> tcCompanyList) {
		this.tcCompanyList = tcCompanyList;
	}
	public Integer getTcCompany_id() {
		return tcCompany_id;
	}

	public void setTcCompany_id(Integer tcCompany_id) {
		this.tcCompany_id = tcCompany_id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
