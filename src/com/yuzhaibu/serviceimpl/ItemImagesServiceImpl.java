package com.yuzhaibu.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yuzhaibu.dao.ItemImgDao;
import com.yuzhaibu.entity.ItemImg;
import com.yuzhaibu.service.ItemImagesService;

@Service
public class ItemImagesServiceImpl implements ItemImagesService {
	
	@Resource
	private ItemImgDao itemImgDao;

	@Override
	public List<ItemImg> findItemImagesByItemId(int itemid) {
		return itemImgDao.findItemImagesByItemId(itemid);
	}

}
