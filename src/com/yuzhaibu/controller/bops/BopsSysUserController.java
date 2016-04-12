package com.yuzhaibu.controller.bops;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BopsSysUserController {

	@RequestMapping(value=("/bops/admin"))
	public String toAdmin(HttpServletRequest request){
		return "/bops/admin";
	}
	
	@RequestMapping(value=("/bops/addnewadmin"))
	public String toAddNewAdmin(HttpServletRequest request){
		return "/bops/addnewadmin";
	}
	
}
