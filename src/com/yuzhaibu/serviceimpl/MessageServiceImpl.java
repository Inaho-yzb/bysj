package com.yuzhaibu.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yuzhaibu.dao.MessageDao;
import com.yuzhaibu.entity.Message;
import com.yuzhaibu.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {
	
	@Resource
	private MessageDao messageDao;

	@Override
	public List<Message> findAllNotReadMessageByUserId(int userid) {
		List<Message> messages = messageDao.findAllNotReadMessage(userid);
		
		return messages;
	}

	@Override
	public List<Message> findInitItemMessageByItemId(int itemid) {
		List<Message> messages= messageDao.findInitItemMessageByItemId(itemid);
		return messages;
	}

}
