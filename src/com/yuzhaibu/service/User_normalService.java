package com.yuzhaibu.service;

import com.yuzhaibu.entity.User_normal;


public interface User_normalService {
	
	/**
	 * 登录通过用户名密码判断是否成功
	 **/
	boolean findUserByUsernameAndPwd(String username,String pwd);
	
	/**
	 * 通过用户名查找用户
	 **/
	User_normal findUserByUsername(String username);
	
	/**
	 * 更新用户信息
	 **/
	void updateUser(User_normal usernormal);
	
	User_normal findUserByItemid(int itemid);
}
