package com.yuzhaibu.dao;

import java.util.List;
import java.util.Map;

import com.yuzhaibu.entity.ItemClass;

public interface ItemClassDao {

	
	/**
	 * 查找所有父类
	 * @return
	 */
	List<ItemClass> findAllFatherClass();
	
	/**
	 * 通过父类id查找一些子类
	 * @param fatherId
	 * @return
	 */
	List<ItemClass> findSomeChildClassByFatherId(int fatherId);
	
	/**
	 * 通过子类id查找父类id，类名
	 * @param classid
	 * @return
	 */
	ItemClass childClassMapper(int classid);
	
	/**
	 * 通过父类ID查找子类列表
	 * @param fid
	 * @return
	 */
	List<ItemClass> findChildItemClassListByFatherId(int fid);

	/**
	 * 通过id查找子类
	 * @param id
	 * @return
	 */
	ItemClass findItemClassById(int id);

	/**
	 * 查找所有子类
	 * @return
	 */
	List<ItemClass> finAllChildClass();

	/**
	 * 查找所有类别
	 * @return
	 */
	List<ItemClass> findAllItemClass();

	Integer updateClass(Map map);
	
}
