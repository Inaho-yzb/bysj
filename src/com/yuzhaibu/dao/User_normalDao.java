package com.yuzhaibu.dao;

import java.util.List;
import java.util.Map;

import com.yuzhaibu.entity.User_normal;
import com.yuzhaibu.entity.bops.query.BopsUserQuery;

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

	/**
	 * 通过用户名查询用户ID
	 * @param username
	 * @return
	 */
	Integer findUserIdByUsername(String username);

	
	/**
	 * 添加经验
	 * @param map
	 * @return
	 */
	Integer addUserExp(Map map);

	/**
	 * 更新审核状态
	 * @param i
	 */
	Integer updateAuthen(Map map);

	/**
	 * 更改用户头像
	 * @param resMap
	 * @return
	 */
	Integer editUserHeadImg(Map resMap);

	/**
	 * 后台用户列表
	 * @param query
	 * @return
	 */
	List<User_normal> queryList(BopsUserQuery query);

	Integer queryListCount(BopsUserQuery query);

	/**
	 * 删除用户
	 * @param userid
	 * @return
	 */
	Integer deleteUser(Integer userid);

	Integer addForget(Map map);

	int findForget(Map map);

	Integer updatePwd(Map map);

	Integer deleteForget(Map map);

	Integer deleteForgetById(Integer id);
}
