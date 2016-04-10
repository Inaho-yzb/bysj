package com.yuzhaibu.entity.bops.query;

import java.util.Date;

import com.yuzhaibu.entity.bops.SysUser;
import com.yuzhaibu.util.Pagination;

public class SysUserQuery extends Pagination<SysUser> {

	private static final long serialVersionUID = 4710957360964609299L;
	
	private Integer ID;
	private String LoginName;
	private String Password;
	private String error;
	private Date CreateTime;
	
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getLoginName() {
		return LoginName;
	}
	public void setLoginName(String loginName) {
		LoginName = loginName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public Date getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(Date createTime) {
		CreateTime = createTime;
	}

}
