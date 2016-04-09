package com.yuzhaibu.controller.bops;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuzhaibu.entity.bops.SysUser;
import com.yuzhaibu.service.bops.SysUserService;
import com.yuzhaibu.util.AjaxResult;
import com.yuzhaibu.util.StringUtils;

@Controller
public class SysUserController {
	
	@Autowired
	private SysUserService sysUserService;
	
	@RequestMapping(value=("/bops/adminlogin"),method=RequestMethod.GET)
	public String toLogin(HttpServletRequest request,HttpSession session){
		if(session.getAttribute("sysuserid")==null){
			return "/bops/adminlogin";
		}else{
			return "redirect:../bops/main.htm";
		}
	}
	
	@RequestMapping(value=("/bops/adminlogin"),method=RequestMethod.POST)
	public String Login(HttpServletRequest request,HttpSession session,ModelMap model){
		if(session.getAttribute("sysuserid")==null){
			String verify = request.getParameter("verify");
			String code = (String) session.getAttribute("code");
			if(code.equals(verify.toUpperCase())){
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				SysUser user = sysUserService.loginSysUser(username,password);
				if(user.getError()==null){
					session.setAttribute("sysuserid", user.getID());
					return "redirect:../bops/main.htm";
				}else{
					model.put("error", user.getError());
					return "/bops/adminlogin";
				}
			}else{
				model.put("error", "验证码错误");
				return "/bops/adminlogin";
			}
		}else{
			return "redirect:../bops/main.htm";
		}
	}
	
	@RequestMapping(value=("checkuser"),method=RequestMethod.POST)
	public @ResponseBody AjaxResult checkUser(HttpServletRequest request){
		String loginName = request.getParameter("username");
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
	
	
	@RequestMapping(value=("/bops/main"))
	public String toMain(HttpServletRequest request){
		return "/bops/main";
	}
}
