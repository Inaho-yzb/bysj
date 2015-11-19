package com.yuzhaibu.controller;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yuzhaibu.entity.User_normal;
import com.yuzhaibu.service.User_normalService;

@Controller
@RequestMapping("/user")
public class User_normalController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Resource
	private User_normalService user_normalService;
	
	@Resource
	private User_normal usernormal;
	
	@RequestMapping("/toProfile")
	public String toProfile(HttpSession session,ModelMap model){
		String username = (String) session.getAttribute("username");
		System.out.println(username);
		usernormal = user_normalService.findUserByUsername(username);
		int exp = (usernormal.getLevexp()/1000+1)*1000;
		model.addAttribute("usernormal",usernormal);
		model.put("nextexp", exp);						
		return "profile";
	}
	
	@RequestMapping("/editUsernormalProfile")
	public String editUernormalProfile(HttpServletRequest request,HttpSession session){
		
		usernormal.setUsername((String) session.getAttribute("username"));
		usernormal.setNickname((String) request.getParameter("nickname"));
		usernormal.setMobile((String)request.getParameter("mobile"));
		usernormal.setQq((String) request.getParameter("qq"));
		usernormal.setSchool((String) request.getParameter("school"));
		usernormal.setUserclass((String) request.getParameter("class"));
		
		System.out.println(usernormal.getSchool());
				
		user_normalService.updateUser(usernormal);
		
		return "redirect:toProfile.do";
	}

}
