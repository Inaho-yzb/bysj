package com.yuzhaibu.service.bops;

import com.yuzhaibu.entity.bops.query.BopsMessageQuery;

public interface BopsMessageService {

	void queryList(BopsMessageQuery query);

	Integer authenMes(Integer mesid,Integer status);

	Integer deleteMes(Integer mesid);

}
