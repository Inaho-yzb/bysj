package com.yuzhaibu.serviceimpl.bops;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuzhaibu.dao.AuthenDao;
import com.yuzhaibu.entity.UserAuthen;
import com.yuzhaibu.entity.bops.query.BopsAuthenQuery;
import com.yuzhaibu.service.bops.BopsAuthenService;

@Service
public class BopsAuthenServiceImpl implements BopsAuthenService {

	@Autowired
	private AuthenDao authenDao;
	
	@Override
	public void queryList(BopsAuthenQuery query) {
		Integer pageCount = authenDao.queryListCount(query);
		if(pageCount>0){
			List<UserAuthen> authenList = authenDao.queryList(query);
			query.setData(authenList);
			query.setTotalCount(pageCount);
		}
	}
	
}
