package com.yuzhaibu.controller.bops;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yuzhaibu.entity.bops.query.BopsMessageQuery;
import com.yuzhaibu.service.bops.BopsMessageService;

@Controller
public class BopsMessageController {
	
	@Autowired
	private BopsMessageService bopsMessageService;
	
	@RequestMapping(value=("/bops/message"))
	public String toMessage(HttpServletRequest request,@ModelAttribute("query") BopsMessageQuery query){
		bopsMessageService.queryList(query);
		return "/bops/message";
	}
	
}
