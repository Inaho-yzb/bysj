package com.yuzhaibu.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yuzhaibu.dao.ItemClassDao;
import com.yuzhaibu.dao.ItemDao;
import com.yuzhaibu.dao.MessageDao;
import com.yuzhaibu.entity.Fav;
import com.yuzhaibu.entity.Item;
import com.yuzhaibu.entity.ItemClass;
import com.yuzhaibu.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Resource
	private ItemDao itemDao;
	
	@Resource
	private ItemClassDao itemClassDao;
	
	@Resource
	private MessageDao messageDao;
	
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

	@Override
	public Map<Integer, List<Item>> findIndexItemByClass(List<ItemClass> itemClass) {
		Map<Integer,List<Item>> map = new HashMap<Integer,List<Item>>();
		
		for(ItemClass ic:itemClass){
			int id = ic.getItemclass_id();
			List<Item> item = itemDao.findIndexItemByClassId(id);
			
			map.put(id, item);
		}
		
		return map;
	}

	@Override
	public Item findItemByItemId(int itemid) {
		
		Item item = itemDao.findItemByItemId(itemid);
		ItemClass itemClass = itemClassDao.childClassMapper(item.getItemclassid());
		item.setItemClass(itemClass);
		
		return item;
	}

	@Override
	public List<Item> findOtherItemByUserId(int userid) {
		List<Item> item = itemDao.findOtherItemByUserId(userid);
		return item;
	}

	@Override
	public List<Item> findItemListFatherItemByFatherId(int fid) {
		List<Item> items = itemDao.findItemListFatherItemByFatherId(fid);
		for(Item item:items){
			int mescount = messageDao.findMesCountByItemId(item.getItemid());
			int favcount = itemDao.findFavCountByItemId(item.getItemid());
			
			item.setMescount(mescount);
			item.setFavcount(favcount);
		}
		return items;
	}

	@Override
	public List<Item> findItemListByClassId(int id) {
		List<Item> itemList = itemDao.findItemListByClassId(id);
		for(Item item:itemList){
			int mescount = messageDao.findMesCountByItemId(item.getItemid());
			int favcount = itemDao.findFavCountByItemId(item.getItemid());
			
			item.setMescount(mescount);
			item.setFavcount(favcount);
		}
		return itemList;
	}

}
