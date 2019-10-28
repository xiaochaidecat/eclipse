package com.i5jie.ticket.beans;
import java.util.*;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *业务实体bean
 *@author AutoBuild
 *
 */
@Alias("tcUser")
public class TcUser {
	
	String password;  // 密码

	Integer tcPart_id;   // TcPart实体的关联外键

	Integer flag;   // 逻辑删除标识位

	String loginname;  // 登录名

	String tcPartName;  // 角色名

	List<TcPart> tcPartList;   // TcPart实体的集合

	String name;  // 名字

	String telephone;  // 电话

	Integer id;   // 实体的id


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getTcPart_id() {
		return tcPart_id;
	}

	public void setTcPart_id(Integer tcPart_id) {
		this.tcPart_id = tcPart_id;
	}
	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getTcPartName() {
		return tcPartName;
	}

	public void setTcPartName(String tcPartName) {
		this.tcPartName = tcPartName;
	}
	public List<TcPart> getTcPartList() {
		return tcPartList;
	}

	public void setTcPartList(List<TcPart> tcPartList) {
		this.tcPartList = tcPartList;
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

	@Override
	public String toString() {
		return "TcUser [password=" + password + ", tcPart_id=" + tcPart_id + ", flag=" + flag + ", loginname="
				+ loginname + ", tcPartName=" + tcPartName + ", tcPartList=" + tcPartList + ", name=" + name
				+ ", telephone=" + telephone + ", id=" + id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((flag == null) ? 0 : flag.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((loginname == null) ? 0 : loginname.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((tcPartList == null) ? 0 : tcPartList.hashCode());
		result = prime * result + ((tcPartName == null) ? 0 : tcPartName.hashCode());
		result = prime * result + ((tcPart_id == null) ? 0 : tcPart_id.hashCode());
		result = prime * result + ((telephone == null) ? 0 : telephone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TcUser other = (TcUser) obj;
		if (flag == null) {
			if (other.flag != null)
				return false;
		} else if (!flag.equals(other.flag))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (loginname == null) {
			if (other.loginname != null)
				return false;
		} else if (!loginname.equals(other.loginname))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (tcPartList == null) {
			if (other.tcPartList != null)
				return false;
		} else if (!tcPartList.equals(other.tcPartList))
			return false;
		if (tcPartName == null) {
			if (other.tcPartName != null)
				return false;
		} else if (!tcPartName.equals(other.tcPartName))
			return false;
		if (tcPart_id == null) {
			if (other.tcPart_id != null)
				return false;
		} else if (!tcPart_id.equals(other.tcPart_id))
			return false;
		if (telephone == null) {
			if (other.telephone != null)
				return false;
		} else if (!telephone.equals(other.telephone))
			return false;
		return true;
	}
	
	
}
