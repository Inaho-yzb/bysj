package com.yuzhaibu.controller.bops;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BopsUserController {
	
	@RequestMapping(value=("/bops/user"))
	public String toUser(HttpServletRequest request){
		return "/bops/user";
	}
	
}
