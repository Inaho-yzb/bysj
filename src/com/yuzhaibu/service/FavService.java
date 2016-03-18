package com.yuzhaibu.service;

public interface FavService {

	/**
	 * 添加收藏
	 * @param itemid
	 * @param serid
	 * @return
	 */
	int addToFav(Integer itemid, Integer serid);
	
}
