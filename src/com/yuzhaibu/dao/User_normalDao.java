package com.yuzhaibu.dao;

import java.util.List;
import java.util.Map;

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
	
	/**
	 * 通过id查找
	 * @param itemid
	 * @return
	 */
	User_normal findByItemId(int itemid);

	/**
	 * 注册用户
	 * @param user
	 * @return
	 */
	Integer regUser(User_normal user);

	Integer findUserIdByUsername(String username);

	int addUserExp(Map map);
}
