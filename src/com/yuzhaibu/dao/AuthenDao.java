package com.yuzhaibu.dao;

import java.util.List;

import com.yuzhaibu.entity.UserAuthen;
import com.yuzhaibu.entity.bops.query.BopsAuthenQuery;

public interface AuthenDao {

	Integer findUserIsAuthen(Integer userid);

	Integer addNewAuthen(UserAuthen userAuthen);

	List<UserAuthen> queryList(BopsAuthenQuery query);

	Integer queryListCount(BopsAuthenQuery query);
	
}
