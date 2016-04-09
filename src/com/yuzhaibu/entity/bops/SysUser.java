package com.yuzhaibu.entity.bops;

import org.springframework.stereotype.Repository;

@Repository
public class SysUser extends BaseEntity {
	
	private static final long serialVersionUID = -2906312261234435521L;
	
	private String LoginName;
	private String Password;
	
	private String error;
	
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
	
	
}
