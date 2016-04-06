package com.yuzhaibu.dao;

import java.util.List;
import java.util.Map;

import com.yuzhaibu.entity.Fav;

public interface FavDao {

	/**
	 * 添加收藏
	 * @param fav
	 * @return
	 */
	Integer addToFav(Fav fav);
	
	/**
	 * 用户收藏物品列表查询
	 **/
	List<Fav> findFavItemByUserId(Map map);
	
	/**
	 * 收藏数查询
	 * @param itemid
	 * @return
	 */
	Integer findFavCountByItemId(int itemid);

	/**
	 * 判断是否在收藏中
	 * @param fav
	 * @return
	 */
	Integer isInFav(Fav fav);

	Integer findFavItemCountByUserId(Map map);

	/**
	 * 删除物品的所有收藏
	 * @param itemid
	 * @return
	 */
	Integer deleteFavByItemid(Integer itemid);

	/**
	 * 删除收藏
	 * @param fav
	 * @return
	 */
	Integer deleteFav(Fav fav);

}
