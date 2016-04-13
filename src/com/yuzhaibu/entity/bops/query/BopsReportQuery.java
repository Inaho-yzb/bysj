package com.yuzhaibu.entity.bops.query;

import com.yuzhaibu.entity.Report;
import com.yuzhaibu.util.Pagination;

public class BopsReportQuery extends Pagination<Report> {

	private static final long serialVersionUID = -8569899423572543998L;
	
	private Integer ItemId;
	private String UserNickName;
	public Integer getItemId() {
		return ItemId;
	}
	public void setItemId(Integer itemId) {
		ItemId = itemId;
	}
	public String getUserNickName() {
		return UserNickName;
	}
	public void setUserNickName(String userNickName) {
		UserNickName = userNickName;
	}
	
}
