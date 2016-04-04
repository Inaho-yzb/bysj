package com.yuzhaibu.service;

import java.util.List;
import java.util.Map;

import com.yuzhaibu.entity.Message;

public interface MessageService {
	
	/**
	 * 查找当前用户收到的未读消息
	 * @param userid
	 * @return
	 */
	Map findAllNotReadMessageByUserId(Integer userid,Integer index,Integer pageSize);
	
	/**
	 * 物品详情页留言
	 * @param itemid
	 * @return
	 */
	Map findItemMessageByItemId(Integer itemid,Integer index,Integer pageSize);

	/**
	 * 查看未读
	 * @param id
	 * @return
	 */
	Integer checkMesById(Integer id);

	/**
	 * 添加消息
	 * @param userid
	 * @param itemid
	 * @param content
	 * @return
	 */
	Integer addMessage(Integer userid, Integer itemid, String content);
	
}
