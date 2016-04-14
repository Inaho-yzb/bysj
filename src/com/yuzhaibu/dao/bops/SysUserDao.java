package com.yuzhaibu.dao.bops;

import java.util.List;
import java.util.Map;

import com.yuzhaibu.entity.bops.SysUser;
import com.yuzhaibu.entity.bops.query.BopsAdminQuery;

public interface SysUserDao {

	SysUser findSysUserByLoginName(String loginName);

	SysUser findSysUserByLoginNameAndPassword(Map map);

	List<SysUser> queryList(BopsAdminQuery query);

	Integer queryListCount(BopsAdminQuery query);

	Integer addNewAdmin(SysUser sysUser);

	Integer deleteAdmin(Integer sysid);

}
