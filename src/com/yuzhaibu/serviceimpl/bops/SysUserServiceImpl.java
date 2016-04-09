package com.yuzhaibu.serviceimpl.bops;

import java.util.HashMap;
import java.util.Map;

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

	@Override
	public SysUser loginSysUser(String username, String password) {
		Map map = new HashMap();
		map.put("username", username);
		map.put("password", password);
		SysUser sysuser = sysUserDao.findSysUserByLoginNameAndPassword(map);
		
		if(sysuser != null){
			return sysuser;
		}else{
			sysuser = new SysUser();
			sysuser.setError("账号密码错误！");
			return sysuser;
		}
	}
	
}
