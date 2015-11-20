package com.yuzhaibu.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yuzhaibu.dao.ItemDao;
import com.yuzhaibu.entity.Fav;
import com.yuzhaibu.entity.Item;
import com.yuzhaibu.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Resource
	private ItemDao itemDao;
	
	@Resource
	private Item item;

	@Override
	public List<Item> findItemByUserId(int sellerid) {
		
		List<Item> items = itemDao.findItemByUserId(sellerid);
		
		return items;
		
	}

	@Override
	public List<Fav> findFavItemByUserId(int userid) {
		
		List<Fav> favItems = itemDao.findFavItemByUserId(userid);
		
		return favItems;
		
	}

}
