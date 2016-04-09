package com.yuzhaibu.service.bops;

import com.yuzhaibu.entity.bops.SysUser;

public interface SysUserService {

	SysUser findSysUserByLoginName(String loginName);

	SysUser loginSysUser(String username, String password);
}
