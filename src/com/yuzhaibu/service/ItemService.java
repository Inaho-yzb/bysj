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
	Map findItemByUserId(Integer sellerid,Integer index,Integer pageSize);
	
	/**
	 * 用户收藏物品列表查询
	 **/
	Map findFavItemByUserId(Integer userid,Integer index,Integer pageSize);
	
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
	Item findItemByItemId(Integer itemid);
	
	/**
	 * 查找某用户的其他发布的物品
	 * @param userid
	 * @return
	 */
	List<Item> findOtherItemByUserId(Integer userid);
	
	/**
	 * 列表页父类下的物品列表
	 * @param fid
	 * @return
	 */
	Map findItemListFatherItemByFatherId(Integer fid,Integer index,Integer pageSize,String order);

	/**
	 * 列表页子类下的物品列表
	 * @param id
	 * @return
	 */
	Map findItemListByClassId(Integer id,Integer index,Integer pageSize,String order);

	/**
	 * 发布商品
	 * @param map
	 * @param savePath
	 * @return
	 */
	Integer uploadItem(Map map,String savePath);

	/**
	 * 增加浏览次数
	 * @param itemid
	 * @return
	 */
	Integer updateViewTimes(Integer itemid);

	/**
	 * 判断该物品是否是属于该用户的
	 * @param userid
	 * @param itemid
	 * @return
	 */
	Integer findItemCountByUseridAndItemId(Integer userid, Integer itemid);

	/**
	 * 编辑物品
	 * @param item
	 * @return
	 */
	Integer editItem(Item item);

	/**
	 * 搜索物品
	 * @param keyword
	 * @return
	 */
	Map searchItemByKeyword(Map map);

	/**
	 * 删除物品
	 * @param itemid
	 * @return
	 */
	Integer  deleteItem(Integer itemid,Integer userid);

	/**
	 * 更改物品状态
	 * @param itemid
	 * @param status
	 * @param userid
	 * @return
	 */
	int changeItemStatus(Integer itemid, Integer status, Integer userid);

	List<Integer> findAllItemCount();
	
}
