package com.yuzhaibu.entity;

import java.util.Date;

public class BaseEntity {
	
	protected Integer ID;
	
	protected Date CreateTime;
	
	protected Date ModifyTime;

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public Date getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(Date createTime) {
		CreateTime = createTime;
	}

	public Date getModifyTime() {
		return ModifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		ModifyTime = modifyTime;
	}
}
