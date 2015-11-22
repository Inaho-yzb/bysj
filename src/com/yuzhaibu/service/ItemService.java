package com.yuzhaibu.service;

import java.util.List;
import java.util.Map;

import com.yuzhaibu.entity.Fav;
import com.yuzhaibu.entity.Item;
import com.yuzhaibu.entity.ItemClass;

public interface ItemService {
	
	/**
	 * 用户发布物品列表查询
	 **/
	List<Item> findItemByUserId(int sellerid);
	
	/**
	 * 用户收藏物品列表查询
	 **/
	List<Fav> findFavItemByUserId(int userid);
	
	Map<Integer,List<Item>> findIndexItemByClass(List<ItemClass> itemClass);
	
	Item findItemByItemId(int itemid);
	
	List<Item> findOtherItemByUserId(int userid);
}
