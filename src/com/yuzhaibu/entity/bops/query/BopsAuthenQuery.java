package com.yuzhaibu.entity.bops.query;

import com.yuzhaibu.entity.UserAuthen;
import com.yuzhaibu.util.Pagination;

public class BopsAuthenQuery extends Pagination<UserAuthen> {

	private static final long serialVersionUID = 2102344229190346046L;
	
	private Integer UserId;
	private Integer Status;
	private String StartCreateTime;
	private String EndCreateTime;
	
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
	public Integer getUserId() {
		return UserId;
	}
	public void setUserId(Integer userId) {
		UserId = userId;
	}
	public Integer getStatus() {
		return Status;
	}
	public void setStatus(Integer status) {
		Status = status;
	}
	
	
	
}
