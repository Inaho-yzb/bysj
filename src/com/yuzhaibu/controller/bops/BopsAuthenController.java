package com.yuzhaibu.controller.bops;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BopsAuthenController {

	@RequestMapping(value=("/bops/authen"))
	public String toAuthen(HttpServletRequest request){
		return "/bops/authen";
	}
	
}
