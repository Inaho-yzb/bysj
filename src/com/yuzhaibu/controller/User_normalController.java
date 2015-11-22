package com.yuzhaibu.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yuzhaibu.entity.Fav;
import com.yuzhaibu.entity.Item;
import com.yuzhaibu.entity.Message;
import com.yuzhaibu.entity.User_normal;
import com.yuzhaibu.service.ItemService;
import com.yuzhaibu.service.MessageService;
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
	private MessageService messageService;
	
	@Resource
	private User_normal usernormal;
	
	@Resource
	private ItemService itemService;
	
	@RequestMapping("/toProfile")
	public String toProfile(HttpSession session,ModelMap model,HttpServletRequest request){
		String username = (String) session.getAttribute("username");
		String tag = request.getParameter("tag");
		
		usernormal = user_normalService.findUserByUsername(username);
		List<Item> items = itemService.findItemByUserId(usernormal.getUsernormal_id());
		List<Fav> favs = itemService.findFavItemByUserId(usernormal.getUsernormal_id());
		List<Message> messages = messageService.findAllNotReadMessageByUserId(usernormal.getUsernormal_id());
		
		int exp = (usernormal.getLevexp()/1000+1)*1000;
		
		model.addAttribute("usernormal",usernormal);
		model.put("nextexp", exp);
		model.addAttribute("items",items);
		model.addAttribute("favs",favs);
		model.addAttribute("messages",messages);
		model.put("tag", tag);
		
		return "profile";
	}
	
	@RequestMapping("/editUsernormalProfile")
	public String editUernormalProfile(User_normal user,HttpServletRequest request,HttpSession session){
		
		user.setUsername((String) session.getAttribute("username"));				
				
		user_normalService.updateUser(user);
		
		return "redirect:toProfile.do";
	}
	
	@RequestMapping("/quit")
	public String quit(HttpSession session){
		session.setAttribute("username", null);
		
		return "redirect:../index.html";
	}

}
