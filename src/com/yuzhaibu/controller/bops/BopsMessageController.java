package com.yuzhaibu.controller.bops;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BopsMessageController {
	
	@RequestMapping(value=("/bops/message"))
	public String toMessage(HttpServletRequest request){
		return "/bops/message";
	}
	
}
