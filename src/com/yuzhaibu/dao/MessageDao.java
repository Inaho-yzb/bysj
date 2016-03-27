package com.yuzhaibu.dao;

import java.util.List;
import java.util.Map;

import com.yuzhaibu.entity.Message;

public interface MessageDao {

	/**
	 * 查找用户的未读消息
	 * @param userid
	 * @return
	 */
	List<Message> findAllNotReadMessage(int userid);
	
	/**
	 * item页查找留言
	 * @param itemid
	 * @return
	 */
	List<Message> findItemMessageByItemId(Map map);
	
	/**
	 * 统计留言数
	 * @param itemid
	 * @return
	 */
	Integer findMesCountByItemId(int itemid);

	/**
	 * 用户查看未读消息
	 * @param id
	 * @return
	 */
	Integer checkMesById(Integer id);

	/**
	 * 添加消息
	 * @param mes
	 * @return
	 */
	Integer addMessage(Message mes);
	
}
