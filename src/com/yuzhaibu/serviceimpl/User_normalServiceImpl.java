package com.yuzhaibu.serviceimpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yuzhaibu.dao.User_normalDao;
import com.yuzhaibu.entity.User_normal;
import com.yuzhaibu.service.User_normalService;

@Service
public class User_normalServiceImpl extends BaseManager implements User_normalService {
	
	@Resource
	private User_normalDao user_normalDao;
	
	
	
	@Override
	public User_normal findUserByUsernameAndPwd(String username,String pwd) {
		return user_normalDao.findByUsernameAndPwd(username, pwd); 
	}


	@Override
	public User_normal findUserByUsername(String username) {		
		User_normal user = user_normalDao.findByUsername(username);
		return user;
	}


	@Override
	public void updateUser(User_normal usernormal) {
		user_normalDao.updateUser(usernormal);
		
	}


	@Override
	public User_normal findUserByItemid(int itemid) {
		User_normal user = user_normalDao.findByItemId(itemid);
		return user;
	}


	@Override
	public Integer regUser(User_normal user) {
		return user_normalDao.regUser(user);
	}
	
	
	
}
