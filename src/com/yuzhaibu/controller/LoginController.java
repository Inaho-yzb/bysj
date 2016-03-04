package com.yuzhaibu.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yuzhaibu.service.User_normalService;

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
	
	@RequestMapping("/reg")
	public String reg(HttpServletRequest request){
		String username = request.getParameter("username");
		String nickname = request.getParameter("nickname");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		return null;
	}
	
}
