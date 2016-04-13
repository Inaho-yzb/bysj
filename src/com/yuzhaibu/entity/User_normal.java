package com.yuzhaibu.entity;

import java.sql.Timestamp;

import org.springframework.stereotype.Repository;

@Repository
public class User_normal {
	
	
	private int usernormal_id;
	private String username;
	private String pwd;
	private String nickname;
	private String email;
	private String mobile;
	private String qq;
	private String school;
	private String userclass;
	private int authen;
	private String cardid;
	private String cardimg;
	private int levexp;
	private Timestamp usernormalcreatime;
	private String headimg;
	private Integer itemcount;
	
	
	public Integer getItemcount() {
		return itemcount;
	}
	public void setItemcount(Integer itemcount) {
		this.itemcount = itemcount;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getUserclass() {
		return userclass;
	}
	public void setUserclass(String userclass) {
		this.userclass = userclass;
	}
	public int getAuthen() {
		return authen;
	}
	public void setAuthen(int authen) {
		this.authen = authen;
	}
	public String getCardid() {
		return cardid;
	}
	public void setCardid(String cardid) {
		this.cardid = cardid;
	}
	public String getCardimg() {
		return cardimg;
	}
	public void setCardimg(String cardimg) {
		this.cardimg = cardimg;
	}
	public int getLevexp() {
		return levexp;
	}
	public void setLevexp(int levexp) {
		this.levexp = levexp;
	}
	
	public String getHeadimg() {
		return headimg;
	}
	public void setHeadimg(String headimg) {
		this.headimg = headimg;
	}
	public Timestamp getUsernormalcreatime() {
		return usernormalcreatime;
	}
	public void setUsernormalcreatime(Timestamp usernormalcreatime) {
		this.usernormalcreatime = usernormalcreatime;
	}
	public int getUsernormal_id() {
		return usernormal_id;
	}
	public void setUsernormal_id(int usernormal_id) {
		this.usernormal_id = usernormal_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
