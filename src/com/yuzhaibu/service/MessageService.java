package com.yuzhaibu.service;

import java.util.List;

import com.yuzhaibu.entity.Message;

public interface MessageService {
	
	/**
	 * 查找当前用户收到的未读消息
	 * @param userid
	 * @return
	 */
	List<Message> findAllNotReadMessageByUserId(int userid);
	
	List<Message> findInitItemMessageByItemId(int itemid);
	
}