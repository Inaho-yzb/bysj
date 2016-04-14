package com.yuzhaibu.serviceimpl.bops;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.yuzhaibu.dao.FavDao;
import com.yuzhaibu.dao.ItemDao;
import com.yuzhaibu.dao.ItemImgDao;
import com.yuzhaibu.dao.MessageDao;
import com.yuzhaibu.dao.ReportDao;
import com.yuzhaibu.dao.User_normalDao;
import com.yuzhaibu.entity.User_normal;
import com.yuzhaibu.entity.bops.query.BopsUserQuery;
import com.yuzhaibu.service.bops.BopsUserService;

@Service
public class BopsUserServiceImpl implements BopsUserService {

	@Autowired
	private User_normalDao userDao;
	
	@Autowired
	private ItemDao itemDao;
	
	@Autowired
	private ItemImgDao itemImgDao;
	
	@Autowired
	private FavDao favDao;
	
	@Autowired
	private ReportDao reportDao;
	
	@Autowired
	private MessageDao messageDao;
	
	@Autowired
	private TransactionTemplate transactionTemplate;
	
	@Override
	public void queryList(BopsUserQuery query) {
		Integer pageCount = userDao.queryListCount(query);
		if(pageCount>0){
			List<User_normal> userList = userDao.queryList(query);
			query.setData(userList);
			query.setTotalCount(pageCount);
		}
	}

	@Override
	public Integer deleteUser(final Integer userid) {
		return transactionTemplate.execute(new TransactionCallback<Integer>() {
			public Integer doInTransaction(TransactionStatus status){
				try{
					if(userDao.deleteUser(userid)!=0){
						List<Integer> itemIdList = itemDao.findItemIdListByUserId(userid);
						itemImgDao.deleteItemImgByItemIdList(itemIdList);
						favDao.deleteFavByItemidList(itemIdList);
						messageDao.deleteMesByItemIdList(itemIdList);
						reportDao.deleteReportByItemidList(itemIdList);
						itemDao.deleteUserItem(userid);
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
