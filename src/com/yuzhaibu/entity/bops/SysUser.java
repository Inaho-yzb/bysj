package com.yuzhaibu.entity.bops;

public class SysUser extends BaseEntity {
	
	private static final long serialVersionUID = -2906312261234435521L;
	
	private String LoginName;
	private String Password;
	
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
	
}
