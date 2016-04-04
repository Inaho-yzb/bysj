package com.yuzhaibu.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yuzhaibu.dao.MessageDao;
import com.yuzhaibu.entity.Message;
import com.yuzhaibu.service.MessageService;
import com.yuzhaibu.util.Page;

@Service
public class MessageServiceImpl extends BaseManager implements MessageService {
	
	@Resource
	private MessageDao messageDao;

	@Override
	public Map findAllNotReadMessageByUserId(Integer userid,Integer index,Integer pageSize) {
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("userid", userid);
		Integer startRow = (index-1)*pageSize;
		map.put("index", startRow);
		map.put("pageSize", pageSize);
		List<Message> messages = messageDao.findAllNotReadMessage(map);
		Integer count = messageDao.finddAllNotReadMessageCount(map);
		Page page = new Page(count,pageSize,index);
		Map resMap = new HashMap();
		resMap.put("messages", messages);
		resMap.put("mespage", page);
		return resMap;
	}

	@Override
	public Map findItemMessageByItemId(Integer itemid,Integer index,Integer pageSize) {
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("itemid", itemid);
		Integer startRow = (index-1)*pageSize;
		map.put("index", startRow);
		map.put("pageSize", pageSize);
		List<Message> mesList= messageDao.findItemMessageByItemId(map);
		Integer count = messageDao.findMesCountByItemId(itemid);
		Page page = new Page(count,pageSize,index);
		
		Map resMap = new HashMap();
		resMap.put("mesList", mesList);
		resMap.put("page", page);
		return resMap;
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
