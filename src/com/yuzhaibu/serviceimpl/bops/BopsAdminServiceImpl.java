package com.yuzhaibu.serviceimpl.bops;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuzhaibu.dao.bops.SysUserDao;
import com.yuzhaibu.entity.UserAuthen;
import com.yuzhaibu.entity.bops.SysUser;
import com.yuzhaibu.entity.bops.query.BopsAdminQuery;
import com.yuzhaibu.service.bops.BopsAdminService;

@Service
public class BopsAdminServiceImpl implements BopsAdminService {

	@Autowired
	private SysUserDao sysUserDao;
	
	@Override
	public void queryList(BopsAdminQuery query) {
		Integer pageCount = sysUserDao.queryListCount(query);
		if(pageCount>0){
			List<SysUser> sysUserList = sysUserDao.queryList(query);
			query.setData(sysUserList);
			query.setTotalCount(pageCount);
		}
	}

	@Override
	public Integer addNewAdmin(SysUser sysUser) {
		return sysUserDao.addNewAdmin(sysUser);
	}

	@Override
	public Integer deleteAdmin(Integer sysid) {
		return sysUserDao.deleteAdmin(sysid);
	}
	
}
