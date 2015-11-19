package com.yuzhaibu.service;

import com.yuzhaibu.entity.User_normal;


public interface User_normalService {
	
	boolean findUserByUsernameAndPwd(String username,String pwd);
	
	User_normal findUserByUsername(String username);
	
	void updateUser(User_normal usernormal);
	
}
