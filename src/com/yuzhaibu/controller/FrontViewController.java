package com.yuzhaibu.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yuzhaibu.entity.Item;
import com.yuzhaibu.entity.ItemClass;
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
	
	@RequestMapping(value=("search"))
	public String toSearchResult(HttpServletRequest request,ModelMap model){
		String keyword = request.getParameter("keyword");
		String page = request.getParameter("pa");
		String order = request.getParameter("sort");
		Integer toPage;
		if(page==null){
			toPage = 1;
		}else{
			toPage = Integer.valueOf(page);
		}
		Map fromMap = new HashMap();
		fromMap.put("keyword", keyword);
		fromMap.put("toPage", toPage);
		fromMap.put("order", order);
		fromMap.put("pageSize", 8);
		Map map = itemService.searchItemByKeyword(fromMap);
		model.put("itemlist", map.get("itemList"));
		model.put("page", map.get("page"));
		model.addAttribute("tt", "搜索");
		model.put("keyword", keyword);
		model.put("order", order);
		return "search";
	}
	
	@RequestMapping(value=("/random"))
	public String random(HttpServletRequest request){
		List<Integer> itemlist = itemService.findAllItemCount();
		int count = new Random().nextInt(itemlist.size());
		Integer id = itemlist.get(count);
		return "redirect:/item.htm?id="+id;
	}

}
