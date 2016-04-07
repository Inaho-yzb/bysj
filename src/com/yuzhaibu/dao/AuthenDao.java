package com.yuzhaibu.dao;

import com.yuzhaibu.entity.UserAuthen;

public interface AuthenDao {

	Integer findUserIsAuthen(Integer userid);

	Integer addNewAuthen(UserAuthen userAuthen);
	
}
