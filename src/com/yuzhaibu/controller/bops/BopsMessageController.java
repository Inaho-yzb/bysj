package com.yuzhaibu.controller.bops;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuzhaibu.entity.bops.query.BopsMessageQuery;
import com.yuzhaibu.service.bops.BopsMessageService;
import com.yuzhaibu.util.AjaxResult;

@Controller
public class BopsMessageController {
	
	@Autowired
	private BopsMessageService bopsMessageService;
	
	@RequestMapping(value=("/bops/message"))
	public String toMessage(HttpServletRequest request,@ModelAttribute("query") BopsMessageQuery query){
		bopsMessageService.queryList(query);
		return "/bops/message";
	}
	
	@RequestMapping(value=("/bops/authenmes"))
	public @ResponseBody AjaxResult authenMes(HttpServletRequest request){
		AjaxResult result = new AjaxResult();
		Integer mesid = Integer.valueOf(request.getParameter("id"));
		Integer status = Integer.valueOf(request.getParameter("status"));
		if(bopsMessageService.authenMes(mesid,status)!=0){
			result.setErrorCode(0);
		}else{
			result.setErrorCode(1);
			result.setErrorMes("操作失败！");
		}
		return result;
	}
	
	@RequestMapping(value=("/bops/deletemes"))
	public @ResponseBody AjaxResult deleteMes(HttpServletRequest request){
		AjaxResult result = new AjaxResult();
		Integer mesid = Integer.valueOf(request.getParameter("mesid"));
		if(bopsMessageService.deleteMes(mesid)!=0){
			result.setErrorCode(0);
		}else{
			result.setErrorCode(1);
			result.setErrorMes("删除失败!");
		}
		return result;
	}
	
}
