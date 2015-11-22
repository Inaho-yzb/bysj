package com.yuzhaibu.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yuzhaibu.entity.Item;
import com.yuzhaibu.entity.ItemClass;
import com.yuzhaibu.entity.Message;
import com.yuzhaibu.entity.User_normal;
import com.yuzhaibu.service.ItemClassService;
import com.yuzhaibu.service.ItemService;
import com.yuzhaibu.service.MessageService;
import com.yuzhaibu.service.User_normalService;

@Controller
public class FrontViewController {

	@Resource
	private User_normal usernormal;

	@Resource
	private User_normalService user_normalService;
	
	@Resource
	private MessageService messageService;
	
	@Resource
	private ItemClassService itemClassService;
	
	@Resource
	private ItemService itemService;

	@RequestMapping("index")
	public String toIndex(HttpSession session, ModelMap model) {
		
		String username = (String) session.getAttribute("username");
		if(username!=null){
			model.addAttribute("username",username);
		}
		
		List<ItemClass> fatherClass = itemClassService.findAllFatherClass();
		Map<Integer,List<ItemClass>> childClass = itemClassService.findSomeChildClassByFatherId(fatherClass);
		Map<Integer,List<Item>> itemList = itemService.findIndexItemByClass(fatherClass);
		
		
		model.addAttribute("fatherClass",fatherClass);
		model.addAttribute("childClass",childClass);
		model.addAttribute("itemList",itemList);

		return "index";
	}
	
	@RequestMapping("item")
	public String toItem(HttpServletRequest request,ModelMap model,HttpSession session){
		String username = (String) session.getAttribute("username");
		if(username!=null){
			model.addAttribute("username",username);
		}
		
		
		int itemid = Integer.valueOf(request.getParameter("id"));		
		Item item = itemService.findItemByItemId(itemid);
		
		User_normal user = user_normalService.findUserByItemid(itemid);
		item.setUsernormal(user);
		
		List<Message> messages = messageService.findInitItemMessageByItemId(itemid);
		
		List<Item> otherItem = itemService.findOtherItemByUserId(user.getUsernormal_id());
		System.out.println(otherItem.size());
		
		model.addAttribute("item",item);
		model.addAttribute("messages",messages);
		model.addAttribute("otherItem",otherItem);
		
		return "item";
	}

}
