package com.yuzhaibu.controller;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
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
public class FrontViewController implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5514339438975665140L;

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
		
		model.addAttribute("item",item);
		model.addAttribute("messages",messages);
		model.addAttribute("otherItem",otherItem);
		
		return "item";
	}
	
	@RequestMapping("itemlist")
	public String toItemList(HttpServletRequest request,HttpSession session,ModelMap model){
		String username = (String) session.getAttribute("username");
		if(username!=null){
			model.addAttribute("username",username);
		}
		
		if(request.getParameter("fid")!=null&&request.getParameter("id")==null){
			int fid = Integer.valueOf(request.getParameter("fid"));
			
			List<Item> itemlist = itemService.findItemListFatherItemByFatherId(fid);
			List<ItemClass> itemChildClassList = itemClassService.findChildItemClassListByFatherId(fid);
			ItemClass fatherItemClass = itemClassService.findItemClassById(fid);						
			
			model.addAttribute("itemlist",itemlist);
			model.addAttribute("itemChildClassList",itemChildClassList);
			model.addAttribute("navFatherItemClass",fatherItemClass);
			
		}else if(request.getParameter("fid")==null&&request.getParameter("id")!=null){
			int id = Integer.valueOf(request.getParameter("id"));
			
			ItemClass childItemClass = itemClassService.findItemClassById(id);
			int fid = childItemClass.getItemclass_fatherid();
			ItemClass fatherItemClass = itemClassService.findItemClassById(fid);
			
			List<ItemClass> itemChildClassList = itemClassService.findChildItemClassListByFatherId(fid);
			List<Item> itemList = itemService.findItemListByClassId(id);
			
			model.addAttribute("itemChildClassList",itemChildClassList);
			model.addAttribute("navChildItemClass",childItemClass);
			model.addAttribute("navFatherItemClass",fatherItemClass);
			model.addAttribute("itemlist",itemList);
		}
		
		return "itemlist";
	}

}
