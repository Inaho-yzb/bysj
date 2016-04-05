package com.yuzhaibu.controller;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yuzhaibu.entity.Item;
import com.yuzhaibu.entity.ItemClass;
import com.yuzhaibu.entity.ItemImg;
import com.yuzhaibu.entity.Message;
import com.yuzhaibu.entity.User_normal;
import com.yuzhaibu.service.ItemClassService;
import com.yuzhaibu.service.ItemImagesService;
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
	
	@Resource
	private ItemImagesService itemImagesService;

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
		model.addAttribute("tt","首页");

		return "index";
	}
	
	@RequestMapping(value=("search"),method=RequestMethod.POST)
	public String toSearchResult(HttpServletRequest request,ModelMap model){
		String keyword = request.getParameter("keyword");
		List<Item> itemList = itemService.searchItemByKeyword(keyword);
		model.put("result", itemList);
		model.put("tt", "搜索");
		return "search";
	}

}
