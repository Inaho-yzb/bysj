package com.yuzhaibu.dao;

import java.util.List;

import com.yuzhaibu.entity.User_normal;

public interface User_normalDao {
	
	/**
	 * 通过用户名查找用户
	 **/
	User_normal findByUsername(String username);
	
	/**
	 * 登录通过用户名密码判断是否成功
	 **/
	User_normal findByUsernameAndPwd(String username,String pwd);
	
	/**
	 * 更新用户信息
	 **/
	void updateUser(User_normal usernormal);
	
	User_normal findByItemId(int itemid);
}
