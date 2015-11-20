package com.yuzhaibu.dao;

import java.util.List;

import com.yuzhaibu.entity.Fav;
import com.yuzhaibu.entity.Item;

public interface ItemDao {
	
	/**
	 * 用户发布物品列表查询
	 **/
	List<Item> findItemByUserId(int sellerid);
	
	/**
	 * 用户收藏物品列表查询
	 **/
	List<Fav> findFavItemByUserId(int userid);
	
}
