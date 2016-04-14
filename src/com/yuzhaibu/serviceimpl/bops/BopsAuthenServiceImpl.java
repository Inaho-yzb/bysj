package com.yuzhaibu.serviceimpl.bops;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.yuzhaibu.dao.AuthenDao;
import com.yuzhaibu.dao.User_normalDao;
import com.yuzhaibu.entity.UserAuthen;
import com.yuzhaibu.entity.bops.query.BopsAuthenQuery;
import com.yuzhaibu.service.bops.BopsAuthenService;

@Service
public class BopsAuthenServiceImpl implements BopsAuthenService {

	@Autowired
	private AuthenDao authenDao;
	
	@Autowired
	private User_normalDao userDao;
	
	@Autowired
	private TransactionTemplate transactionTemplate;
	
	@Override
	public void queryList(BopsAuthenQuery query) {
		Integer pageCount = authenDao.queryListCount(query);
		if(pageCount>0){
			List<UserAuthen> authenList = authenDao.queryList(query);
			query.setData(authenList);
			query.setTotalCount(pageCount);
		}
	}

	@Override
	public Integer authenUser(final Integer id, final Integer statuss,final Integer sysuserid,final Integer userid) {
		return transactionTemplate.execute(new TransactionCallback<Integer>() {
			public Integer doInTransaction(TransactionStatus status){
				try{
					Map map = new HashMap();
					map.put("id", id);
					map.put("authen", statuss);
					map.put("sysuerid", sysuserid);
					map.put("userid", userid);
					authenDao.authenUser(map);
					if(statuss==1){
						map.put("authen",2);
						userDao.updateAuthen(map);
					}else{
						map.put("authen",0);
						userDao.updateAuthen(map);
					}
					
					return 1;
				}catch(Exception e){
					status.setRollbackOnly(); 
					e.printStackTrace();
					return -1;
				}
			}
		}
		);
	}
	
}
