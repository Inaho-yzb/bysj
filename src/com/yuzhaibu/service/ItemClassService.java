package com.yuzhaibu.service;

import java.util.List;
import java.util.Map;

import com.yuzhaibu.entity.ItemClass;

public interface ItemClassService {
	
	List<ItemClass> findAllFatherClass();
	
	Map<Integer,List<ItemClass>> findSomeChildClassByFatherId(List<ItemClass> fatherId);
	
}
