package com.yuzhaibu.service;

public interface ReportService {

	/**
	 * 是否已经被举报
	 * @param serid
	 * @param itemid
	 * @return
	 */
	Integer isInRep(Integer userid, Integer itemid);

	/**
	 * 举报物品
	 * @param itemid
	 * @param userid
	 * @param reasonid
	 * @return
	 */
	Integer addReport(Integer itemid, Integer userid, Integer reasonid);
	
}
