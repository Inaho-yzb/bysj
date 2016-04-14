package com.yuzhaibu.service.bops;

import com.yuzhaibu.entity.bops.SysUser;
import com.yuzhaibu.entity.bops.query.BopsAdminQuery;

public interface BopsAdminService {

	void queryList(BopsAdminQuery query);

	Integer addNewAdmin(SysUser sysUser);

	Integer deleteAdmin(Integer sysid);

}
