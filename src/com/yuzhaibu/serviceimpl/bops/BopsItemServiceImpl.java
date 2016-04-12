package com.yuzhaibu.serviceimpl.bops;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.yuzhaibu.dao.bops.BopsItemDao;
import com.yuzhaibu.entity.Item;
import com.yuzhaibu.entity.bops.query.BopsItemQuery;
import com.yuzhaibu.entity.bops.query.SysUserQuery;
import com.yuzhaibu.service.bops.BaseService;
import com.yuzhaibu.service.bops.BopsItemService;

@Service
public class BopsItemServiceImpl extends BaseService implements BopsItemService {
	
	@Autowired
	private ItemDao itemDao;
	
	@Autowired
	private ItemImgDao itemImgDao;
	
	@Autowired
	private FavDao favDao;
	
	@Autowired
	private MessageDao messageDao;
	
	@Autowired
	private TransactionTemplate transactionTemplate;
	
	@Autowired
	private ReportDao reportDao;

	@Override
	public void queryList(BopsItemQuery query) {
		
		Integer pageCount = itemDao.queryListCount(query);
		if(pageCount>0){
			List<Item> itemList = itemDao.queryList(query);
			query.setData(itemList);
			query.setTotalCount(pageCount);
		}
	}

	@Override
	public Integer deleteItem(final Integer itemid) {
		return transactionTemplate.execute(new TransactionCallback<Integer>() {
			public Integer doInTransaction(TransactionStatus status){
				try{
					
					if(itemDao.deleteItemBops(itemid)!=0){
						itemImgDao.deleteItemImg(itemid);
						favDao.deleteFavByItemid(itemid);
						messageDao.deleteMesByItemid(itemid);
						reportDao.deleteReportByItemid(itemid);
					}
					return 1;
				}catch(Exception e){
					e.printStackTrace();
					log.error(e.getMessage());
					return -1;
				}
			}
		}
		);
	}
	
	
	
}
