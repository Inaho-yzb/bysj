package com.yuzhaibu.entity;

import org.springframework.stereotype.Repository;

@Repository
public class Report {
	private Integer id;
	private Integer itemid;
	private Integer userid;
	private Integer reasonid;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getItemid() {
		return itemid;
	}
	public void setItemid(Integer itemid) {
		this.itemid = itemid;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Integer getReasonid() {
		return reasonid;
	}
	public void setReasonid(Integer reasonid) {
		this.reasonid = reasonid;
	}
}
