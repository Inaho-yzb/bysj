package com.yuzhaibu.service;

import java.util.List;

import com.yuzhaibu.entity.ItemImg;

public interface ItemImagesService {

	List<ItemImg> findItemImagesByItemId(int itemid);
	
}
