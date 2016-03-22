package com.yuzhaibu.dao;

import java.util.List;
import java.util.Map;

import com.yuzhaibu.entity.Fav;
import com.yuzhaibu.entity.Item;

public interface ItemDao {
	
	/**
	 * 用户发布物品列表查询
	 **/
	List<Item> findItemByUserId(Integer sellerid);
	
	/**
	 * 首页通过父类id查找物品
	 * @param classid
	 * @return
	 */
	List<Item> findIndexItemByClassId(Integer classid);
	
	/**
	 * 通过id查找物品
	 * @param itemId
	 * @return
	 */
	Item findItemByItemId(Integer itemId);
	
	/**
	 * 查找用户的其他商品
	 * @param userid
	 * @return
	 */
	List<Item> findOtherItemByUserId(Integer userid);
	
	/**
	 * 列表页父类下的物品列表
	 * @param fid
	 * @return
	 */
	List<Item> findItemListFatherItemByFatherId(Map map);

	/**
	 * 通过类id查找物品
	 * @param id
	 * @return
	 */
	List<Item> findItemListByClassId(Map map);

	/**
	 * 发布新物品
	 * @param item
	 * @return
	 */
	Integer insertNewItem(Item item);

	/**
	 * 添加物品主要图片
	 * @param mainMap
	 * @return
	 */
	Integer updateMainImg(Map mainMap);

	/**
	 * 增加一次浏览次数
	 * @param itemid
	 * @return
	 */
	Integer updateViewTimes(Integer itemid);

	/**
	 * 查询物品数（父类）
	 * @param fid
	 * @return
	 */
	Integer countItemByFatherId(Integer fid);

	/**
	 * 查询物品数（子类）
	 * @param id
	 * @return
	 */
	Integer countItemById(Integer id);
	
}
