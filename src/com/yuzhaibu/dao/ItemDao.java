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
	
	/**
	 * 首页通过父类id查找物品
	 * @param classid
	 * @return
	 */
	List<Item> findIndexItemByClassId(int classid);
	
	/**
	 * 通过id查找物品
	 * @param itemId
	 * @return
	 */
	Item findItemByItemId(int itemId);
	
	/**
	 * 查找用户的其他商品
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
	 * 收藏数查询
	 * @param itemid
	 * @return
	 */
	int findFavCountByItemId(int itemid);

	/**
	 * 通过类id查找物品
	 * @param id
	 * @return
	 */
	List<Item> findItemListByClassId(int id);
	
}
