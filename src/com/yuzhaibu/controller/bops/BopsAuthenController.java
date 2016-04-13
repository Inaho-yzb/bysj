package com.yuzhaibu.controller.bops;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yuzhaibu.entity.bops.query.BopsAuthenQuery;
import com.yuzhaibu.service.bops.BopsAuthenService;

@Controller
public class BopsAuthenController {

	@Autowired
	private BopsAuthenService bopsAuthenService;
	
	@RequestMapping(value=("/bops/authen"))
	public String toAuthen(HttpServletRequest request,@ModelAttribute("query") BopsAuthenQuery query){
		bopsAuthenService.queryList(query);
		return "/bops/authen";
	}
	
}
