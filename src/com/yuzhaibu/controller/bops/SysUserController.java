package com.yuzhaibu.controller.bops;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuzhaibu.service.bops.SysUserService;
import com.yuzhaibu.util.AjaxResult;
import com.yuzhaibu.util.StringUtils;

@Controller
public class SysUserController {
	
	@Autowired
	private SysUserService sysUserService;
	
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
	
	@RequestMapping(value=("checkuser"),method=RequestMethod.POST)
	public @ResponseBody AjaxResult checkUser(HttpServletRequest request){
		String loginName = request.getParameter("loginName");
		AjaxResult result = new AjaxResult();
		
		if(sysUserService.findSysUserByLoginName(loginName)!=null){
			result.setErrorCode(0);
		}else{
			result.setErrorCode(1);
		}
		
		return result;
	}
	
	@RequestMapping(value=("checkvali"),method=RequestMethod.POST)
	public @ResponseBody AjaxResult checkvali(HttpServletRequest request,HttpSession session){
		String vali = request.getParameter("vali");
		String code = (String) session.getAttribute("code");
		
		AjaxResult result = new AjaxResult();
		if(!StringUtils.isBlank(vali)){
			if(code.equals(vali.toUpperCase())){
				result.setErrorCode(0);
			}else{
				result.setErrorCode(1);
			}
		}else{
			result.setErrorCode(1);
		}
		return result;
	}
	
}
