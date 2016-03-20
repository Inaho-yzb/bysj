package com.yuzhaibu.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuzhaibu.dao.ReportDao;
import com.yuzhaibu.entity.Report;
import com.yuzhaibu.service.ReportService;

@Service
public class ReportServiceimpl implements ReportService {
	
	@Autowired
	private ReportDao reportDao;

	@Override
	public Integer isInRep(Integer userid, Integer itemid) {
		Report rep = new Report();
		rep.setItemid(itemid);
		rep.setUserid(userid);
		return reportDao.isInRep(rep);
	}

	@Override
	public Integer addReport(Integer itemid, Integer userid, Integer reasonid) {
		Report rep = new Report();
		rep.setItemid(itemid);
		rep.setUserid(userid);
		rep.setReasonid(reasonid);
		return reportDao.addReport(rep);
	}
	
}
