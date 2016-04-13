package com.yuzhaibu.serviceimpl.bops;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuzhaibu.dao.User_normalDao;
import com.yuzhaibu.entity.User_normal;
import com.yuzhaibu.entity.bops.query.BopsUserQuery;
import com.yuzhaibu.service.bops.BopsUserService;

@Service
public class BopsUserServiceImpl implements BopsUserService {

	@Autowired
	private User_normalDao userDao;
	
	@Override
	public void queryList(BopsUserQuery query) {
		Integer pageCount = userDao.queryListCount(query);
		if(pageCount>0){
			List<User_normal> userList = userDao.queryList(query);
			query.setData(userList);
			query.setTotalCount(pageCount);
		}
	}
	
}
