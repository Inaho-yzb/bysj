package com.yuzhaibu.dao;

import java.util.List;

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
	List<Message> findInitItemMessageByItemId(int itemid);
	
	/**
	 * 统计留言数
	 * @param itemid
	 * @return
	 */
	int findMesCountByItemId(int itemid);
	
}
