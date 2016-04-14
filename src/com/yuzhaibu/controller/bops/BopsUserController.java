package com.yuzhaibu.controller.bops;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuzhaibu.entity.bops.query.BopsUserQuery;
import com.yuzhaibu.service.bops.BopsUserService;
import com.yuzhaibu.util.AjaxResult;

@Controller
public class BopsUserController {
	
	@Autowired
	private BopsUserService bopsUserService;
	
	@RequestMapping(value=("/bops/user"))
	public String toUser(HttpServletRequest request,@ModelAttribute("query") BopsUserQuery query){
		bopsUserService.queryList(query);
		return "/bops/user";
	}
	
	@RequestMapping(value=("/bops/deleteuser"))
	public @ResponseBody AjaxResult deleteUser(HttpServletRequest request){
		Integer userid = Integer.valueOf(request.getParameter("userid"));
		AjaxResult result = new AjaxResult();
		if(bopsUserService.deleteUser(userid)!=0){
			result.setErrorCode(0);
		}else{
			result.setErrorCode(1);
			result.setErrorMes("操作失败！");
		}
		return result;
	}
	
}
