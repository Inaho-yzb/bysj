package com.yuzhaibu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrontViewController {
	
	@RequestMapping("index.html")
	public String toIndex(){
		return "index";
	}

}
