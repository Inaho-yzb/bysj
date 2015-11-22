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
	
	/**
	 * 首页通过父类类别查找物品，返回父类id+物品列表（查找大类下的物品）
	 * @param itemClass
	 * @return
	 */
	Map<Integer,List<Item>> findIndexItemByClass(List<ItemClass> itemClass);
	
	/**
	 * 通过ID查找物品
	 * @param itemid
	 * @return
	 */
	Item findItemByItemId(int itemid);
	
	/**
	 * 查找某用户的其他发布的物品
	 * @param userid
	 * @return
	 */
	List<Item> findOtherItemByUserId(int userid);
	
	/**
	 * 列表页父类下的物品列表
	 * @param fid
	 * @return
	 */
	List<Item> findItemListFatherItemByFatherId(int fid);

	/**
	 * 列表页子类下的物品列表
	 * @param id
	 * @return
	 */
	List<Item> findItemListByClassId(int id);
}
