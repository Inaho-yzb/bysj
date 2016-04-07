package com.yuzhaibu.service;

import java.util.Map;

public interface AuthenService {

	/**
	 * 查看用户是否有审核的记录
	 * @param userid
	 * @return
	 */
	Integer findUserIsAuthen(Integer userid);

	/**
	 * 添加新的认证记录
	 * @param map
	 * @param savePath
	 * @return
	 */
	Integer addNewAuthen(Map map, String savePath);

}
