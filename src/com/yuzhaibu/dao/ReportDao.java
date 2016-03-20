package com.yuzhaibu.dao;

import com.yuzhaibu.entity.Report;

public interface ReportDao {

	/**
	 * 是否被该用户举报
	 * @param rep
	 * @return
	 */
	Integer isInRep(Report rep);

	/**
	 * 添加举报
	 * @param rep
	 * @return
	 */
	Integer addReport(Report rep);

}
