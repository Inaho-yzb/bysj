package com.yuzhaibu.dao.bops;

import com.yuzhaibu.entity.bops.SysUser;

public interface SysUserDao {

	SysUser findSysUserByLoginName(String loginName);

	
}
