package com.yuzhaibu.service;

import java.util.Map;

import com.yuzhaibu.entity.User_normal;


public interface User_normalService {
	
	/**
	 * 登录通过用户名密码判断是否成功
	 **/
	User_normal findUserByUsernameAndPwd(String username,String pwd);
	
	/**
	 * 通过用户名查找用户
	 **/
	User_normal findUserByUsername(String username);
	
	/**
	 * 更新用户信息
	 **/
	void updateUser(User_normal usernormal);
	
	/**
	 * 通过物品id查找物品发布者信息
	 * @param itemid
	 * @return
	 */
	User_normal findUserByItemid(int itemid);

	/**
	 * 注册用户
	 * @param user
	 * @return
	 */
	Integer regUser(User_normal user);

	/**
	 * 更改用户头像
	 * @param map
	 * @return
	 */
	Integer editHeadImg(Map map);

	
	Integer addForget(Integer id, String str);

	boolean findForget(String vCode, Integer uid);

	Integer updatePwd(String pwd, Integer uid);

	Integer deleteForget(String vcode, Integer uid);

	Integer deleteForgetById(Integer id);
}
