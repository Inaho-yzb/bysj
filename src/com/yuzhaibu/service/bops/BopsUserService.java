package com.yuzhaibu.service.bops;

import com.yuzhaibu.entity.bops.query.BopsUserQuery;

public interface BopsUserService {

	void queryList(BopsUserQuery query);

	Integer deleteUser(Integer userid);

}
