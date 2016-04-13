package com.yuzhaibu.dao;

import java.util.List;

import com.yuzhaibu.entity.Report;
import com.yuzhaibu.entity.bops.query.BopsReportQuery;

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

	/**
	 * 删除该物品的举报
	 * @param itemid
	 * @return
	 */
	Integer deleteReportByItemid(Integer itemid);

	
	Integer queryListCount(BopsReportQuery query);

	/**
	 * 后天查找举报
	 * @param query
	 * @return
	 */
	List<Report> queryList(BopsReportQuery query);

}
