package com.yuzhaibu.dao;

import java.util.List;

import com.yuzhaibu.entity.User_normal;

public interface User_normalDao {
	
	List<User_normal> findAll();
	
	User_normal findByUsername(String username);
	
	User_normal findByUsernameAndPwd(String username,String pwd);
	
	void updateUser(User_normal usernormal);
}
