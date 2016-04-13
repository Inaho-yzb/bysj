package com.yuzhaibu.entity.bops.query;

import com.yuzhaibu.entity.Message;
import com.yuzhaibu.util.Pagination;

public class BopsMessageQuery extends Pagination<Message> {

	private static final long serialVersionUID = 1729636439601732862L;
	
	private Integer Itemid;
	private Integer LevUserid;
	private String Content;
	private Integer Status;
	private String StartCreateTime;
	public Integer getItemid() {
		return Itemid;
	}
	public void setItemid(Integer itemid) {
		Itemid = itemid;
	}
	public Integer getLevUserid() {
		return LevUserid;
	}
	public void setLevUserid(Integer levUserid) {
		LevUserid = levUserid;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public Integer getStatus() {
		return Status;
	}
	public void setStatus(Integer status) {
		Status = status;
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
	private String EndCreateTime;
	

}
