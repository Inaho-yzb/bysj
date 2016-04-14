package com.yuzhaibu.entity.bops.query;

import com.yuzhaibu.entity.bops.SysUser;
import com.yuzhaibu.util.Pagination;

public class BopsAdminQuery extends Pagination<SysUser> {

	private static final long serialVersionUID = 1L;
	
	private String LoginName;

	public String getLoginName() {
		return LoginName;
	}

	public void setLoginName(String loginName) {
		LoginName = loginName;
	}

}
