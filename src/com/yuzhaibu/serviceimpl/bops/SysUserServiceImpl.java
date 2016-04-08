package com.yuzhaibu.serviceimpl.bops;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuzhaibu.dao.bops.SysUserDao;
import com.yuzhaibu.entity.bops.SysUser;
import com.yuzhaibu.service.bops.BaseService;
import com.yuzhaibu.service.bops.SysUserService;

@Service
public class SysUserServiceImpl extends BaseService implements SysUserService {
	
	@Autowired
	private SysUserDao sysUserDao;

	@Override
	public SysUser findSysUserByLoginName(String loginName) {
		return sysUserDao.findSysUserByLoginName(loginName);
	}
	
}
