package com.yuzhaibu.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yuzhaibu.service.User_normalService;

@Controller
@RequestMapping("/user")
public class LoginController {
	
	@Resource
	private User_normalService user_normalService;
	
	@RequestMapping("/login")
	public String login(String username,String pwd,HttpSession session,HttpServletRequest request){
		boolean status = user_normalService.findUserByUsernameAndPwd(username, pwd);
		
		if(status){
			session.setAttribute("username", username);
			return "user/profile";
		}else{
			request.setAttribute("loginmessage", "用户名密码错误");
			return "login";
		}
	}
	
}
