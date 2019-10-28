package com.i5jie.ticket.beans;
import java.util.*;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *业务实体bean
 *@author AutoBuild
 *
 */
@Alias("tcCompany")
public class TcCompany {
	
	Integer flag;   // 逻辑删除标识位

	String tcCustomerName;  // 客户名称

	String tcCustomerTelephone;  // 电话

	String telephone;  // 公司电话

	String licenseCode;  // 公司编号

	String officeAddress;  // 办公地址

	Integer tcCustomer_id;   // TcCustomer实体的关联外键

	@DateTimeFormat( pattern = "yyyy-MM-dd" )//yyyy-MM-dd HH:mm:ss
	Date createTime;  // 创建时间

	List<TcCustomer> tcCustomerList;   // TcCustomer实体的集合

	String legal;  // 公司领导

	String name;  // 公司名称

	String location;  // 公司地点

	Integer id;   // 实体的id

	String info;  // 公司信息


	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public String getTcCustomerName() {
		return tcCustomerName;
	}

	public void setTcCustomerName(String tcCustomerName) {
		this.tcCustomerName = tcCustomerName;
	}
	public String getTcCustomerTelephone() {
		return tcCustomerTelephone;
	}

	public void setTcCustomerTelephone(String tcCustomerTelephone) {
		this.tcCustomerTelephone = tcCustomerTelephone;
	}
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getLicenseCode() {
		return licenseCode;
	}

	public void setLicenseCode(String licenseCode) {
		this.licenseCode = licenseCode;
	}
	public String getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}
	public Integer getTcCustomer_id() {
		return tcCustomer_id;
	}

	public void setTcCustomer_id(Integer tcCustomer_id) {
		this.tcCustomer_id = tcCustomer_id;
	}
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public List<TcCustomer> getTcCustomerList() {
		return tcCustomerList;
	}

	public void setTcCustomerList(List<TcCustomer> tcCustomerList) {
		this.tcCustomerList = tcCustomerList;
	}
	public String getLegal() {
		return legal;
	}

	public void setLegal(String legal) {
		this.legal = legal;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
}
