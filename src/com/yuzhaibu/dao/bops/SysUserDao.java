package com.yuzhaibu.dao.bops;

import java.util.Map;

import com.yuzhaibu.entity.bops.SysUser;

public interface SysUserDao {

	SysUser findSysUserByLoginName(String loginName);

	SysUser findSysUserByLoginNameAndPassword(Map map);

}
