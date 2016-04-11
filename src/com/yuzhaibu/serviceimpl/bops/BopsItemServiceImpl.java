package com.yuzhaibu.serviceimpl.bops;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuzhaibu.dao.ItemDao;
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

	@Override
	public void queryList(BopsItemQuery query) {
		
		Integer pageCount = itemDao.queryListCount(query);
		if(pageCount>0){
			List<Item> itemList = itemDao.queryList(query);
			query.setData(itemList);
			query.setTotalCount(pageCount);
		}
	}
	
	
	
}
