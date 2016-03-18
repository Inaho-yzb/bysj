package com.yuzhaibu.dao;

import java.util.List;
import java.util.Map;

import com.yuzhaibu.entity.ItemImg;

public interface ItemImgDao {

	int insertNewImg(Map imgMap);

	List<ItemImg> findItemImagesByItemId(int itemid);
}
