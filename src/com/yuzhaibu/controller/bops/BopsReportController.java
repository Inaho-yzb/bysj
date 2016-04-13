package com.yuzhaibu.controller.bops;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yuzhaibu.entity.bops.query.BopsReportQuery;
import com.yuzhaibu.service.bops.BopsReportService;

@Controller
public class BopsReportController {
	
	@Autowired
	private BopsReportService bopsReportService;
	
	@RequestMapping(value=("/bops/report"))
	public String toReport(HttpServletRequest request,@ModelAttribute("query") BopsReportQuery query){
		bopsReportService.queryList(query);
		return "/bops/report";
	}
	
}
