package com.yuzhaibu.controller.bops;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yuzhaibu.entity.bops.query.BopsItemQuery;
import com.yuzhaibu.entity.bops.query.SysUserQuery;
import com.yuzhaibu.service.bops.BopsItemService;

@Controller
public class BopsItemController {
	
	@Autowired
	private BopsItemService bopsItemService;
	
	@RequestMapping(value=("/bops/item"))
	public String toItem(HttpServletRequest request,@ModelAttribute("query") BopsItemQuery query,ModelMap model){
		bopsItemService.queryList(query);
		return "/bops/item";
	}
	
}
