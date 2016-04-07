package com.yuzhaibu.controller.bops;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SysUserController {
	
	@RequestMapping(value=("/bops/adminlogin"),method=RequestMethod.GET)
	public String toLogin(HttpServletRequest request,HttpSession session){
		if(session.getAttribute("sysid")==null){
			return "/bops/adminlogin";
		}else{
			return "/bops/main";
		}
	}
	
	@RequestMapping(value=("/bops/adminlogin"),method=RequestMethod.POST)
	public String Login(HttpServletRequest request,HttpSession session){
		if(session.getAttribute("sysid")==null){
			return "/bops/adminlogin";
		}else{
			return "/bops/main";
		}
	}
	
}
