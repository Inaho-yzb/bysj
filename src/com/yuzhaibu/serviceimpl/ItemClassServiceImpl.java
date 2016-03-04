package com.yuzhaibu.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.yuzhaibu.dao.ItemClassDao;
import com.yuzhaibu.entity.ItemClass;
import com.yuzhaibu.service.ItemClassService;


@Service
public class ItemClassServiceImpl extends BaseManager implements ItemClassService {
	
	@Resource
	private ItemClassDao itemClassDao;
	

	@Override
	public List<ItemClass> findAllFatherClass() {
		List<ItemClass> itemclass = itemClassDao.findAllFatherClass();
		return itemclass;
	}

	@Override
	public Map<Integer, List<ItemClass>> findSomeChildClassByFatherId(List<ItemClass> fatherClass) {
		Map<Integer,List<ItemClass>> childClass = new HashMap<Integer,List<ItemClass>>();
		
		for(ItemClass itm:fatherClass){
			int id = itm.getItemclass_id();
			List<ItemClass> it = itemClassDao.findSomeChildClassByFatherId(id);
			
			childClass.put(id, it);
		}
		
		return childClass;
	}

	@Override
	public List<ItemClass> findChildItemClassListByFatherId(int fid) {
		List<ItemClass> itemClassList = itemClassDao.findChildItemClassListByFatherId(fid);
		return itemClassList;
		
	}

	@Override
	public ItemClass findItemClassById(int id) {
		ItemClass itemClass = itemClassDao.findItemClassById(id);
		
		return itemClass;
	}

}
