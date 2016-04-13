package com.yuzhaibu.serviceimpl.bops;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuzhaibu.dao.ReportDao;
import com.yuzhaibu.entity.Report;
import com.yuzhaibu.entity.bops.query.BopsReportQuery;
import com.yuzhaibu.service.bops.BopsReportService;

@Service
public class BopsReportServiceImpl implements BopsReportService {

	@Autowired
	private ReportDao reportDao;
	
	@Override
	public void queryList(BopsReportQuery query) {
		Integer pageCount = reportDao.queryListCount(query);
		if(pageCount>0){
			List<Report> reportList = reportDao.queryList(query);
			query.setData(reportList);
			query.setTotalCount(pageCount);
		}
	}

}
