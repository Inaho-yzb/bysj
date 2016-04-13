package com.yuzhaibu.serviceimpl.bops;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuzhaibu.dao.MessageDao;
import com.yuzhaibu.entity.Message;
import com.yuzhaibu.entity.bops.query.BopsMessageQuery;
import com.yuzhaibu.service.bops.BopsMessageService;

@Service
public class BopsMessageServiceImpl implements BopsMessageService {

	@Autowired
	private MessageDao messageDao;
	@Override
	public void queryList(BopsMessageQuery query) {
		Integer pageCount = messageDao.queryListCount(query);
		if(pageCount>0){
			List<Message> itemList = messageDao.queryList(query);
			query.setData(itemList);
			query.setTotalCount(pageCount);
		}
	}
	
}
