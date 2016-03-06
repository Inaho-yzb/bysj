package com.yuzhaibu.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuzhaibu.entity.User_normal;
import com.yuzhaibu.service.User_normalService;
import com.yuzhaibu.util.AjaxResult;
import com.yuzhaibu.util.StringUtils;

@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {
	
	@Resource
	private User_normalService user_normalService;
	
	@RequestMapping("/toLogin")
	public String toLogin(HttpSession session){
		if(session.getAttribute("username")==null){
			return "login";
		}
		return "redirect:../user/toProfile.htm";
	}
	
	
	
	@RequestMapping("/checkLogin")
	public String login(String username,String pwd,HttpSession session,HttpServletRequest request){
		boolean status = user_normalService.findUserByUsernameAndPwd(username, pwd);
		
		if(status){
			session.setAttribute("username", username);
			return "redirect:../user/toProfile.htm";
		}else{
			request.setAttribute("loginmessage", "用户名密码错误");
			return "login";
		}
	}
	
	@RequestMapping("/toRegistered")
	public String toRegistered(){
		return "registered";
	}
	
	@RequestMapping("/ajaxcheckusername")
	@ResponseBody
	public AjaxResult checkusername(HttpServletRequest request){
		AjaxResult result = new AjaxResult();
		String username = request.getParameter("username");
		if(!StringUtils.isBlank(username)||username.length()>20||!username.matches("[a-zA-Z0-9_.]{6,20}")){
			result.setErrorCode(1);
		}else{
			if(user_normalService.findUserByUsername(username)==null){
				result.setErrorCode(0);
			}else{
				result.setErrorCode(2);
			}
		}
		return result;
	}
	
	@RequestMapping(value=("/reg"),method=RequestMethod.POST)
	public String reg(HttpServletRequest request,ModelMap model,HttpSession session){
		String username = request.getParameter("username");
		String nickname = request.getParameter("nickname");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		
		if(!StringUtils.isBlank(username)||username.length()>20||!username.matches("[a-zA-Z0-9_.]{6,20}")){
			model.addAttribute("errorMes", "请检查用户名是否符合规范！");
			return "loginerror";
		}
		
		if(!StringUtils.isBlank(nickname)||nickname.length()>20||!nickname.matches("[a-zA-Z0-9_.]{6,20}")){
			model.addAttribute("errorMes", "请检查昵称是否符合规范！");
			return "loginerror";
		}
		
		if(!StringUtils.isBlank(pwd)||pwd.length()>15||!pwd.matches("[a-zA-Z0-9]{8,15}")){
			model.addAttribute("errorMes", "请检查密码是否符合规范！");
			return "loginerror";
		}
		
		if(!StringUtils.isBlank(email)||!email.matches("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$")){
			model.addAttribute("errorMes", "请检查邮箱是否符合规范！");
			return "loginerror";
		}
		
		User_normal user = new User_normal();
		user.setUsername(username);
		user.setNickname(nickname);
		user.setPwd(pwd);
		user.setEmail(email);
		
		if(user_normalService.regUser(user)>0){
			session.setAttribute("username", username);
			return "regsuccess";
		}else{
			model.addAttribute("errorMes","注册失败，请稍候再试！");
			return "loginerror";
		}
	}
	
}
