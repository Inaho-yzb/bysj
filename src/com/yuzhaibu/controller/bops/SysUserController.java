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

import com.yuzhaibu.entity.bops.SysUser;
import com.yuzhaibu.entity.bops.query.BopsAdminQuery;
import com.yuzhaibu.service.bops.BopsAdminService;
import com.yuzhaibu.service.bops.SysUserService;
import com.yuzhaibu.util.AjaxResult;
import com.yuzhaibu.util.StringUtils;

@Controller
public class SysUserController {
	
	@Autowired
	private SysUserService sysUserService;
	
	@RequestMapping(value=("/bops/adminlogin"),method=RequestMethod.GET)
	public String toLogin(HttpServletRequest request,HttpSession session){
		if(session.getAttribute("sysuser")==null){
			return "/bops/adminlogin";
		}else{
			return "redirect:../bops/main.htm";
		}
	}
	
	@RequestMapping(value=("/bops/adminlogin"),method=RequestMethod.POST)
	public String Login(HttpServletRequest request,HttpSession session,ModelMap model){
		if(session.getAttribute("sysuser")==null){
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				SysUser user = sysUserService.loginSysUser(username,StringUtils.string2MD5(password));
				if(user.getError()==null){
					session.setAttribute("sysuser", user);
					return "redirect:../bops/main.htm";
				}else{
					model.put("error", user.getError());
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
	
	@RequestMapping(value=("/bops/logout"))
	public String logOut(HttpServletRequest request,HttpSession session){
		session.setAttribute("sysuser", null);
		return "redirect:/bops/adminlogin.htm";
	}
	
	@Autowired
	private BopsAdminService bopsAdminService;
	
	@RequestMapping(value=("/bops/admin"))
	public String toAdmin(HttpServletRequest request,@ModelAttribute("query") BopsAdminQuery query,HttpSession session){
		SysUser user = (SysUser) session.getAttribute("sysuser");
		if(user.getID()==1){
			bopsAdminService.queryList(query);
			return "/bops/admin";
		}
		return null;
		
	}
	
	@RequestMapping(value=("/bops/addnewadmin"),method=RequestMethod.GET)
	public String toAddNewAdmin(HttpServletRequest request,HttpSession session){
		SysUser user = (SysUser) session.getAttribute("sysuser");
		if(user.getID()==1){
			return "/bops/addnewadmin";
		}
		return null;
	}
	
	@RequestMapping(value=("/bops/addnewadmin"),method=RequestMethod.POST)
	public @ResponseBody AjaxResult addNewAdmin(HttpServletRequest request,HttpSession session){
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		AjaxResult result = new AjaxResult();
		SysUser user = (SysUser) session.getAttribute("sysuser");
		if(!StringUtils.isBlank(username)&&!StringUtils.isBlank(password)&&user.getID()==1){
			SysUser sysUser = new SysUser();
			sysUser.setLoginName(username);
			sysUser.setPassword(StringUtils.string2MD5(password));
			if(bopsAdminService.addNewAdmin(sysUser)!=0){
				result.setErrorCode(0);
			}else{
				result.setErrorCode(1);
			}
			
		}else{
			result.setErrorCode(1);
		}
		return result;
	}
	
	@RequestMapping(value=("/bops/deleteadmin"),method=RequestMethod.POST)
	public @ResponseBody AjaxResult deleteAdmin(HttpServletRequest request,HttpSession session){
		SysUser user1 = (SysUser) session.getAttribute("sysuser");
		AjaxResult result = new AjaxResult();
		Integer sysid = Integer.valueOf(request.getParameter("id"));
		if(user1.getID()==1 && sysid!=1){
			if(bopsAdminService.deleteAdmin(sysid)!=0){
				result.setErrorCode(0);
			}
		}else{
			result.setErrorCode(1);
		}
		return result;
	}
}
