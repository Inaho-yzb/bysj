package com.yuzhaibu.controller.bops;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuzhaibu.entity.bops.query.BopsItemQuery;
import com.yuzhaibu.service.bops.BopsItemService;
import com.yuzhaibu.util.AjaxResult;

@Controller
public class BopsItemController {
	
	@Autowired
	private BopsItemService bopsItemService;
	
	@RequestMapping(value=("/bops/item"))
	public String toItem(HttpServletRequest request,@ModelAttribute("query") BopsItemQuery query,ModelMap model){
		bopsItemService.queryList(query);
		return "/bops/item";
	}
	
	@RequestMapping(value=("/bops/deleteitem"),method=RequestMethod.POST)
	public @ResponseBody AjaxResult delItem(HttpServletRequest request){
		Integer itemid = Integer.valueOf(request.getParameter("itemid"));
		AjaxResult result = new AjaxResult();
		if(bopsItemService.deleteItem(itemid)>0){
			result.setErrorCode(0);
		}else{
			result.setErrorCode(1);
			result.setErrorMes("操作失败");
		}
		return result;
	}
}
