package com.yuzhaibu.controller.bops;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BopsReportController {
	
	@RequestMapping(value=("/bops/report"))
	public String toReport(HttpServletRequest request){
		return "/bops/report";
	}
	
}
