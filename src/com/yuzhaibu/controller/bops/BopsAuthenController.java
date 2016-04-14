package com.yuzhaibu.controller.bops;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuzhaibu.entity.bops.SysUser;
import com.yuzhaibu.entity.bops.query.BopsAuthenQuery;
import com.yuzhaibu.service.bops.BopsAuthenService;
import com.yuzhaibu.util.AjaxResult;

@Controller
public class BopsAuthenController {

	@Autowired
	private BopsAuthenService bopsAuthenService;
	
	@RequestMapping(value=("/bops/authen"))
	public String toAuthen(HttpServletRequest request,@ModelAttribute("query") BopsAuthenQuery query){
		bopsAuthenService.queryList(query);
		return "/bops/authen";
	}
	
	@RequestMapping(value=("/bops/authenuser"))
	public @ResponseBody AjaxResult authenUser(HttpServletRequest request,HttpSession session){
		AjaxResult result = new AjaxResult();
		Integer id = Integer.valueOf(request.getParameter("id"));
		Integer status = Integer.valueOf(request.getParameter("status"));
		SysUser user = (SysUser)session.getAttribute("sysuser");
		Integer sysuserid = user.getID();
		Integer userid = Integer.valueOf(request.getParameter("userid"));
		if(bopsAuthenService.authenUser(id,status,sysuserid,userid)!=0){
			result.setErrorCode(0);
		}else{
			result.setErrorCode(1);
			result.setErrorMes("操作失败！");
		}
		return result;
	}
}
