package com.yuzhaibu.dao;

import java.util.List;

import com.yuzhaibu.entity.Message;

public interface MessageDao {

	List<Message> findAllNotReadMessage(int userid);
	
	List<Message> findInitItemMessageByItemId(int itemid);
	
}
