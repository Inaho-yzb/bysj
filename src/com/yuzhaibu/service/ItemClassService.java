package com.yuzhaibu.service;

import java.util.List;
import java.util.Map;

import com.yuzhaibu.entity.ItemClass;

public interface ItemClassService {
	
	/**
	 * 查找所有父类类别
	 * @return
	 */
	List<ItemClass> findAllFatherClass();
	
	/**
	 * 通过父类别ID查找指定数目的子类类别（首页）
	 * @param fatherId
	 * @return
	 */
	Map<Integer,List<ItemClass>> findSomeChildClassByFatherId(List<ItemClass> fatherId);
	
	/**
	 * 通过父类类别ID查找子类类别列表
	 * @param fid
	 * @return
	 */
	List<ItemClass> findChildItemClassListByFatherId(int fid);
	
	/**
	 * 通过ID查找类别
	 * @param id
	 * @return
	 */
	ItemClass findItemClassById(int id);

	/**
	 * 查找所有子类
	 * @return
	 */
	List<ItemClass> findAllChildClass();
	
}
