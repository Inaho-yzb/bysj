package com.yuzhaibu.controller.bops;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BopsItemClassController {
	
	@RequestMapping(value=("/bops/class"))
	public String toItemClass(HttpServletRequest request){
		return "/bops/class";
	}
	
}
