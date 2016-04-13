package com.yuzhaibu.entity.bops.query;

import com.yuzhaibu.entity.User_normal;
import com.yuzhaibu.util.Pagination;

public class BopsUserQuery extends Pagination<User_normal> {

	private static final long serialVersionUID = -386647029844466877L;
	private String Username;
	private String NickName;
	private String Email;
	private String Mobile;
	private String QQ;
	private String StartCreateTime;
	private String EndCreateTime;
	private Integer Authen;
	
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getNickName() {
		return NickName;
	}
	public void setNickName(String nickName) {
		NickName = nickName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
	public String getQQ() {
		return QQ;
	}
	public void setQQ(String qQ) {
		QQ = qQ;
	}
	public String getStartCreateTime() {
		return StartCreateTime;
	}
	public void setStartCreateTime(String startCreateTime) {
		StartCreateTime = startCreateTime;
	}
	public String getEndCreateTime() {
		return EndCreateTime;
	}
	public void setEndCreateTime(String endCreateTime) {
		EndCreateTime = endCreateTime;
	}
	public Integer getAuthen() {
		return Authen;
	}
	public void setAuthen(Integer authen) {
		Authen = authen;
	}
	public String getMobile() {
		return Mobile;
	}
	public void setMobile(String mobile) {
		Mobile = mobile;
	}
}
