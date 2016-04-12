package com.yuzhaibu.dao;

import java.util.List;
import java.util.Map;

import com.yuzhaibu.entity.Item;
import com.yuzhaibu.entity.bops.query.BopsItemQuery;

public interface ItemDao {
	
	/**
	 * 用户发布物品列表查询
	 **/
	List<Item> findItemByUserId(Map map);
	
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
	
	/**
	 * 用户发布物品总数
	 * @param map
	 * @return
	 */
	Integer findItemByUserIdCount(Map map);

	/**
	 * 判断该物品是否是属于该用户的
	 * @param userid
	 * @param itemid
	 * @return
	 */
	Integer findItemCountByUseridAndItemId(Map map);

	/**
	 * 更新物品
	 * @param item
	 * @return
	 */
	Integer editItem(Item item);

	/**
	 * 搜索物品
	 * @param keyword
	 * @return
	 */
	List<Item> searchItemByKeyword(Map map);

	Integer searchItemByKeywordCount(Map map);

	/**
	 * 删除物品
	 * @param map
	 * @return
	 */
	Integer deleteItem(Map map);

	/**
	 * 变更状态
	 * @param map
	 * @return
	 */
	Integer changeItemStatus(Map map);
	
	/**
	 * 后台
	 * @param query
	 * @return
	 */
	List<Item> queryList(BopsItemQuery query);

	Integer queryListCount(BopsItemQuery query);

	/**
	 * 后台删除物品
	 * @param itemid
	 * @return
	 */
	Integer deleteItemBops(Integer itemid);
	
}
