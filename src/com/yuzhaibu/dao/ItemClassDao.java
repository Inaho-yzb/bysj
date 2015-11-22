package com.yuzhaibu.dao;

import java.util.List;

import com.yuzhaibu.entity.ItemClass;

public interface ItemClassDao {

	List<ItemClass> findAllFatherClass();
	
	List<ItemClass> findSomeChildClassByFatherId(int fatherId);
	
	ItemClass childClassMapper(int classid);
	
}
