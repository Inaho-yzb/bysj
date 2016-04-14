package com.yuzhaibu.controller.bops;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yuzhaibu.entity.bops.query.BopsAdminQuery;
import com.yuzhaibu.service.bops.BopsAdminService;

@Controller
public class BopsSysUserController {

	@Autowired
	private BopsAdminService bopsAdminService;
	
	@RequestMapping(value=("/bops/admin"))
	public String toAdmin(HttpServletRequest request,@ModelAttribute("query") BopsAdminQuery query){
		bopsAdminService.queryList(query);
		return "/bops/admin";
	}
	
	@RequestMapping(value=("/bops/addnewadmin"))
	public String toAddNewAdmin(HttpServletRequest request){
		return "/bops/addnewadmin";
	}
	
}
