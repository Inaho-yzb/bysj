package com.yuzhaibu.dao;

import java.util.List;
import java.util.Map;

import com.yuzhaibu.entity.Message;
import com.yuzhaibu.entity.bops.query.BopsMessageQuery;

public interface MessageDao {

	/**
	 * 查找用户的未读消息
	 * @param userid
	 * @return
	 */
	List<Message> findAllNotReadMessage(Map map);
	
	/**
	 * item页查找留言
	 * @param itemid
	 * @return
	 */
	List<Message> findItemMessageByItemId(Map map);
	
	/**
	 * 统计留言数
	 * @param itemid
	 * @return
	 */
	Integer findMesCountByItemId(int itemid);

	/**
	 * 用户查看未读消息
	 * @param id
	 * @return
	 */
	Integer checkMesById(Integer id);

	/**
	 * 添加消息
	 * @param mes
	 * @return
	 */
	Integer addMessage(Message mes);

	/**
	 * 查找所有未读的消息
	 * @param map
	 * @return
	 */
	Integer finddAllNotReadMessageCount(Map<String, Integer> map);

	/**
	 * 删除该物品的所有评论
	 * @param itemid
	 * @return
	 */
	Integer deleteMesByItemid(Integer itemid);

	/**
	 * 后台评论查看
	 * @param query
	 * @return
	 */
	List<Message> queryList(BopsMessageQuery query);

	Integer queryListCount(BopsMessageQuery query);
	
}
