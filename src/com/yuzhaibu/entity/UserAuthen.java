package com.yuzhaibu.entity;


import java.util.Date;

import org.springframework.stereotype.Repository;

@Repository
public class UserAuthen {
	
	private Integer ID;
	private String AuthenName;
	private String IdCode;
	private String Image;
	private Date CreateTime;
	private Date AuditTime;
	private Integer AuditSysUser;
	private Integer Status;
	private Integer UserId;
	private String UserNickName;
	private String AuditSysUserName;
	
	public String getUserNickName() {
		return UserNickName;
	}
	public void setUserNickName(String userNickName) {
		UserNickName = userNickName;
	}
	public String getAuditSysUserName() {
		return AuditSysUserName;
	}
	public void setAuditSysUserName(String auditSysUserName) {
		AuditSysUserName = auditSysUserName;
	}
	public Integer getStatus() {
		return Status;
	}
	public void setStatus(Integer status) {
		Status = status;
	}
	public Integer getUserId() {
		return UserId;
	}
	public void setUserId(Integer userId) {
		UserId = userId;
	}
	public String getImage() {
		return Image;
	}
	public void setImage(String image) {
		Image = image;
	}
	public Date getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(Date createTime) {
		CreateTime = createTime;
	}
	public Date getAuditTime() {
		return AuditTime;
	}
	public void setAuditTime(Date auditTime) {
		AuditTime = auditTime;
	}
	public Integer getAuditSysUser() {
		return AuditSysUser;
	}
	public void setAuditSysUser(Integer auditSysUser) {
		AuditSysUser = auditSysUser;
	}
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getAuthenName() {
		return AuthenName;
	}
	public void setAuthenName(String authenName) {
		AuthenName = authenName;
	}
	public String getIdCode() {
		return IdCode;
	}
	public void setIdCode(String idCode) {
		IdCode = idCode;
	}
	
	
}
