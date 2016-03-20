package com.yuzhaibu.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yuzhaibu.dao.MessageDao;
import com.yuzhaibu.entity.Message;
import com.yuzhaibu.service.MessageService;

@Service
public class MessageServiceImpl extends BaseManager implements MessageService {
	
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

	@Override
	public Integer checkMesById(Integer id) {
		return messageDao.checkMesById(id);
	}

	@Override
	public Integer addMessage(Integer userid, Integer itemid, String content) {
		Message mes = new Message();
		mes.setMes_levuserid(userid);
		mes.setMes_itemid(itemid);
		mes.setMes_content(content);
		
		return messageDao.addMessage(mes);
	}

}
