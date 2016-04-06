package com.yuzhaibu.serviceimpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yuzhaibu.dao.FavDao;
import com.yuzhaibu.entity.Fav;
import com.yuzhaibu.service.FavService;

@Service
public class FavServiceImpl implements FavService {
	
	@Resource
	private FavDao favDao;

	@Override
	public Integer addToFav(Integer itemid, Integer serid) {
		Fav fav = new Fav();
		fav.setItemid(itemid);
		fav.setFavUserId(serid);
		
		return favDao.addToFav(fav);
	}

	@Override
	public Integer isInFav(Integer serid, Integer itemid) {
		Fav fav = new Fav();
		fav.setItemid(itemid);
		fav.setFavUserId(serid);
		
		return favDao.isInFav(fav);
	}

	@Override
	public Integer deletefav(Integer itemid, Integer userid) {
		Fav fav = new Fav();
		fav.setItemid(itemid);
		fav.setFavUserId(userid);
		
		return favDao.deleteFav(fav);
	}
	
}
