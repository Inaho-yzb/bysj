package com.yuzhaibu.service;

public interface FavService {

	/**
	 * 添加收藏
	 * @param itemid
	 * @param serid
	 * @return
	 */
	Integer addToFav(Integer itemid, Integer serid);

	/**
	 * 判断是否已经收藏
	 * @param serid
	 * @param itemid
	 * @return
	 */
	Integer isInFav(Integer serid, Integer itemid);
	
}
