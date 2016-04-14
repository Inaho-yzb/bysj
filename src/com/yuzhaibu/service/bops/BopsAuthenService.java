package com.yuzhaibu.service.bops;

import com.yuzhaibu.entity.bops.query.BopsAuthenQuery;

public interface BopsAuthenService {

	void queryList(BopsAuthenQuery query);

	Integer authenUser(Integer id, Integer status,Integer sysuserid,Integer userid);

}
